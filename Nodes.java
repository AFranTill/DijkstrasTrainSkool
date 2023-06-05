
/**
 * Class to construct the nodes
 *
 * @author Frances Till
 * @version 4 22/5/23
 */

import java.awt.Frame; //don't actually need rn
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; //or events specifcally 
import java.awt.geom.*;

public class Nodes extends JFrame
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

    //private Nodes[] whoCanIGoTo = new Nodes[numberOfNodes];
    
    Canvas myGraphic;
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
    
    
}


