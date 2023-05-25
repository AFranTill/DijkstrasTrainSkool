
/**
 * Write a description of class Links here.
 *
 * @author Frances Till
 * @version 2 22/5/23
 */


public class Links 
{
    private Nodes startPoint;
    private Nodes endPoint;
    private int weight; 
    /**
     * Constructor for objects of class Links
     */
    public Links(int weight, Nodes firstNode, Nodes secondNode)
    {        
        startPoint = firstNode;
        endPoint = secondNode;
        weight = weight;    
            
    }
    
    public Nodes getEndNode(){
        return endPoint;
    }
    
    public int getWeight(){
        return weight;
    }
    

}

