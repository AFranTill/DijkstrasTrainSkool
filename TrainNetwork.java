
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
        
        makeConnections(arrayOfNodes);
        
        System.out.println("find name of first connection");
        
        System.out.println(arrayOfNodes[0].getConnectionName());
        
        //algorithm();
    }
    
    public void makeConnections(Nodes[] arrayOfNodes){
        arrayOfNodes[0].setNetworkBeginning(3, 0, arrayOfNodes[3]);
        
        //arrayOfNodes[0].addToNetwork(0, arrayOfNodes[1]);
         //arrayOfNodes[0].addToNetwork(1, arrayOfNodes[2]);
          //arrayOfNodes[0].addToNetwork(2, arrayOfNodes[3]);
    }
    
    public void algorithm(){
        arrayOfNodes[firstValue].setDistance(0);
        
        
    
    }

}
