
/**
 * Write a description of class Main here.
 *
 * @author Frances Till
 * @version Verision 1 24/2/23
 */

import java.awt.Frame; //don't actually need rn
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
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
import java.awt.Graphics;


public class Main
{
    // instance variables - replace the example below with your own
    private int x;
    public Nodes[] arrayOfNodes = new Nodes [7];
    Canvas myGraphic;
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        JFrame frame = new JFrame(); //creates frame
        frame.setTitle("Title goes here"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //DO_NOTHING_ON_ClLOSE  & default is HIDE_ON_CLOSE
        frame.setSize(420, 420); //sets the x-dim and y-dim
        frame.setResizable(true);//prevents from being resizeaed
        
        ImageIcon image = new ImageIcon("ghostlogo.jpg"); // creates an image icon
        frame.setIconImage(image.getImage());
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 400));
        myGraphic = new Canvas();
        panel.add(myGraphic);
        
        paint(g);
          
        // frame.getContentPane().setBackground(new Color(100, 10, 0)); //hex: 0x*6values*
        // frame.setLayout(new GridLayout(3,3, 10, 10)); //horz elements, vert elements, horz margin, vert margin
        
        // frame.add(new JButton("1"));
        // frame.add(new JButton("2"));
        // frame.add(new JButton("3"));
        // frame.add(new JButton("4"));
        // frame.add(new JButton("5"));
        // frame.add(new JButton("6"));
        // frame.add(new JButton("7"));
        // frame.add(new JButton("8"));
        // frame.add(new JButton("9"));
        
        // Station thingy = new Station();
        // System.out.println(thingy.x);
    
        // createNodes(7);
        
        // System.out.println(arrayOfNodes[0].nameOfNode);
        // System.out.println(arrayOfNodes[1].nameOfNode);
        // System.out.println(arrayOfNodes[2].nameOfNode);
        // System.out.println(arrayOfNodes[3].nameOfNode);
        // frame.setVisible(true);//makes frame visble 
        frame.pack();
       
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void createNodes(int numberOfNodesForThisLevel)
    {
        for(int i = 0; i < numberOfNodesForThisLevel; i++){
            //Nodes[] arrayOfNodes = new Nodes[numberOfNodesForThisLevel];
            String nodeName = nodeNameCreator(i);
            int localeForNode = 1;//make locales
            //Nodes workingNode = new Nodes(i, nodeName, localeForNode);
            //arrayOfNodes[i] = workingNode;
            //System.out.println(arrayOfNodes
        }
        
    }
    
    public String nodeNameCreator(int currentNumber){
        //String nodeName = Nodes.nameArray[currentNumber];
        //String numberEnd = String.valueOf(currentNumber);
        //System.out.print(numberEnd);
        //nodeName.concat(numberEnd);
        
        return "hi";
    }
    
    public void paint(Graphics g){
        //super.paint(g);
        System.out.println("hi");
        int x = 100;
        int y = 100;
        Graphics2D g2 = (Graphics2D) g;
        int circleXLocale = 100;
        int circleYLocale = 140;
        int circleSize = 200;
        int lineLength = 200;
        int xLineStart = circleXLocale + circleSize;
        int xLineEnd = xLineStart + lineLength;
        int yLineStart = circleYLocale + circleSize/2;
        int yLineEnd = yLineStart;
        int otherCircleXLocale = circleXLocale + circleSize + lineLength;
        int otherCircleYLocale = circleYLocale;
        Line2D lin = new Line2D.Float(xLineStart, yLineStart, xLineEnd, yLineEnd);
        g2.draw(lin);
        g2.drawOval(circleXLocale, circleYLocale, circleSize, circleSize);
        g2.drawOval(otherCircleXLocale, otherCircleYLocale, circleSize, circleSize);
        g2.drawString("Girlboss!", circleXLocale + circleSize/3, circleYLocale + circleSize/2);
        g2.setColor(Color.BLUE);
        g2.drawString("Girlbossy!", otherCircleXLocale + circleSize/3, otherCircleYLocale + circleSize/2);
    }
}
