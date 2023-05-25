
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
        //create a name for the node  
        Nodes[] arrayOfNodes = new Nodes[numberOfNodes];
        
        
        for(int i = 0; i < numberOfNodes; i++){
            arrayOfNodes[i] = new Nodes(i, names[i], numberOfNodes);
        }
        
        for(int i = 0; i < numberOfNodes; i++){
            System.out.println(arrayOfNodes[i].getName());
        }
        
        numberOfLinks = 5;
         
        for(int i = 0; i < numberOfLinks; i++){
            int weight =  (int) Math.floor(Math.random() *(5 - 1 + 1) + 1);
            int secondNodeNumber = numberOfNodes - i;
            Nodes firstNode = arrayOfNodes[i];
            Nodes secondNode = arrayOfNodes[secondNodeNumber];
            arrayOfLinks[i] = new Links(weight,firstNode, secondNode);
        }
        
                                     
        int x = 6;
        
        for(int i = 0; i < numberOfLinks; i++){
            arrayOfLinks[i] = new Links(x, arrayOfNodes[i], arrayOfNodes[(i+1)]);
        }
        
       
        //algorithm();
    }
    
    public void algorithm(){
        Nodes fixedNode = arrayOfNodes[0];
        //make new dist arrays 
        
        
    
    }

}
