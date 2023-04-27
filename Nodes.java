
/**
 * Write a description of class Nodes here.
 *
 * @author Frances Till
 * @version 1 28/4/23
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
    private Nodes[] whoCanIGoTo;
    private int[] howLongWillItTake;

    Canvas myGraphic;
    /**
     * Constructor for objects of class Nodes
     */
    public Nodes(String newName)
    {        
        nameOfNode = newName;
    }
    
    public Nodes(int newNumber, String newName)
    {
        nameOfNode = newName;
        newNumber = numberOfNode;
    }
    
    public int getNumber(){
        return numberOfNode;
    }
}


