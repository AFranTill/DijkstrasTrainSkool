
/**
 * Class to construct the nodes
 *
 * @author Frances Till
 * @version 7 28/9/23
 */


import java.util.*;
import java.awt.Color;

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
    private Nodes[] follower = new Nodes[2]; // for the queue
    private int xCoord;
    private int yCoord;
    private boolean visited = false;
    private Nodes nextFollower;
    private Color color; 

    private ArrayList<Links> linksForThisNode = new ArrayList<Links>();
    //private Nodes[] whoCanIGoTo = new Nodes[numberOfNodes];

    /**
     * Constructor for objects of class Nodes
     */
    public Nodes(int newNumber, String newName, int numberOfNodes)
    {        
        this.nameOfNode = newName;
        this.numberOfNode = newNumber;
        this.numberOfNodes = numberOfNodes;

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

    public void addFollower(Nodes newFollower, int which)
    {
        this.follower[which] = newFollower;
    }

    public Nodes getFollower(int which) //NOTE this is the part that is breaking. idk why?
    //this is working on the queue to print the circles (aka the links and nodes are being made but not the circles? idk it'sinteresting. 
    {
        return this.follower[which];
    }


    public void setLinks(ArrayList<Links> arrayOfLinks){
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public boolean contains(int mx, int my, int circleSize) { // HELP (will this work? need to comment it as well)
            int dx = this.xCoord - mx;
            int dy = this.yCoord - my;
            return dx * dx + dy * dy <= circleSize * circleSize;
        }
        
        public Color getColor(){
        return this.color;
    }
    
    public void setColor(Color newColor){
        this.color = newColor; 
    }
}
