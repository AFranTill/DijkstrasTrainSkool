/**
 * Making a GUI and visuals
 *
 * @author Frances Till
 * @version 1 13/7/23
 */

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; //or events specifcally 
import java.awt.geom.*;
import java.util.ArrayList;

public class GUIMaker extends JFrame implements ActionListener, MouseListener // can use JFrame tools
{
    //menu bar items = class object intialisation
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    Canvas myGraphic;
    //final String fileName = "blueRectangle.png";
    //ImageIcon image = new ImageIcon(fileName);
    /**
     * Constructor for objects of class CirclesAndSquares
     */
    public GUIMaker(Nodes[] arrayOfNodes, Links[] arrayOfLinks)
    {

        String title = "huh?";
        int squareWindowSize = 300;

        //creating menu - removed inputs from prev lesson
        this.setTitle(title);

        this.getContentPane().setPreferredSize(new Dimension(squareWindowSize, squareWindowSize));
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.toFront();
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 400));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        menuBar = new JMenuBar(); // you can only have one menu bar (otherwise it doens't work)
        this.setJMenuBar(menuBar);

        //create the file menu 
        menu = new JMenu("File");
        menuBar.add(menu);

        //add items
        menuItem = new JMenuItem("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //Example of a shortcut
        menuItem = new JMenuItem("Down");
        menuItem.setAccelerator(KeyStroke.getKeyStroke("DOWN"));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu = new JMenu("Dogs"); //create a menu
        menuBar.add(menu); // menu's don't generate action items and therefore u can't add action listeners to them 

        //add items
        menuItem = new JMenuItem("Corgi");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('g'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Collie");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('l'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        //create another menu
        menu = new JMenu("Cats");
        menuBar.add(menu);

        //add items
        menuItem = new JMenuItem("Tabby");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('t'));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Sphinix");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('s'));
        menuItem.addActionListener(this);
        addMouseListener(this);
        menu.add(menuItem);

        ToDoQueue queue = new ToDoQueue();
        ArrayList<Links> linksForThisNode;
        for(int i = 0; i < arrayOfNodes.length; i++){//HELP
            Nodes currentNode = arrayOfNodes[i];
            linksForThisNode = currentNode.getLinks();
            for(Links link : linksForThisNode){
                queue.addToQueue(link.findOtherEnd(currentNode));
            }
            while(queue.isQueueEmpty() != true){ 
                //setX
                //setY
                //change y change
                //remove from queue
            
            }
            // yChange = 20/(currentNode.getNumberOfLinks() - 1);
            // g2.drawOval(x, y, height, width);
            // System.out.println("working");
            
            // g2.drawString("Girlboss!", 100, 100);
            
            // for(int j = 0; j < currentNode.getNumberOfLinks(); j++){
                // Line2D lin = new Line2D.Float(x+width, y, x+length-width, y+20-yChange*j);
                // g2.draw(lin);
            }
        
        
        this.pack(); // magical pack always needs to be after, other it won't load the menus until it's resized
    
}

    public void actionPerformed(ActionEvent e){
        String itemToActOn = e.getActionCommand(); //string of the clicked on menu item title's 

        //much prettier, updated actions using a switch
        switch (itemToActOn){
            case "quit":
                System.exit(0);
                break;

            case "Corgi":
                System.out.println("britishes people and queenie like this innit");
                break;

            case "Collie":
                System.out.println("that's just a make work scheme");
                String collieDogDialogue = "I have a border collie, his name is Ted";
                createDialogExample(collieDogDialogue);
                break;

            case "Tabby":
                System.out.println("yas - best cat breed");
                String tabbyCatDialogue = "tabbies are very pretty";
                createDialogExample(tabbyCatDialogue);
                break;

            case "Sphinix":
                System.out.println("a weird hairless kitty cat");
                break;

            case "Down":
                System.out.println("downing");
                break;
        }
    }

    void createDialogExample(String information){ //must be created in the same class
        JDialog box = new JDialog(this);
        box.setBounds(400, 400, 150, 70);
        TextArea area = new TextArea(information);
        box.add(area);
        box.toFront();
        box.setVisible(true);
        box.setTitle("Hello");
        area.setEditable(false);
    }

    public void paint (Graphics g){ //HELP BIG ONE need to set the values fo the arrays and the links etc before doign them in here bc can't pass anything into here.
        super.paint(g);
        int x = 10;
        int y = 10;
        int height = 20;
        int width = 20;
        Nodes currentNode;
        int xChange;
        int yChange;
        int length = 20;
        int vertical = 1;
        //image.paintIcon(this, g, x, y);
         Graphics2D g2 = (Graphics2D) g;
        // System.out.println("working????");
        // for(int i = 0; i < arrayOfNodes.length; i++){//HELP
            // currentNode = arrayOfNodes[i];
            // yChange = 20/(currentNode.getNumberOfLinks() - 1);
            // g2.drawOval(x, y, height, width);
            // System.out.println("working");
            
            // g2.drawString("Girlboss!", 100, 100);
            
            // for(int j = 0; j < currentNode.getNumberOfLinks(); j++){
                // Line2D lin = new Line2D.Float(x+width, y, x+length-width, y+20-yChange*j);
                // g2.draw(lin);
            // }
            
            // x = x + 20;
            // y = y + yChange*vertical;
            // vertical = vertical*-1;

        // }
        
        // for(int i = 0; i < arrayOfNodes.length; i++){//HELP
            // currentNode = arrayOfNodes[i];
            // yChange = 20/(currentNode.getNumberOfLinks() - 1);
            // if(i==0){
                // g2.drawOval(x, y, height, width);
                // xChange = 100;//HELP

            // }else{
                // newX = x +
                // newY = y + yChange;
                // g2.drawOval(newX, newY, height, width);
            // }
            // for(int j = 0; j < currentNode.getNumberOfLinks(); j++){
                // Line2D lin = new Line2D.Float(x+width, y, x+length-width, y+20-yChange*j);
            // }

        // }

        // for(int i = 0; i < arrayOfNodes.length; i++){//HELP
            // g2.drawOval(x, y, height, width);
            // //x = x + change;

        // }

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

    public void mouseExited(MouseEvent e){System.out.println("exit");}

    public void mouseEntered(MouseEvent e){System.out.println("enter");}

    public void mouseReleased(MouseEvent e){System.out.println("release");}

    public void mousePressed(MouseEvent e){System.out.println("press");}

    public void mouseClicked(MouseEvent e) {
        int mousex = e.getX();
        int mousey = e.getY();
        System.out.println("click at" + mousex + ", " + mousey);
    }
}
