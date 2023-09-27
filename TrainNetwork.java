
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 12 17/7/23 
 */

import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit; 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;


public class TrainNetwork
{
    private int numberOfNodes;//NEEDS to be intialises
    private String names[] = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Twenty-One", "Twenty-Two", "Twenty-Three", "Twenty-Four", "Twenty-Five", "Twenty-Six", "Twenty-Seven", "Twenty-Eight", "Twenty-Nine", "Thirty", "Thirty-One", "Thirty-Two", "Thirty-Three", "Thirty-Four", "Thirty-Five", "Thirty-Six", "Thirty-Seven", "Thirty-Eight", "Thirty-Nine", "Forty", "Forty-One", "Forty-Two", "Forty-Three", "Forty-Four", "Forty-Five", "Forty-Six", "Forty-Seven", "Forty-Eight", "Forty-Nine", "Fifty", "Fifty-One", "Fifty-Two", "Fifty-Three", "Fifty-Four", "Fifty-Five", "Fifty-Six", "Fifty-Seven", "Fifty-Eight", "Fifty-Nine", "Sixty", "Sixty-One", "Sixty-Two", "Sixty-Three", "Sixty-Four", "Sixty-Five", "Sixty-Six", "Sixty-Seven", "Sixty-Eight", "Sixty-Nine", "Seventy", "Seventy-One", "Seventy-Two", "Seventy-Three", "Seventy-Four", "Seventy-Five", "Seventy-Six", "Seventy-Seven", "Seventy-Eight", "Seventy-Nine", "Eighty", "Eighty-One", "Eighty-Two", "Eighty-Three", "Eighty-Four", "Eighty-Five", "Eighty-Six", "Eighty-Seven", "Eighty-Eight", "Eighty-Nine", "Ninety", "Ninety-One", "Ninety-Two", "Ninety-Three", "Ninety-Four", "Ninety-Five", "Ninety-Six", "Ninety-Seven", "Ninety-Eight", "Ninety-Nine", "One Hundred", "One Hundred One", "One Hundred Two", "One Hundred Three", "One Hundred Four", "One Hundred Five", "One Hundred Six", "One Hundred Seven", "One Hundred Eight", "One Hundred Nine", "One Hundred Ten", "One Hundred Eleven", "One Hundred Twelve", "One Hundred Thirteen", "One Hundred Fourteen", "One Hundred Fifteen", "One Hundred Sixteen", "One Hundred Seventeen", "One Hundred Eighteen", "One Hundred Nineteen", "One Hundred Twenty", "One Hundred Twenty-One", "One Hundred Twenty-Two", "One Hundred Twenty-Three", "One Hundred Twenty-Four", "One Hundred Twenty-Five", "One Hundred Twenty-Six", "One Hundred Twenty-Seven", "One Hundred Twenty-Eight", "One Hundred Twenty-Nine", "One Hundred Thirty", "One Hundred Thirty-One", "One Hundred Thirty-Two", "One Hundred Thirty-Three", "One Hundred Thirty-Four", "One Hundred Thirty-Five", "One Hundred Thirty-Six", "One Hundred Thirty-Seven", "One Hundred Thirty-Eight", "One Hundred Thirty-Nine", "One Hundred Forty", "One Hundred Forty-One", "One Hundred Forty-Two", "One Hundred Forty-Three", "One Hundred Forty-Four", "One Hundred Forty-Five", "One Hundred Forty-Six", "One Hundred Forty-Seven", "One Hundred Forty-Eight", "One Hundred Forty-Nine", "One Hundred Fifty", "One Hundred Fifty-One", "One Hundred Fifty-Two", "One Hundred Fifty-Three", "One Hundred Fifty-Four", "One Hundred Fifty-Five", "One Hundred Fifty-Six", "One Hundred Fifty-Seven", "One Hundred Fifty-Eight", "One Hundred Fifty-Nine", "One Hundred Sixty", "One Hundred Sixty-One", "One Hundred Sixty-Two", "One Hundred Sixty-Three", "One Hundred Sixty-Four", "One Hundred Sixty-Five", "One Hundred Sixty-Six", "One Hundred Sixty-Seven", "One Hundred Sixty-Eight", "One Hundred Sixty-Nine", "One Hundred Seventy", "One Hundred Seventy-One", "One Hundred Seventy-Two", "One Hundred Seventy-Three", "One Hundred Seventy-Four", "One Hundred Seventy-Five", "One Hundred Seventy-Six", "One Hundred Seventy-Seven", "One Hundred Seventy-Eight", "One Hundred Seventy-Nine", "One Hundred Eighty", "One Hundred Eighty-One", "One Hundred Eighty-Two", "One Hundred Eighty-Three", "One Hundred Eighty-Four", "One Hundred Eighty-Five", "One Hundred Eighty-Six", "One Hundred Eighty-Seven", "One Hundred Eighty-Eight", "One Hundred Eighty-Nine", "One Hundred Ninety", "One Hundred Ninety-One", "One Hundred Ninety-Two", "One Hundred Ninety-Three", "One Hundred Ninety-Four", "One Hundred Ninety-Five", "One Hundred Ninety-Six", "One Hundred Ninety-Seven", "One Hundred Ninety-Eight", "One Hundred Ninety-Nine", "Two Hundred", "Two Hundred One", "Two Hundred Two", "Two Hundred Three", "Two Hundred Four", "Two Hundred Five", "Two Hundred Six", "Two Hundred Seven", "Two Hundred Eight", "Two Hundred Nine", "Two Hundred Ten", "Two Hundred Eleven", "Two Hundred Twelve", "Two Hundred Thirteen", "Two Hundred Fourteen", "Two Hundred Fifteen", "Two Hundred Sixteen", "Two Hundred Seventeen", "Two Hundred Eighteen", "Two Hundred Nineteen", "Two Hundred Twenty", "Two Hundred Twenty-One", "Two Hundred Twenty-Two", "Two Hundred Twenty-Three", "Two Hundred Twenty-Four", "Two Hundred Twenty-Five", "Two Hundred Twenty-Six", "Two Hundred Twenty-Seven", "Two Hundred Twenty-Eight", "Two Hundred Twenty-Nine", "Two Hundred Thirty", "Two Hundred Thirty-One", "Two Hundred Thirty-Two", "Two Hundred Thirty-Three", "Two Hundred Thirty-Four", "Two Hundred Thirty-Five", "Two Hundred Thirty-Six", "Two Hundred Thirty-Seven", "Two Hundred Thirty-Eight", "Two Hundred Thirty-Nine", "Two Hundred Forty", "Two Hundred Forty-One", "Two Hundred Forty-Two", "Two Hundred Forty-Three", "Two Hundred Forty-Four", "Two Hundred Forty-Five", "Two Hundred Forty-Six", "Two Hundred Forty-Seven", "Two Hundred Forty-Eight", "Two Hundred Forty-Nine", "Two Hundred Fifty", "Two Hundred Fifty-One", "Two Hundred Fifty-Two", "Two Hundred Fifty-Three", "Two Hundred Fifty-Four", "Two Hundred Fifty-Five", "Two Hundred Fifty-Six", "Two Hundred Fifty-Seven", "Two Hundred Fifty-Eight", "Two Hundred Fifty-Nine", "Two Hundred Sixty", "Two Hundred Sixty-One", "Two Hundred Sixty-Two", "Two Hundred Sixty-Three", "Two Hundred Sixty-Four", "Two Hundred Sixty-Five", "Two Hundred Sixty-Six", "Two Hundred Sixty-Seven", "Two Hundred Sixty-Eight", "Two Hundred Sixty-Nine", "Two Hundred Seventy", "Two Hundred Seventy-One", "Two Hundred Seventy-Two", "Two Hundred Seventy-Three", "Two Hundred Seventy-Four", "Two Hundred Seventy-Five", "Two Hundred Seventy-Six", "Two Hundred Seventy-Seven", "Two Hundred Seventy-Eight", "Two Hundred Seventy-Nine", "Two Hundred Eighty", "Two Hundred Eighty-One", "Two Hundred Eighty-Two", "Two Hundred Eighty-Three", "Two Hundred Eighty-Four", "Two Hundred Eighty-Five", "Two Hundred Eighty-Six", "Two Hundred Eighty-Seven", "Two Hundred Eighty-Eight", "Two Hundred Eighty-Nine", "Two Hundred Ninety", "Two Hundred Ninety-One", "Two Hundred Ninety-Two", "Two Hundred Ninety-Three", "Two Hundred Ninety-Four", "Two Hundred Ninety-Five", "Two Hundred Ninety-Six", "Two Hundred Ninety-Seven", "Two Hundred Ninety-Eight", "Two Hundred Ninety-Nine", "Three Hundred"}; //names for the different nodes
    private Nodes arrayOfNodes[]; //intailise the array 
    private int firstValue = 0;
    //private Links arrayOfLinks[];
    private ArrayList<Links> arrayOfLinks = new ArrayList<Links>();
    private int arrayOfDistances[];
    private int followerNumber = 0;
    private int graphType;

    /**
     * Constructor for objects of class TrainNetwork
     */
    public TrainNetwork()
    {
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("how many nodes do you want?");
        numberOfNodes = keyboard.nextInt();
        int maxNumberOfNodes = numberOfNodes - 1;
        //create a name for the node  

        Nodes[] arrayOfNodes = new Nodes[numberOfNodes];
        //numberOfLinks = 9;
       
        System.out.println("and what graph type?");
        graphType = keyboard.nextInt();
        
        for(int i = 0; i < numberOfNodes; i++){
            arrayOfNodes[i] = new Nodes(i, names[i], numberOfNodes);
        }

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
        
        int minNumberOfLinks = 1;
        int maxNumberOfLinks = 2;
        
        
        
        boolean goAhead = true;
        for(int firstNodeNumber = 0; firstNodeNumber < numberOfNodes; firstNodeNumber++){
            int numberOfLinksForThisNode = (int) Math.floor(Math.random() *(maxNumberOfLinks - minNumberOfLinks + 1) + minNumberOfLinks);
            //System.out.println("this node is: " + arrayOfNodes[firstNodeNumber].getName());
            //System.out.println("the number Of links are " + numberOfLinksForThisNode);
            int[] linkEnds = new int[numberOfLinksForThisNode];
            
            for(int k = 0; k < numberOfLinksForThisNode; k++){
                int weight =  (int) Math.floor(Math.random() *(maxNumberOfNodes - 1 + 1) + 1);//WEIGHTS? HELP

                int secondNodeNumber = randomNumber(numberOfNodes-1, 0, firstNodeNumber, linkEnds);
                Nodes firstNode = arrayOfNodes[firstNodeNumber];
                Nodes secondNode = arrayOfNodes[secondNodeNumber];
                Links currentLink = new Links(weight, firstNode, secondNode);
                arrayOfLinks.add(currentLink);
                linkEnds[k] = secondNodeNumber;
                System.out.println("went ahead" + secondNodeNumber +", "+ firstNodeNumber);

            }
        }

        System.out.println("link beginnings");
        for(int i = 0; i < arrayOfLinks.size(); i++){
            System.out.println(arrayOfLinks.get(i).getStartNode().getName() + ", ");
        }

        System.out.println("Link ends");
        for(int i = 0; i < arrayOfLinks.size(); i++){
            System.out.println(arrayOfLinks.get(i).getEndNode().getName() + ", ");
        }

        System.out.println("Link Weights");

        for(int i = 0; i < arrayOfLinks.size(); i++){
            System.out.println(arrayOfLinks.get(i).getWeight() + ", ");
        }

        // arrayOfNodes[0].setLinks(arrayOfLinks);

        // ArrayList<Links> linksForThisNode = arrayOfNodes[0].getLinks();        
        // System.out.println("links for one node");
        // for(int i = 0; i < linksForThisNode.size(); i++){
        // System.out.print("Link "  + i);
        // System.out.println(linksForThisNode.get(i).getEndNode().getName());
        // System.out.println(linksForThisNode.get(i).getStartNode().getName());
        // System.out.println(linksForThisNode.get(i).getWeight());
        // }

        System.out.println("do you wanna contiune?");
        int yes = keyboard.nextInt();
        arrayOfNodes[0].setDistance(0);

        algorithmPartOne(arrayOfNodes, arrayOfLinks);

        System.out.println("yyayyyayyayay");

        GUIMaker gui = new GUIMaker(arrayOfNodes, arrayOfLinks, graphType);
        //gui.repaint();
        
         writeToFile(arrayOfNodes, arrayOfLinks); //additional (filewriting)

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

            System.out.println("new current node");

            System.out.println("Looking at connections from node " + currentNode.getName());
            ArrayList<Links> linksForThisNode = currentNode.getLinks();
            for(Links link : linksForThisNode){
                System.out.println("Connection from " + currentNode.getName() + " to " + link.findOtherEnd(currentNode).getName());

                Nodes destNode = link.findOtherEnd(currentNode);
                System.out.println("Confirming destNode is " + destNode.getName());
                System.out.println();
                int currentDist = currentNode.getDistance() + link.getWeight();
                System.out.println("The distance from source node to the destation is " + currentNode.getDistance());
                System.out.println();
                System.out.println("The weight of the connection between " + currentNode.getName() + " and " + destNode.getName() + " is " + link.getWeight());
                if(currentDist < destNode.getDistance()){ //update dist if smaller
                    System.out.println("the current dist: " + currentDist + " is " + currentNode.getDistance() + " + " + link.getWeight() + " current node dist  + link weight " );
                    System.out.println();
                    System.out.println("This is smaller than the destNode.getDistance, " + destNode.getDistance());
                    destNode.setDistance(currentDist);
                    destNode.setPathBack(currentNode);
                    System.out.println("pathBack " + destNode.getPathBack().getName());
                    //update dist & prev node here
                    System.out.println("updated dist " + destNode.getDistance());
                    if(destNode != lastNode){
                        queue.addToQueue(destNode, followerNumber);
                        System.out.println("added dest " + destNode.getName() + " to queue");
                    }
                }else{
                    System.out.println("the current dist " + currentDist + " is larger than destNode dist " + destNode.getDistance() + " so not updated");
                }
                slowPrint(0);
            }

            queue.takeFromQueue(followerNumber);
            currentNode = queue.getHead();
        }
        System.out.println("over");
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
    }

    public void algorithmPartTwo(Links workingLink, Nodes sourceNode, Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int[] arrayOfDistances, ToDoQueue queue){
        int weight = workingLink.getWeight();
        Nodes dest = workingLink.findOtherEnd(sourceNode);
        int destLocale = dest.getNumber();
        System.out.println("destLocale");
        System.out.println(destLocale);
        int sourceLocale = sourceNode.getNumber();
        System.out.println(sourceNode.getName());
        System.out.println(sourceNode.getNumber());
        System.out.println(arrayOfDistances[sourceLocale]);
        int costToSource = arrayOfDistances[sourceLocale];
        int costToDest = arrayOfDistances[destLocale];
        int totalCost = costToSource + costToDest;
        System.out.println("totalCost");
        System.out.println(totalCost);
        System.out.println("arrayOfDistances[destLocale]");
        System.out.println(arrayOfDistances[destLocale]);

        if(totalCost < arrayOfDistances[destLocale]){
            System.out.println("crying");
            sourceNode.setDistance(totalCost);
            arrayOfDistances[sourceLocale] = totalCost;
            dest.setPathBack(sourceNode);
            queue.addToQueue(dest, followerNumber);
        }else{
            System.out.println("unchanged");
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
        System.out.println("maxNumber " + maxNumber + " minNumber " + minNumber);
        int generatedNumber = (int) Math.floor(Math.random() *(maxNumber - minNumber + 1) + minNumber);
        System.out.println("generatedNumber " + generatedNumber);
        boolean goAhead = true;
        for(int comparision : alsoCantBe){
            if (generatedNumber == comparision){
                goAhead = false;
            }
        }

        if(generatedNumber != cantBe && goAhead == true){
            System.out.println("returned");
            return generatedNumber;
        }else {
            System.out.println("recalled");
            return randomNumber(maxNumber, minNumber, cantBe, alsoCantBe);
        }

    }

    
    public void writeToFile(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks) {
    try {
        FileWriter fileWriter = new FileWriter("train_network.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Write data to the file
        bufferedWriter.write("Node Information:\n");
        for (Nodes node : arrayOfNodes) {
            bufferedWriter.write(node.getName() + " - X: " + node.getXCoord() + ", Y: " + node.getYCoord() + "\n");
        }

        bufferedWriter.write("Link Information:\n");
        for (Links link : arrayOfLinks) {
            bufferedWriter.write("Start Node: " + link.getStartNode().getName() +
                                 ", End Node: " + link.getEndNode().getName() +
                                 ", Weight: " + link.getWeight() + "\n");
        }

        // Close the file
        bufferedWriter.close();
        fileWriter.close();
        System.out.println("Data has been written to train_network.txt");
    } catch (IOException e) {
        System.err.println("Error writing to the file: " + e.getMessage());
    }
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
