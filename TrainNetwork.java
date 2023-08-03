
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 12 17/7/23 
 */

import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit; 

public class TrainNetwork
{
    private int numberOfNodes;//NEEDS to be intialises
    private String names[] = {"Zero", "One","Two", "Three", "Four", "Five", "Six"}; //names for the different nodes
    private Nodes arrayOfNodes[]; //intailise the array 
    private int firstValue = 0;
    //private Links arrayOfLinks[];
    private ArrayList<Links> arrayOfLinks = new ArrayList<Links>();
    private int arrayOfDistances[];
    private int followerNumber = 0;

    /**
     * Constructor for objects of class TrainNetwork
     */
    public TrainNetwork()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("how many nodes do you want?");
        numberOfNodes = 6; //keyboard.nextInt();
        int maxNumberOfNodes = numberOfNodes - 1;
        //create a name for the node  

        Nodes[] arrayOfNodes = new Nodes[numberOfNodes];
        //numberOfLinks = 9;
       

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

        GUIMaker gui = new GUIMaker(arrayOfNodes, arrayOfLinks);
        //gui.repaint();

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
