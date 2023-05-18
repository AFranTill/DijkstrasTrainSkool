
/**
 * Creates and intialises a network of train and nodes
 *
 * @author Frances Till
 * @version 4/5/23 (verision 2) 
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
        int x = 6;
        
        for(int i = 0; i < numberOfLinks; i++){
            arrayOfLinks[i] = new Links(x, arrayOfNodes[i], arrayOfNodes[(i+1)]);
        }
        
       
        //algorithm();
    }
    
    public void algorithm(){
        arrayOfNodes[firstValue].setDistance(0);
        
        
    
    }

}
