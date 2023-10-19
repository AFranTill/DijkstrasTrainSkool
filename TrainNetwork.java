
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 28 20/10/23 
 */

//IMPORTS
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit; 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.io.File;

public class TrainNetwork
{
    //VARS
    private int numberOfNodes;//NEEDS to be intialises
    private String names[] = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Twenty-One", "Twenty-Two", "Twenty-Three", "Twenty-Four", "Twenty-Five", "Twenty-Six", "Twenty-Seven", "Twenty-Eight", "Twenty-Nine", "Thirty", "Thirty-One", "Thirty-Two", "Thirty-Three", "Thirty-Four", "Thirty-Five", "Thirty-Six", "Thirty-Seven", "Thirty-Eight", "Thirty-Nine", "Forty", "Forty-One", "Forty-Two", "Forty-Three", "Forty-Four", "Forty-Five", "Forty-Six", "Forty-Seven", "Forty-Eight", "Forty-Nine", "Fifty", "Fifty-One", "Fifty-Two", "Fifty-Three", "Fifty-Four", "Fifty-Five", "Fifty-Six", "Fifty-Seven", "Fifty-Eight", "Fifty-Nine", "Sixty", "Sixty-One", "Sixty-Two", "Sixty-Three", "Sixty-Four", "Sixty-Five", "Sixty-Six", "Sixty-Seven", "Sixty-Eight", "Sixty-Nine", "Seventy", "Seventy-One", "Seventy-Two", "Seventy-Three", "Seventy-Four", "Seventy-Five", "Seventy-Six", "Seventy-Seven", "Seventy-Eight", "Seventy-Nine", "Eighty", "Eighty-One", "Eighty-Two", "Eighty-Three", "Eighty-Four", "Eighty-Five", "Eighty-Six", "Eighty-Seven", "Eighty-Eight", "Eighty-Nine", "Ninety", "Ninety-One", "Ninety-Two", "Ninety-Three", "Ninety-Four", "Ninety-Five", "Ninety-Six", "Ninety-Seven", "Ninety-Eight", "Ninety-Nine", "One Hundred"};
    private Nodes arrayOfNodes[]; //intailise the array 
    private int firstValue = 0;
    private ArrayList<Links> arrayOfLinks = new ArrayList<Links>();
    private int arrayOfDistances[];
    private int followerNumber = 0;
    private int graphType;
    private String filepath;
    private int minNumberOfNodes = 15;
    private int maxNumberOfNodes = 100; 

    /**
     * Constructor for objects of class TrainNetwork
     */
    public TrainNetwork()
    {
        Scanner keyboard = new Scanner(System.in);

        int networkType = returnInteger("Would you like a preset graph (1), or a randomised graph (2), or to read from a file (3)?", 1, 3); 
        int numberOfNodes;
        if(networkType == 1){ // preset
            numberOfNodes = 6; 
        }else if(networkType == 2){ // random
                int toRandomise = returnInteger("Would you like to submit your own number of nodes (1), or shall I randomise one (2)?", 1, 2); 
                if (toRandomise == 1){
                    numberOfNodes = returnInteger("how many nodes do you want? You can have a min of 15 and a max of 100", minNumberOfNodes, maxNumberOfNodes); 
                }else {
                     numberOfNodes = (int) Math.floor(Math.random() *(maxNumberOfNodes - minNumberOfNodes + 1) + minNumberOfNodes);
                }
        }else if (networkType == 3){ //file reading
            filepath = getFileName("Please provide a text file name");
            int count = readNumberOfNodes(filepath);
            System.out.println(count + "count");
            numberOfNodes = count;
        
            System.out.println(numberOfNodes);
        }else{ //catch all
            numberOfNodes = 0;
        }

        int maxNumberOfNodes = numberOfNodes - 1;

        Nodes[] arrayOfNodes = new Nodes[numberOfNodes];

        for(int i = 0; i < numberOfNodes; i++){ //populate nodes array 
            arrayOfNodes[i] = new Nodes(i, names[i], numberOfNodes);
        }

        if(networkType == 1){ // set up preset
            arrayOfLinks.add(new Links(2, arrayOfNodes[0], arrayOfNodes[1]));
            arrayOfLinks.add(new Links(4, arrayOfNodes[0], arrayOfNodes[2]));
            arrayOfLinks.add(new Links(3, arrayOfNodes[1], arrayOfNodes[2]));
            arrayOfLinks.add(new Links(1, arrayOfNodes[1], arrayOfNodes[3]));
            arrayOfLinks.add(new Links(5, arrayOfNodes[1], arrayOfNodes[4]));
            arrayOfLinks.add(new Links(2, arrayOfNodes[2], arrayOfNodes[3]));
            arrayOfLinks.add(new Links(1, arrayOfNodes[3], arrayOfNodes[4]));
            arrayOfLinks.add(new Links(4, arrayOfNodes[3], arrayOfNodes[5]));
            arrayOfLinks.add(new Links(2, arrayOfNodes[4], arrayOfNodes[5]));
        }else if (networkType == 2){ //randdomise the network
            int minNumberOfLinks = 1;
            int maxNumberOfLinks;

            //change number of links per node depending on the number of nodes
            if(numberOfNodes < 5)maxNumberOfLinks = 1;
            else if(numberOfNodes > 5 && numberOfNodes < 10)maxNumberOfLinks = 2;
            else if(numberOfNodes > 10 && numberOfNodes < 20)maxNumberOfLinks = 3;
            else maxNumberOfLinks = 4;

            boolean goAhead = true;
            for(int firstNodeNumber = 0; firstNodeNumber < numberOfNodes; firstNodeNumber++){
                int numberOfLinksForThisNode = (int) Math.floor(Math.random() *(maxNumberOfLinks - minNumberOfLinks + 1) + minNumberOfLinks); //generates a random number of links for each node
                int[] linkEnds = new int[numberOfLinksForThisNode]; // creates an array to check against, so we don't get mutple links to one node
                for(int k = 0; k < numberOfLinksForThisNode; k++){
                    int weight =  (int) Math.floor(Math.random() *(maxNumberOfNodes - 1 + 1) + 1);//randomises link weight, ses maxnumberofnodes to emulate a context/travel time
                    int secondNodeNumber = randomNumber(numberOfNodes-1, 0, firstNodeNumber, linkEnds);
                    Nodes firstNode = arrayOfNodes[firstNodeNumber];
                    Nodes secondNode = arrayOfNodes[secondNodeNumber];
                    Links currentLink = new Links(weight, firstNode, secondNode);
                    arrayOfLinks.add(currentLink);
                    linkEnds[k] = secondNodeNumber;
                }
            }

        }else if (networkType == 3){ //reads from file
            readNetworkDataFromFile(arrayOfNodes, arrayOfLinks, filepath);
        }

        System.out.println("Would you like to contiune (please input y/n)"); // allows users to shut it down
        int cont = yesOrNoQuestionMethod(0);

        graphType = networkType;
        if (cont == 1) {
            arrayOfNodes[0].setDistance(0);
            algorithmPartOne(arrayOfNodes, arrayOfLinks);
            printShortestPath(arrayOfNodes[arrayOfNodes.length - 1]);

            GUIMaker gui = new GUIMaker(arrayOfNodes, arrayOfLinks, graphType);
            writeToFile(arrayOfNodes, arrayOfLinks, numberOfNodes); //additional (filewriting)
        }else{
            System.out.println("ok, have a good day!");
        }
    }

    public void algorithmPartOne(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks ){
        Nodes currentNode = arrayOfNodes[firstValue]; // node currently looking at
        int length = arrayOfNodes.length - 1;
        Nodes lastNode = arrayOfNodes[length];
        ToDoQueue queue = new ToDoQueue(); // sets up a queue which can be iterated trhough
        queue.addToQueue(arrayOfNodes[firstValue], followerNumber);

        for(Nodes node : arrayOfNodes){
            node.setLinks(arrayOfLinks);
        }
        
        while(queue.isQueueEmpty() != true){
            ArrayList<Links> linksForThisNode = currentNode.getLinks();
            for(Links link : linksForThisNode){
                Nodes destNode = link.findOtherEnd(currentNode);
                int currentDist = currentNode.getDistance() + link.getWeight();
                if(currentDist < destNode.getDistance()){ //update dist if smaller
                    destNode.setDistance(currentDist);
                    destNode.setPathBack(currentNode); // also updates pathback, which records the node this node would have to go back to on their shortest path
                    if(destNode != lastNode){
                        queue.addToQueue(destNode, followerNumber); // add the node to queue, to keep iterating through
                    }
                }else{
                }
            }
            queue.takeFromQueue(followerNumber);
            currentNode = queue.getHead();
        }
    }

    public void algorithmPartTwo(Links workingLink, Nodes sourceNode, Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int[] arrayOfDistances, ToDoQueue queue){
        // spilt up the algorithm in order to keep the cacluation of the shortest path for a node (whcihc is what this does) clean and seperate 
        int weight = workingLink.getWeight();
        Nodes dest = workingLink.findOtherEnd(sourceNode);
        int destLocale = dest.getNumber();
        int sourceLocale = sourceNode.getNumber();
        int costToSource = arrayOfDistances[sourceLocale];
        int costToDest = arrayOfDistances[destLocale];
        int totalCost = costToSource + costToDest; 
        // does all the maths, then figures out if this new distance is shroter or not

        if(totalCost < arrayOfDistances[destLocale]){ 
            sourceNode.setDistance(totalCost);
            arrayOfDistances[sourceLocale] = totalCost;
            dest.setPathBack(sourceNode);
            queue.addToQueue(dest, followerNumber);
        }else{
        }
    }

    public static void slowPrint(int timeWaiting) { //makes the computer pause for the given amount of time
        timeWaiting = timeWaiting*1000;
        try{
            TimeUnit.MILLISECONDS.sleep(timeWaiting);
        }catch (Exception e){
            System.out.println("sorry the timer isn't working");
        }
    }

    public int randomNumber(int maxNumber, int minNumber, int cantBe, int[] alsoCantBe){ // creates a random number, within certain parameters
        int generatedNumber = (int) Math.floor(Math.random() *(maxNumber - minNumber + 1) + minNumber); 
        boolean goAhead = true; //reset from prev attempt
        for(int comparision : alsoCantBe){ //go through the array and check the gennumber against the array
            if (generatedNumber == comparision){
                goAhead = false; //if it is the same as any number in the array 
            }
        }

        if(generatedNumber != cantBe && goAhead == true){ //if it's unique
            return generatedNumber;
        }else { //recall the function if the gennumber is already in the array/the int it can't be
            return randomNumber(maxNumber, minNumber, cantBe, alsoCantBe); 
        }

    }

    public void writeToFile(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int numberOfNodes) { //writes the current network to a file
        try {
            FileWriter fileWriter = new FileWriter("train_network.txt"); //makes a new file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
            bufferedWriter.write(numberOfNodes + "\n"); //need a number of nodes to intialise array
            
            bufferedWriter.write("Node Information:\n");
            for (Nodes node : arrayOfNodes) {
                bufferedWriter.write(node.getName() + ", " + node.getNumber() + ", " + node.getXCoord() + ", " + node.getYCoord() + "\n");
            }

            bufferedWriter.write("Link Information:\n");
            for (Links link : arrayOfLinks) {
                bufferedWriter.write(link.getStartNode().getNumber() +", " + link.getEndNode().getNumber() +", " + link.getWeight() + "\n");
            }

            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Data has been written to train_network.txt");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    
    
    public int readNumberOfNodes(String filePath) { // Just initalises the size of the array
        File myFile = new File(filePath);
        int count;
        try {
             Scanner readTheFile = new Scanner(myFile);
             String firstLine = readTheFile.nextLine();
             count = Integer.parseInt(firstLine); //The very first line of each file is just how many nodes there are
             System.out.println("number of nodes " + count);
            }catch(IOException e){//and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
            count = 0;
        }
        return count;
            }
            
    public void readNetworkDataFromFile(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, String filePath) {
        File myFile = new File(filePath);
        try {
                Scanner readTheFile = new Scanner(myFile);
                int nodeCount = 0;
                while (readTheFile.hasNextLine()) { 
                    String line = readTheFile.nextLine(); // spilts each line into compoenets. Each different thing (nodes, links titles (unimportant)
                    // has a different number of compoenents, so we can filter by that, like a sieve to udnerstand what should be intialising what 
                    String[] parts = line.split(", ");
                    if(parts.length == 1){
                        //do nothing - this means it was the count, there is a seperate method for that
                    }else if (parts.length == 4) {
                        // Nodes are in the style "nodeName, nodeNumber, X, Y"
                        //the nodeName and number is mostly for readibility (and to differentiate between nodes and links)
                        //here, we just assign the x and y coords to the premade nodes
                        String nodeName = parts[0];
                        int xCoord = Integer.parseInt(parts[2]);
                        int yCoord = Integer.parseInt(parts[3]);
                        arrayOfNodes[nodeCount].setXCoord(xCoord);
                        arrayOfNodes[nodeCount].setYCoord(yCoord);
                        nodeCount++;
                    } else if (parts.length == 3) {
                        // links are in the style "startNodeNumber, endNodeNumber, Weight"
                        int startNodeNumber = Integer.parseInt(parts[0]);
                        int endNodeNumber = Integer.parseInt(parts[1]);
                        int weight = Integer.parseInt(parts[2]);
                        Nodes startNode = arrayOfNodes[startNodeNumber];
                        Nodes endNode = arrayOfNodes[endNodeNumber];
                        if (startNode != null && endNode != null) {
                            Links link = new Links(weight, startNode, endNode);
                            arrayOfLinks.add(link);
                        }
                    }
                }
            }catch(IOException e){//and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        }

            }
        
    public String getFileName(String parametersStatement){  // checks the filename you gave is real 
        Scanner keyboard = new Scanner(System.in);
        System.out.println(parametersStatement);
        System.out.println("For any markers = the files supplied is 'train_network.txt' which is populated after every iteration" );
        System.out.println("but of course any supplied grid will also work!" );
        String fileNameString = keyboard.nextLine();
        File namedFile = new File(fileNameString);
        if(namedFile.exists()){
            return fileNameString;
        }else {
            System.out.println("I'm sorry, that doesn't seem to have worked. Please check the parameters and your spelling and try again");
            fileNameString = getFileName(parametersStatement); //keeps calling the method until a vsalid file is given 
            return fileNameString;
        }
    }

    public static void printShortestPath(Nodes endNode) { // just prints the shortest path 
        Nodes currentNode = endNode;
        System.out.print("Shortest Path: ");
        while (currentNode != null) {
            System.out.print(currentNode.getName());
            if (currentNode.getPathBack() != null) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.getPathBack();
        }
        System.out.println();
    }

    public int returnInteger(String question, int minParameter, int maxParameter){//allows for flexbility/games doesn't crash if a question recieves a non-int input
        Scanner keyboard = new Scanner(System.in);
        int intReceived = 0;
        try {
            System.out.println(question); //it will reprint the question everytime so the user is reminded of what to input
            intReceived = keyboard.nextInt();
            if(intReceived >= minParameter && intReceived <= maxParameter){ //this means I can just have one method for validity & within parameters
                return intReceived; //will only return the inputted int if it is both within the Parameters and is valid
            }else{
                System.out.println("Sorry, that doesn't seem quite right? Check you inputted a number that fits the parameters.");
                intReceived = returnInteger(question, minParameter, maxParameter); //calls method again until it receives a valid input
                return intReceived;
            }
        }catch(Exception e){ 
            System.out.println("Sorry, that doesn't seem quite right? Check you inputted a number that fits the parameters.");
            intReceived = returnInteger(question, minParameter, maxParameter);//calls method again until it receives a valid input
            return intReceived; 
        }
    }

    public int yesOrNoQuestionMethod(int yesOrNo){ 
        Scanner keyboard = new Scanner(System.in); 
        //takes userInput, mainuplates it into the simplest form, so it can compare to the simplest form in the if statement
        String userInput = keyboard.nextLine(); //creates 'userInput' as a string variable, assigns it the just receieved input
        userInput = userInput.toLowerCase().trim(); //converts it to lowercase and trims it 

        if(userInput.equals("yes")||userInput.equals("y")){ //if it receives yes
            yesOrNo = 1;
        }else if (userInput.equals("no")||userInput.equals("n")){ //if it receives no
            yesOrNo = 2;
        }else{ //if it gets an invalid answer
            System.out.println("sorry that was an invalid input. Try yes or no, or y/n");
            yesOrNo = yesOrNoQuestionMethod(1); //calls method again until it gets a valid answer
        }
        return yesOrNo;
    }
}