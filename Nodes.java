
/**
 * Write a description of class Nodes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.Frame; //don't actually need rn
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Nodes
{
    final int nodeSize = 10; //camecalse ocrrect? All caps? issue
    
    String[] colors = {"red", "orange", "yellow", "green", "blue", "purple", "pink"};
    String[] images = {"firstImage", "secondImage", "thirdImage", "fourthImage", "fifthImage", "sixthImage", "seventhImage"};
    static String[] nameArray = {"alabama", "arkansas", "narnia", "wonderland", "washington", "wellington", "toyland", "imagination Station"};
    public String colorOfNode;
    public String imageForNode;
    public String nameOfNode;
    /**
     * Constructor for objects of class Nodes
     */
    public Nodes(int nodeNumber, String nodeName, int nodeLocale)
    {
        colorOfNode = colors[nodeNumber];
        imageForNode = images[nodeNumber];
        nameOfNode = nameArray[nodeNumber];
        
        //where it is - different
        //what colour it is - different 
        //it's image - different 
        //its size -same 
        //it's conections(?)
        //it's name 
        // 
        
        
    }
}
