
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 4 22/5/23 
 */

import java.util.Scanner;

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
        
        for(int i = 0; i < arrayOfLinks.length; i++){
            System.out.println(arrayOfLinks[i] + ", ");
        }
        
        for(int i = 0; i < numberOfNodes; i++){
            arrayOfNodes[i] = new Nodes(i, names[i], numberOfNodes);
        }
        
        for(int i = 0; i < numberOfNodes; i++){
            System.out.println(arrayOfNodes[i].getName());
        }
        
        
        System.out.println(numberOfLinks);
         
        for(int i = 0; i < numberOfLinks; i++){
            int weight =  (int) Math.floor(Math.random() *(maxNumberOfNodes - 1 + 1) + 1);
            int secondNodeNumber = (int) Math.floor(Math.random() *(maxNumberOfNodes - 0 + 1) + 0);
            Nodes firstNode = arrayOfNodes[i];
            Nodes secondNode = arrayOfNodes[secondNodeNumber];
            System.out.println("iteration number " + i);
            System.out.println(weight);
            System.out.println(firstNode.getName());
            System.out.println(secondNode.getName());
            System.out.println(secondNodeNumber);
            System.out.println(arrayOfLinks[i] + " " );
            arrayOfLinks[i] = new Links(weight, firstNode, secondNode); 
        }
        
                                     
        int x = 6;
        
        // for(int i = 0; i < numberOfLinks; i++){
            // arrayOfLinks[i] = new Links(x, arrayOfNodes[i], arrayOfNodes[(i+1)]);
        // }
        
       
        algorithm(arrayOfNodes, arrayOfLinks);
        
        
        
        
    }
    
    public void algorithm(Nodes[] arrayOfNodes, Links[] arrayOfLinks ){
        Nodes fixedNode = arrayOfNodes[0];
        int[] arrayOfDistances = new int[numberOfLinks];
        for(int i = 0; i < numberOfNodes; i++){
            Nodes nextNode = arrayOfNodes[i];
            for(int j = 0; j < numberOfLinks; j++){
                if(arrayOfLinks[j].getEndNode() == nextNode){
                    int weightOfNewLink = arrayOfLinks[j].getWeight();
                    int travelTime = compare(arrayOfDistances, j, weightOfNewLink); 
                    arrayOfDistances[j] = travelTime;
                }
                
            }
        }
        
        
        for(int i = 0; i < arrayOfDistances.length; i++){
            System.out.println(arrayOfDistances[i] + ", ");
        }
        
        for(int i = 0; i < arrayOfDistances.length; i++){
            System.out.println(arrayOfLinks[i].getWeight() + ", ");
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
    //arrayofIdstancees needs to have max vvalues
    // the links wieghts arent being got bc they are not there. There are no link weights 
    

}
