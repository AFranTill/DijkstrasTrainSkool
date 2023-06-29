
/**
 * Links class formed edges and vertices between different nodes
 *
 * @author Frances Till
 * @version 5 30/6/23
 */

public class Links 
{
    private Nodes startNode;
    private Nodes endNode;
    private int weight; 
    /**
     * Constructor for objects of class Links
     */
    public Links(int theNumber, Nodes firstNode, Nodes secondNode)
    {        
        startNode = firstNode;
        endNode = secondNode;
        weight = theNumber;    

    }

    public Nodes getEndNode(){
        return endNode;
    }

    public int getWeight(){
        return weight;
    }

    public Nodes getStartNode(){
        return startNode; 
    }

    public Nodes findOtherEnd(Nodes sourceNode){
        if(sourceNode == startNode){
            return endNode;
        }else if (sourceNode == endNode){
            return startNode;
        }else{
            return null;
        }
    }

}
