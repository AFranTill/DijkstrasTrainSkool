
/**
 * Class to construct the nodes
 *
 * @author Frances Till
 * @version 6 17/7/23
 */


import java.util.*;

public class Nodes 
{
    final int nodeSize = 10; //camecalse ocrrect? All caps? issue

    private String colorOfNode;
    private String imageForNode;
    private String nameOfNode;
    private int numberOfNode;
    private int numberOfNodes;
    //private Nodes[] whoCanIGoTo;
    private int[] howLongWillItTake;
    private int distanceFromStart = Integer.MAX_VALUE;
    private boolean evaluated = false; 
    private Nodes pathBack; 
    private Nodes follower; // for the queue
    private int xCoord;
    private int yCoord;

    private ArrayList<Links> linksForThisNode = new ArrayList<Links>();
    //private Nodes[] whoCanIGoTo = new Nodes[numberOfNodes];

    /**
     * Constructor for objects of class Nodes
     */
    public Nodes(int newNumber, String newName, int numberOfNodes)
    {        
        nameOfNode = newName;
        numberOfNode = newNumber;
        numberOfNodes = numberOfNodes;

        // whoCanIGoTo = new Nodes[numberOfNodes];
        // for(int i = 0; i < numberOfNodes; i++){
        // arrayOfNodes[i] = new Nodes(i, names[i], numberOfNodes);
        // }

        
    }

    public Nodes(int newNumber, String newName)
    {

    }

    public int getNumber(){
        return numberOfNode;
    }

    public String getName(){
        return nameOfNode;
    }

    public void setDistance(int dist){
        evaluated = true;
        distanceFromStart = dist;
    }

    public int getDistance(){
        return distanceFromStart;
    }

    public void setPathBack(Nodes backOne){
        pathBack = backOne;
    }

    public Nodes getPathBack(){
        return pathBack;
    }

    public void addFollower(Nodes newFollower)
    {
        this.follower = newFollower;
    }

    public Nodes getFollower()
    {
        return this.follower;
    }


    public void setLinks(Links[] arrayOfLinks){
        for(Links link : arrayOfLinks){
            if(link.findOtherEnd(this) != null && link.findOtherEnd(this) != this){
                linksForThisNode.add(link);
            }
        }
        
        printLinks();
    }
    
    public void printLinks(){
        System.out.println("the weights of the links off " + this.getName());
        for(Links link : linksForThisNode){
            System.out.println(link.getWeight());
        }
        System.out.println(linksForThisNode.size());
        
        printAllLinks();
    }
    
    public void printAllLinks(){
        for (Links link : linksForThisNode){
            System.out.print("ends " + link.getEndNode().getName() + ", "); //HELP
            System.out.print("Starts " + link.getStartNode().getName());
            System.out.println();
        }
    }
    
    
    public ArrayList getLinks(){
        return linksForThisNode;
    }
    
    public int getNumberOfLinks(){
        return linksForThisNode.size();
    }
    
    public void setXCoord(int x){
        xCoord = x; 
    }
    
    public int getXCoord(){
        return this.xCoord; 
    }
    
    public void setYCoord(int y){
        yCoord = y; 
    }
    
    public int getYCoord(){
        return this.yCoord; 
    }
}