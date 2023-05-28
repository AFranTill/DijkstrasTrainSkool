
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
        numberOfNodes = keyboard.nextInt();
        int maxNumberOfNodes = numberOfNodes - 1;
        //create a name for the node  
        Nodes[] arrayOfNodes = new Nodes[numberOfNodes];
        numberOfLinks = 5;
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

        System.out.println(numberOfLinks);
        for(int i = 0; i < numberOfLinks; i++){
            int weight =  (int) Math.floor(Math.random() *(maxNumberOfNodes - 1 + 1) + 1);
            int secondNodeNumber = (int) Math.floor(Math.random() *(maxNumberOfNodes - 0 + 1) + 0);
            if(secondNodeNumber != i){
                Nodes firstNode = arrayOfNodes[i];
                Nodes secondNode = arrayOfNodes[secondNodeNumber];
                arrayOfLinks[i] = new Links(weight, firstNode, secondNode);
                System.out.println("went haead" + secondNodeNumber +", "+ i);
            }else{
                System.out.println("didn't go ahead" + i);
                i = i - 1;
                System.out.println("didn't go ahead" + i);
            }

        }
                                     
        int x = 6;

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
        Nodes fixedNode = arrayOfNodes[0];
        int[] arrayOfDistances = new int[numberOfLinks];
        Arrays.fill(arrayOfDistances, Integer.MAX_VALUE);
        int weightOfNewLink = 0;
        for(int i = 0; i < numberOfNodes; i++){
            Nodes nextNode = arrayOfNodes[i];
            for(int j = 0; j < numberOfLinks; j++){
                if(arrayOfLinks[j].getEndNode() == nextNode){
                    int x = j;
                    int y = j;
                    while(arrayOfLinks[x].getEndNode() != arrayOfNodes[0]){
                        weightOfNewLink = weightOfNewLink + arrayOfLinks[x].getWeight();
                        x = arrayOfLinks[x].getEndNode().getNumber();
                        y = y - 1;
                    }
                    
                    int travelTime = compare(arrayOfDistances, j, weightOfNewLink); 
                    arrayOfDistances[j] = travelTime;
                    weightOfNewLink = 0;
                }

            }
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
