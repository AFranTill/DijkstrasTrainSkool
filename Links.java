
/**
 * Write a description of class Links here.
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

public class Links extends JFrame
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
    
    

}

