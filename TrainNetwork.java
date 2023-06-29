
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 5 26/5/23 
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
    private Links arrayOfLinks[];
    private int numberOfLinks;
    private int arrayOfDistances[];

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
        numberOfLinks = 9;
        Links[] arrayOfLinks = new Links[numberOfLinks];

        // for(int i = 0; i < arrayOfLinks.length; i++){
        // System.out.println(arrayOfLinks[i] + ", ");
        // }

        for(int i = 0; i < numberOfNodes; i++){
            arrayOfNodes[i] = new Nodes(i, names[i], numberOfNodes);
        }

        // for(int i = 0; i < numberOfNodes; i++){
        // System.out.println(arrayOfNodes[i].getName());
        // }

        //CREATES A PRESET LINK Shit

        arrayOfLinks[0] = new Links(2, arrayOfNodes[0], arrayOfNodes[1]);
        arrayOfLinks[1] = new Links(4, arrayOfNodes[0], arrayOfNodes[2]);

        arrayOfLinks[2] = new Links(3, arrayOfNodes[1], arrayOfNodes[2]);
        arrayOfLinks[3] = new Links(1, arrayOfNodes[1], arrayOfNodes[3]);
        arrayOfLinks[4] = new Links(5, arrayOfNodes[1], arrayOfNodes[4]);

        arrayOfLinks[5] = new Links(2, arrayOfNodes[2], arrayOfNodes[3]);

        arrayOfLinks[6] = new Links(1, arrayOfNodes[3], arrayOfNodes[4]);
        arrayOfLinks[7] = new Links(4, arrayOfNodes[3], arrayOfNodes[5]);

        arrayOfLinks[8] = new Links(2, arrayOfNodes[4], arrayOfNodes[5]);

        System.out.println("link beginnings");
        for(int i = 0; i < numberOfLinks; i++){
            System.out.println(arrayOfLinks[i].getStartNode().getName() + ", ");
        }

        System.out.println("Link ends");
        for(int i = 0; i < numberOfLinks; i++){
            System.out.println(arrayOfLinks[i].getEndNode().getName() + ", ");
        }

        System.out.println("Link Weights");

        for(int i = 0; i < numberOfLinks; i++){
            System.out.println(arrayOfLinks[i].getWeight() + ", ");
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


    }

    public void algorithmPartOne(Nodes[] arrayOfNodes, Links[] arrayOfLinks ){
        Nodes currentNode = arrayOfNodes[firstValue]; // node currently looking at
        int length = arrayOfNodes.length - 1;
        Nodes lastNode = arrayOfNodes[length];
        ToDoQueue queue = new ToDoQueue();
        queue.addToQueue(arrayOfNodes[firstValue]);
        
        for(Nodes node : arrayOfNodes){
            node.setLinks(arrayOfLinks);
        }
        
        System.out.println("gotten to algorithm");
        while(queue.isQueueEmpty() != true){ //dont like (not how I would write) HELP
    
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
                    //update dist & prev node here
                    System.out.println("updated dist " + destNode.getDistance());
                    if(destNode != lastNode){
                        queue.addToQueue(destNode);
                        System.out.println("added dest " + destNode.getName() + " to queue");
                    }
                }else{
                    System.out.println("the current dist " + currentDist + " is larger than destNode dist " + destNode.getDistance() + " so not updated");
                }
                
                // if(nextCurrentNode == null || destNode.getDistance() < nextCurrentNode.getDistance()){ //I HAVE FOUND THE ISSUE HELPPP
                    // System.out.println("the next current node is " + currentNode.getName() + " and the dest node is " + destNode.getName()); 
                    // System.out.println("with distances of " + currentNode.getDistance() + " and " + destNode.getDistance());
                    //nextCurrentNode = destNode;
                    // System.out.println();
                    // System.out.println("the next node " + currentNode.getName() + " is now the dest node");
                // }
                
                slowPrint(0);
            }
            
            queue.takeFromQueue();
            currentNode = queue.getHead();
            // System.out.println("head of queue ");
            // System.out.print(queue.getHead().getName());
            // System.out.println("length of queue "); //HELP THIS IS AN ISSUE 
            // System.out.println(queue.getLength());
        }
        System.out.println("over");

        // int[] arrayOfDistances = new int[numberOfLinks];

        // Arrays.fill(arrayOfDistances, Integer.MAX_VALUE);

        // int weightOfNewLink = 0;

        // arrayOfDistances[firstNode.getNumber()] = 0;

        // ToDoQueue queue = new ToDoQueue();

        // queue.addToQueue(firstNode);

        // while(queue.isQueueEmpty() == false){ // this for loop may not be the right vibe we'll see

            // Nodes currentNode = queue.getHead();

            // findLinks(currentNode, arrayOfNodes, arrayOfLinks, arrayOfDistances, queue);

            // queue.takeFromQueue();

            // //arrayOfLinks[j].getWeight();
            // //arrayOfDistances[startNodeValue];

            // //weightOfNewLink = arrayOfDistances[j.getPathBack().getNumber()] + arrayOfLinks[j].getWeight();

            // //int travelTime = compare(arrayOfDistances, j, weightOfNewLink); 
            // //arrayOfDistances[j] = travelTime;
        // }
        
        
        // System.out.println("Nodes");
        // for(int i = 0; i < numberOfNodes; i++){
            // System.out.println(arrayOfNodes[i].getName() + ", ");
        // }

        // System.out.println("distances");
        // for(int i = 0; i < numberOfLinks; i++){
            // System.out.println(arrayOfDistances[i]+ ", ");
        // }

        // System.out.println("paths");
        // for(int i = 0; i < numberOfNodes; i++){
            // for(int j = 0; j < numberOfNodes; j++){
                // if(arrayOfNodes[j].getPathBack() != null){
                    // System.out.println(arrayOfNodes[i].getPathBack().getName() + ", ");
                // }
            // }
        // }
    }

    public void findLinks(Nodes sourceNode, Nodes[] arrayOfNodes, Links[] arrayOfLinks, int[] arrayOfDistances, ToDoQueue queue){
        for(int i = 0; i < numberOfLinks; i++){
            Nodes workingNode = arrayOfLinks[i].findOtherEnd(sourceNode);
            Links workingLink = arrayOfLinks[i];
            if(workingNode != null){
                algorithmPartTwo(workingLink, sourceNode, arrayOfNodes, arrayOfLinks, arrayOfDistances, queue);
            }else{

            }
        }
    }

    public void algorithmPartTwo(Links workingLink, Nodes sourceNode, Nodes[] arrayOfNodes, Links[] arrayOfLinks, int[] arrayOfDistances, ToDoQueue queue){
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
            queue.addToQueue(dest);
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
