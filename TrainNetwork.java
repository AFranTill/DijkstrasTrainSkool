
/**
 * Creates and intialises a network of train and nodes
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TrainNetwork
{
    // instance variables - replace the example below with your own
    private int x;
    private int numberOfNodes;//NEEDS intialisign
    private int[] network;
    private String names[] = {"One","Two", "Three", "Four", "Five", "Six"};
    private Nodes arrayOfNodes[];
    Nodes otherNode;
    
    /**
     * Constructor for objects of class TrainNetwork
     */
    public TrainNetwork()
    {
        //create a name for the node
        numberOfNodes = 5; 
        Nodes arrayOfNodes[] = new Nodes[5];
        for(int i = 0; i < numberOfNodes;i++){
            String name = names[i];
            if(i==3) i =5;
            Nodes singleNode = new Nodes(i, name);
            if(i==5) i = 3;
            
            if(i > 4){
                Nodes otherNode = new Nodes(i, name);
            }
            arrayOfNodes[i] = singleNode;
        }
        
        for(int i = 0; i < numberOfNodes;i++){
            int girlie = arrayOfNodes[i].getNumber();
            System.out.println(girlie);
            int girlieTwo = otherNode.getNumber();
            System.out.println(girlie);
        }
    }

    public void nameNode()
    {
        
    }
}
