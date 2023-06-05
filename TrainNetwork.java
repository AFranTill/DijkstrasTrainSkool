
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 5 26/5/23 
 */

import java.util.Scanner;
import java.util.*;

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

        algorithm(arrayOfNodes, arrayOfLinks);

        System.out.println("yyayyyayyayay");
    }

    public void algorithm(Nodes[] arrayOfNodes, Links[] arrayOfLinks ){
        Nodes fixedNode = arrayOfNodes[firstValue];
        int[] arrayOfDistances = new int[numberOfLinks];
        Arrays.fill(arrayOfDistances, Integer.MAX_VALUE);
        int weightOfNewLink = 0;
        arrayOfDistances[fixedNode.getNumber()] = 0;
        
        for(int j = 0; j < numberOfLinks; j++){
            //get links 
            //
            Nodes startNode = arrayOfLinks[j].getStartNode();
            Nodes endNode = arrayOfLinks[j].getEndNode();
            int startNodeValue = startNode.getNumber();
            
            
            
            arrayOfLinks[j].getWeight();
            //arrayOfDistances[startNodeValue];
            
            weightOfNewLink = arrayOfDistances[pathBack] + arrayOfLinks[j].getWeight();
            
            int travelTime = compare(arrayOfDistances, j, weightOfNewLink); 
            arrayOfDistances[j] = travelTime;
            

        }

        // for(int i = 0; i < arrayOfNodes.length; i++){
        // System.out.println(arrayOfNodes[i] + ", ");
        // }

        for(int i = 0; i < arrayOfDistances.length; i++){
            System.out.print(arrayOfDistances[i] + ", ");
        }

        // for(int i = 0; i < arrayOfLinks.length; i++){
        // System.out.println(arrayOfLinks[i].getWeight() + ", ");
        // }
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
