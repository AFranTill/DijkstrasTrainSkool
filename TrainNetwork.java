
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 14 28/9/23 
 */

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
    private int numberOfNodes;//NEEDS to be intialises
    private String names[] = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Twenty-One", "Twenty-Two", "Twenty-Three", "Twenty-Four", "Twenty-Five", "Twenty-Six", "Twenty-Seven", "Twenty-Eight", "Twenty-Nine", "Thirty", "Thirty-One", "Thirty-Two", "Thirty-Three", "Thirty-Four", "Thirty-Five", "Thirty-Six", "Thirty-Seven", "Thirty-Eight", "Thirty-Nine", "Forty", "Forty-One", "Forty-Two", "Forty-Three", "Forty-Four", "Forty-Five", "Forty-Six", "Forty-Seven", "Forty-Eight", "Forty-Nine", "Fifty", "Fifty-One", "Fifty-Two", "Fifty-Three", "Fifty-Four", "Fifty-Five", "Fifty-Six", "Fifty-Seven", "Fifty-Eight", "Fifty-Nine", "Sixty", "Sixty-One", "Sixty-Two", "Sixty-Three", "Sixty-Four", "Sixty-Five", "Sixty-Six", "Sixty-Seven", "Sixty-Eight", "Sixty-Nine", "Seventy", "Seventy-One", "Seventy-Two", "Seventy-Three", "Seventy-Four", "Seventy-Five", "Seventy-Six", "Seventy-Seven", "Seventy-Eight", "Seventy-Nine", "Eighty", "Eighty-One", "Eighty-Two", "Eighty-Three", "Eighty-Four", "Eighty-Five", "Eighty-Six", "Eighty-Seven", "Eighty-Eight", "Eighty-Nine", "Ninety", "Ninety-One", "Ninety-Two", "Ninety-Three", "Ninety-Four", "Ninety-Five", "Ninety-Six", "Ninety-Seven", "Ninety-Eight", "Ninety-Nine", "One Hundred", "One Hundred One", "One Hundred Two", "One Hundred Three", "One Hundred Four", "One Hundred Five", "One Hundred Six", "One Hundred Seven", "One Hundred Eight", "One Hundred Nine", "One Hundred Ten", "One Hundred Eleven", "One Hundred Twelve", "One Hundred Thirteen", "One Hundred Fourteen", "One Hundred Fifteen", "One Hundred Sixteen", "One Hundred Seventeen", "One Hundred Eighteen", "One Hundred Nineteen", "One Hundred Twenty", "One Hundred Twenty-One", "One Hundred Twenty-Two", "One Hundred Twenty-Three", "One Hundred Twenty-Four", "One Hundred Twenty-Five", "One Hundred Twenty-Six", "One Hundred Twenty-Seven", "One Hundred Twenty-Eight", "One Hundred Twenty-Nine", "One Hundred Thirty", "One Hundred Thirty-One", "One Hundred Thirty-Two", "One Hundred Thirty-Three", "One Hundred Thirty-Four", "One Hundred Thirty-Five", "One Hundred Thirty-Six", "One Hundred Thirty-Seven", "One Hundred Thirty-Eight", "One Hundred Thirty-Nine", "One Hundred Forty", "One Hundred Forty-One", "One Hundred Forty-Two", "One Hundred Forty-Three", "One Hundred Forty-Four", "One Hundred Forty-Five", "One Hundred Forty-Six", "One Hundred Forty-Seven", "One Hundred Forty-Eight", "One Hundred Forty-Nine", "One Hundred Fifty", "One Hundred Fifty-One", "One Hundred Fifty-Two", "One Hundred Fifty-Three", "One Hundred Fifty-Four", "One Hundred Fifty-Five", "One Hundred Fifty-Six", "One Hundred Fifty-Seven", "One Hundred Fifty-Eight", "One Hundred Fifty-Nine", "One Hundred Sixty", "One Hundred Sixty-One", "One Hundred Sixty-Two", "One Hundred Sixty-Three", "One Hundred Sixty-Four", "One Hundred Sixty-Five", "One Hundred Sixty-Six", "One Hundred Sixty-Seven", "One Hundred Sixty-Eight", "One Hundred Sixty-Nine", "One Hundred Seventy", "One Hundred Seventy-One", "One Hundred Seventy-Two", "One Hundred Seventy-Three", "One Hundred Seventy-Four", "One Hundred Seventy-Five", "One Hundred Seventy-Six", "One Hundred Seventy-Seven", "One Hundred Seventy-Eight", "One Hundred Seventy-Nine", "One Hundred Eighty", "One Hundred Eighty-One", "One Hundred Eighty-Two", "One Hundred Eighty-Three", "One Hundred Eighty-Four", "One Hundred Eighty-Five", "One Hundred Eighty-Six", "One Hundred Eighty-Seven", "One Hundred Eighty-Eight", "One Hundred Eighty-Nine", "One Hundred Ninety", "One Hundred Ninety-One", "One Hundred Ninety-Two", "One Hundred Ninety-Three", "One Hundred Ninety-Four", "One Hundred Ninety-Five", "One Hundred Ninety-Six", "One Hundred Ninety-Seven", "One Hundred Ninety-Eight", "One Hundred Ninety-Nine", "Two Hundred", "Two Hundred One", "Two Hundred Two", "Two Hundred Three", "Two Hundred Four", "Two Hundred Five", "Two Hundred Six", "Two Hundred Seven", "Two Hundred Eight", "Two Hundred Nine", "Two Hundred Ten", "Two Hundred Eleven", "Two Hundred Twelve", "Two Hundred Thirteen", "Two Hundred Fourteen", "Two Hundred Fifteen", "Two Hundred Sixteen", "Two Hundred Seventeen", "Two Hundred Eighteen", "Two Hundred Nineteen", "Two Hundred Twenty", "Two Hundred Twenty-One", "Two Hundred Twenty-Two", "Two Hundred Twenty-Three", "Two Hundred Twenty-Four", "Two Hundred Twenty-Five", "Two Hundred Twenty-Six", "Two Hundred Twenty-Seven", "Two Hundred Twenty-Eight", "Two Hundred Twenty-Nine", "Two Hundred Thirty", "Two Hundred Thirty-One", "Two Hundred Thirty-Two", "Two Hundred Thirty-Three", "Two Hundred Thirty-Four", "Two Hundred Thirty-Five", "Two Hundred Thirty-Six", "Two Hundred Thirty-Seven", "Two Hundred Thirty-Eight", "Two Hundred Thirty-Nine", "Two Hundred Forty", "Two Hundred Forty-One", "Two Hundred Forty-Two", "Two Hundred Forty-Three", "Two Hundred Forty-Four", "Two Hundred Forty-Five", "Two Hundred Forty-Six", "Two Hundred Forty-Seven", "Two Hundred Forty-Eight", "Two Hundred Forty-Nine", "Two Hundred Fifty", "Two Hundred Fifty-One", "Two Hundred Fifty-Two", "Two Hundred Fifty-Three", "Two Hundred Fifty-Four", "Two Hundred Fifty-Five", "Two Hundred Fifty-Six", "Two Hundred Fifty-Seven", "Two Hundred Fifty-Eight", "Two Hundred Fifty-Nine", "Two Hundred Sixty", "Two Hundred Sixty-One", "Two Hundred Sixty-Two", "Two Hundred Sixty-Three", "Two Hundred Sixty-Four", "Two Hundred Sixty-Five", "Two Hundred Sixty-Six", "Two Hundred Sixty-Seven", "Two Hundred Sixty-Eight", "Two Hundred Sixty-Nine", "Two Hundred Seventy", "Two Hundred Seventy-One", "Two Hundred Seventy-Two", "Two Hundred Seventy-Three", "Two Hundred Seventy-Four", "Two Hundred Seventy-Five", "Two Hundred Seventy-Six", "Two Hundred Seventy-Seven", "Two Hundred Seventy-Eight", "Two Hundred Seventy-Nine", "Two Hundred Eighty", "Two Hundred Eighty-One", "Two Hundred Eighty-Two", "Two Hundred Eighty-Three", "Two Hundred Eighty-Four", "Two Hundred Eighty-Five", "Two Hundred Eighty-Six", "Two Hundred Eighty-Seven", "Two Hundred Eighty-Eight", "Two Hundred Eighty-Nine", "Two Hundred Ninety", "Two Hundred Ninety-One", "Two Hundred Ninety-Two", "Two Hundred Ninety-Three", "Two Hundred Ninety-Four", "Two Hundred Ninety-Five", "Two Hundred Ninety-Six", "Two Hundred Ninety-Seven", "Two Hundred Ninety-Eight", "Two Hundred Ninety-Nine", "Three Hundred"}; //names for the different nodes
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
        if(networkType == 1){
            numberOfNodes = 6;
        }else if(networkType == 2){
                int toRandomise = returnInteger("Would you like to submit your own number of nodes (1), or shall I randomise one (2)?", 1, 2); 
                if (toRandomise == 1){
                    numberOfNodes = returnInteger("how many nodes do you want? You can have a min of 15 and a max of 100", minNumberOfNodes, maxNumberOfNodes); 
                }else {
                     numberOfNodes = (int) Math.floor(Math.random() *(maxNumberOfNodes - minNumberOfNodes + 1) + minNumberOfNodes);
                }
        }else if (networkType == 3){
            System.out.println("Please provide a text file name");
            filepath = keyboard.nextLine();
            int count = readNumberOfNodes(filepath);
            System.out.println(count + "count");
            numberOfNodes = count;
        
            System.out.println(numberOfNodes);

        }else{
            numberOfNodes = 0;
        }

        int maxNumberOfNodes = numberOfNodes - 1;

        Nodes[] arrayOfNodes = new Nodes[numberOfNodes];

        for(int i = 0; i < numberOfNodes; i++){
            arrayOfNodes[i] = new Nodes(i, names[i], numberOfNodes);
        }

        if(networkType == 1){
            arrayOfLinks.add(new Links(2, arrayOfNodes[0], arrayOfNodes[1]));

            arrayOfLinks.add(new Links(4, arrayOfNodes[0], arrayOfNodes[2]));

            arrayOfLinks.add(new Links(3, arrayOfNodes[1], arrayOfNodes[2]));

            arrayOfLinks.add(new Links(1, arrayOfNodes[1], arrayOfNodes[3]));

            arrayOfLinks.add(new Links(5, arrayOfNodes[1], arrayOfNodes[4]));

            arrayOfLinks.add(new Links(2, arrayOfNodes[2], arrayOfNodes[3]));

            arrayOfLinks.add(new Links(1, arrayOfNodes[3], arrayOfNodes[4]));

            arrayOfLinks.add(new Links(4, arrayOfNodes[3], arrayOfNodes[5]));

            arrayOfLinks.add(new Links(2, arrayOfNodes[4], arrayOfNodes[5]));

        }else if (networkType == 2){

            int minNumberOfLinks = 1;
            int maxNumberOfLinks;

            if(numberOfNodes < 5)maxNumberOfLinks = 1;
            else if(numberOfNodes > 5 && numberOfNodes < 10)maxNumberOfLinks = 2;
            else if(numberOfNodes > 10 && numberOfNodes < 20)maxNumberOfLinks = 3;
            else maxNumberOfLinks = 4;

            boolean goAhead = true;
            for(int firstNodeNumber = 0; firstNodeNumber < numberOfNodes; firstNodeNumber++){
                int numberOfLinksForThisNode = (int) Math.floor(Math.random() *(maxNumberOfLinks - minNumberOfLinks + 1) + minNumberOfLinks); //generates a random number of links for each node
                int[] linkEnds = new int[numberOfLinksForThisNode];

                for(int k = 0; k < numberOfLinksForThisNode; k++){
                    int weight =  (int) Math.floor(Math.random() *(maxNumberOfNodes - 1 + 1) + 1);//WEIGHTS? HELP

                    int secondNodeNumber = randomNumber(numberOfNodes-1, 0, firstNodeNumber, linkEnds);
                    Nodes firstNode = arrayOfNodes[firstNodeNumber];
                    Nodes secondNode = arrayOfNodes[secondNodeNumber];
                    Links currentLink = new Links(weight, firstNode, secondNode);
                    arrayOfLinks.add(currentLink);
                    linkEnds[k] = secondNodeNumber;
                    //System.out.println("went ahead" + secondNodeNumber +", "+ firstNodeNumber);

                }
            }

        }else if (networkType == 3){
            readNetworkDataFromFile(arrayOfNodes, arrayOfLinks, filepath);
        }

        System.out.println("Would you like to contiune (please input y/n)");
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
        ToDoQueue queue = new ToDoQueue();
        queue.addToQueue(arrayOfNodes[firstValue], followerNumber);

        for(Nodes node : arrayOfNodes){
            node.setLinks(arrayOfLinks);
        }

        //System.out.println("gotten to algorithm");
        while(queue.isQueueEmpty() != true){ 

            //System.out.println("new current node");

            // System.out.println("Looking at connections from node " + currentNode.getName());
            ArrayList<Links> linksForThisNode = currentNode.getLinks();
            for(Links link : linksForThisNode){
                //System.out.println("Connection from " + currentNode.getName() + " to " + link.findOtherEnd(currentNode).getName());

                Nodes destNode = link.findOtherEnd(currentNode);
                //System.out.println("Confirming destNode is " + destNode.getName());
                int currentDist = currentNode.getDistance() + link.getWeight();
                //System.out.println("The distance from source node to the destation is " + currentNode.getDistance());
                //System.out.println();
                //System.out.println("The weight of the connection between " + currentNode.getName() + " and " + destNode.getName() + " is " + link.getWeight());
                if(currentDist < destNode.getDistance()){ //update dist if smaller
                    //System.out.println("the current dist: " + currentDist + " is " + currentNode.getDistance() + " + " + link.getWeight() + " current node dist  + link weight " );
                    System.out.println();
                    //System.out.println("This is smaller than the destNode.getDistance, " + destNode.getDistance());
                    destNode.setDistance(currentDist);
                    destNode.setPathBack(currentNode);
                    //System.out.println("pathBack " + destNode.getPathBack().getName());
                    //update dist & prev node here
                    //System.out.println("updated dist " + destNode.getDistance());
                    if(destNode != lastNode){
                        queue.addToQueue(destNode, followerNumber);
                        //System.out.println("added dest " + destNode.getName() + " to queue");
                    }
                }else{
                    //System.out.println("the current dist " + currentDist + " is larger than destNode dist " + destNode.getDistance() + " so not updated");
                }
                slowPrint(0);
            }

            queue.takeFromQueue(followerNumber);
            currentNode = queue.getHead();
        }
        //System.out.println("over");
    }

    public void findLinks(Nodes sourceNode, Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int[] arrayOfDistances, ToDoQueue queue){ //HELP
        for(int i = 0; i < arrayOfLinks.size(); i++){
            Nodes workingNode = arrayOfLinks.get(i).findOtherEnd(sourceNode);
            Links workingLink = arrayOfLinks.get(i);
            if(workingNode != null){
                algorithmPartTwo(workingLink, sourceNode, arrayOfNodes, arrayOfLinks, arrayOfDistances, queue);
            }else{

            }
        }

        //System.out.println("shortest path:"  HELP
    }

    public void algorithmPartTwo(Links workingLink, Nodes sourceNode, Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int[] arrayOfDistances, ToDoQueue queue){
        int weight = workingLink.getWeight();
        Nodes dest = workingLink.findOtherEnd(sourceNode);
        int destLocale = dest.getNumber();
        int sourceLocale = sourceNode.getNumber();
        int costToSource = arrayOfDistances[sourceLocale];
        int costToDest = arrayOfDistances[destLocale];
        int totalCost = costToSource + costToDest;

        //System.out.println("totalCost");
        System.out.println(totalCost);
        //System.out.println("arrayOfDistances[destLocale]");
        System.out.println(arrayOfDistances[destLocale]);

        if(totalCost < arrayOfDistances[destLocale]){
            //System.out.println("crying");
            sourceNode.setDistance(totalCost);
            arrayOfDistances[sourceLocale] = totalCost;
            dest.setPathBack(sourceNode);
            queue.addToQueue(dest, followerNumber);
        }else{
            //System.out.println("unchanged");
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

    public int compare(int[] arrayOfNumbers, int currentNumber, int numberToCompare){
        int firstNumber = arrayOfNumbers[currentNumber];
        int secondNumber = numberToCompare;
        if(firstNumber > secondNumber){
            return secondNumber;
        }else if (secondNumber > firstNumber){
            return firstNumber;
        }else{
            return 1200;
        }
    }

    public int randomNumber(int maxNumber, int minNumber, int cantBe, int[] alsoCantBe){
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

    public void writeToFile(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int numberOfNodes) {
        try {
            FileWriter fileWriter = new FileWriter("train_network.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write data to the file
            bufferedWriter.write(numberOfNodes + "\n");
            
            bufferedWriter.write("Node Information:\n");
            for (Nodes node : arrayOfNodes) {
                bufferedWriter.write(node.getName() + ", " + node.getNumber() + ", " + node.getXCoord() + ", " + node.getYCoord() + "\n");
            }

            bufferedWriter.write("Link Information:\n");
            for (Links link : arrayOfLinks) {
                bufferedWriter.write(link.getStartNode().getNumber() +", " + link.getEndNode().getNumber() +", " + link.getWeight() + "\n");
            }

            // Close the file
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Data has been written to train_network.txt");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    
    public int readingAFile(String fileNameAsAString, int intsOrLines){ 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("We've received your file....");
        File myFile = new File(fileNameAsAString);
        int numberOfLines = 0;
        int numberOfInts = 0;
        try {
            if(intsOrLines == 1){ // reads ints or lines depending on what was passed
                Scanner readTheFileLines = new Scanner(myFile);
                while (readTheFileLines.hasNextLine()){
                    System.out.println(readTheFileLines.nextLine()); // counts the lines up 
                    System.out.println('\u000c'); // clears the creen each time 
                    numberOfLines++;
                }
                System.out.println('\u000c'); // and again for good measure
                return numberOfLines;
            }else if (intsOrLines == 2){ // same as above but for ints
                Scanner readTheFileInts = new Scanner(myFile);
                while (readTheFileInts.hasNextInt()){
                    System.out.print(readTheFileInts.nextInt()); 
                    System.out.println('\u000c');
                    numberOfInts++;
                }
                System.out.println('\u000c');
                return numberOfInts;
            }
            return numberOfLines; // if unspecifcedd, return lines
        }catch(IOException e){
            //and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
            return -1;
        }
    }
    
    

    public int readNumberOfNodes(String filePath) { // HELP
        File myFile = new File(filePath);
        int count;
        try {
             Scanner readTheFile = new Scanner(myFile);
             String firstLine = readTheFile.nextLine();
             System.out.println("hi" + firstLine);
             count = Integer.parseInt(firstLine); //readTheFile.nextInt(); //Integer.parseInt(firstLine);
             System.out.println(count);
             //int numberOfNodes = count;
             
             //System.out.println(numberOfNodes);
                
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
                ArrayList<Nodes> nodes = new ArrayList<>();
                ArrayList<Links> links = new ArrayList<>();

                while (readTheFile.hasNextLine()) { //HELP
                    String line = readTheFile.nextLine();
                    String[] parts = line.split(", ");
                    if(parts.length == 1){
                        
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
                    //line = reader.readLine();//HELP
                }
            }catch(IOException e){//and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        }

            }
        
    public String getFileName(String parametersStatement, boolean forPopulatingAGrid){ //HELP
        Scanner keyboard = new Scanner(System.in);
        System.out.println(parametersStatement);
        System.out.println("For any markers = the files supplied are 'hasAGrid.txt' which can be used to populate a file" );
        System.out.println("and 'thisIWillWriteTo.txt' which can be used to populate with a grid to save it" );
        System.out.println("but of course any supplied grid will also work!" );
        String fileNameString = keyboard.nextLine();
        File namedFile = new File(fileNameString);
        if(namedFile.exists()){
            if(forPopulatingAGrid == false){ // the grid we write over can have anything in it, it doesn't matter as it gets written over
                return fileNameString;
            }else{ // but if you want to read a grid, it needs to have valid contens 
                int areThereAnyLines = readingAFile(fileNameString, 1);
                if(areThereAnyLines < 5){ // if the grid isn't big enough 
                    System.out.println("I'm sorry, that file doesn't have enough lines in it. Either add some more lines or find another file");
                    fileNameString = getFileName(parametersStatement, forPopulatingAGrid); //keeps calling the method until a vsalid file is given 
                    return fileNameString;
                }
                int areThereAnyInts = readingAFile(fileNameString, 2);
                if( areThereAnyInts/areThereAnyLines == areThereAnyLines){ // if there are full lines/and it has enough ints per line
                    return fileNameString;
                }else{
                    System.out.println("I'm sorry, that file doesn't have enough cell values in it. It needs to be a square grid, with as many cells per line as there are lines");
                    fileNameString = getFileName(parametersStatement, forPopulatingAGrid); //keeps calling the method until a vsalid file is given 
                    return fileNameString;
                }
            }
        }else {
            System.out.println("I'm sorry, that doesn't seem to have worked. Please check the parameters and your spelling and try again");
            fileNameString = getFileName(parametersStatement, forPopulatingAGrid); //keeps calling the method until a vsalid file is given 
            return fileNameString;
        }
    }

    public static void printShortestPath(Nodes endNode) {
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

// for(int i = 0; i < arrayOfNodes.length; i++){
// System.out.println(arrayOfNodes[i] + ", ");
// }

// for(int i = 0; i < arrayOfDistances.length; i++){
// System.out.print(arrayOfDistances[i] + ", ");
// }

// for(int i = 0; i < arrayOfLinks.length; i++){
// System.out.println(arrayOfLinks[i].getWeight() + ", ");
// }

//-----------------------
// //RANDOMISES A PATH OF LINKS = NOT VERY GOOD 
// System.out.println(numberOfLinks);
// for(int i = 0; i < numberOfLinks; i++){
// int weight =  (int) Math.floor(Math.random() *(maxNumberOfNodes - 1 + 1) + 1);
// int secondNodeNumber = (int) Math.floor(Math.random() *(maxNumberOfNodes - 0 + 1) + 0);
// if(secondNodeNumber != i){
// Nodes firstNode = arrayOfNodes[i];
// Nodes secondNode = arrayOfNodes[secondNodeNumber];
// arrayOfLinks[i] = new Links(weight, firstNode, secondNode);
// System.out.println("went head" + secondNodeNumber +", "+ i);
// }else{ ///HELP I don't actually think this works but anyways
// System.out.println("didn't go ahead" + i);
// i = i - 1;
// System.out.println("didn't go ahead" + i);
// }

// }    

//-----------------------

// for(int i = 0; i < numberOfLinks; i++){
// System.out.println(arrayOfLinks[i].getWeight() + ", ");
// }

//------------------------

// //CREATES A PRESET LINK Shit

// arrayOfLinks[0] = new Links(2, arrayOfNodes[0], arrayOfNodes[1]);
// arrayOfLinks[1] = new Links(4, arrayOfNodes[0], arrayOfNodes[2]);

// arrayOfLinks[2] = new Links(3, arrayOfNodes[1], arrayOfNodes[2]);
// arrayOfLinks[3] = new Links(1, arrayOfNodes[1], arrayOfNodes[3]);
// arrayOfLinks[4] = new Links(5, arrayOfNodes[1], arrayOfNodes[4]);

// arrayOfLinks[5] = new Links(2, arrayOfNodes[2], arrayOfNodes[3]);

// arrayOfLinks[6] = new Links(1, arrayOfNodes[3], arrayOfNodes[4]);
// arrayOfLinks[7] = new Links(4, arrayOfNodes[3], arrayOfNodes[5]);

// arrayOfLinks[8] = new Links(2, arrayOfNodes[4], arrayOfNodes[5]);

//RANDOMISES A PATH OF LINKS = NOT VERY GOOD 
//System.out.println(numberOfLinks);

//---------------------------
// arrayOfNodes[0].setLinks(arrayOfLinks);

// ArrayList<Links> linksForThisNode = arrayOfNodes[0].getLinks();        
// System.out.println("links for one node");
// for(int i = 0; i < linksForThisNode.size(); i++){
// System.out.print("Link "  + i);
// System.out.println(linksForThisNode.get(i).getEndNode().getName());
// System.out.println(linksForThisNode.get(i).getStartNode().getName());
// System.out.println(linksForThisNode.get(i).getWeight());
// }

// System.out.println("link beginnings");
            // for(int i = 0; i < arrayOfLinks.size(); i++){
            // System.out.println(arrayOfLinks.get(i).getStartNode().getName() + ", ");
            // }

            // System.out.println("Link ends");
            // for(int i = 0; i < arrayOfLinks.size(); i++){
            // System.out.println(arrayOfLinks.get(i).getEndNode().getName() + ", ");
            // }

            // System.out.println("Link Weights");

            // for(int i = 0; i < arrayOfLinks.size(); i++){
            // System.out.println(arrayOfLinks.get(i).getWeight() + ", ");
            // }
