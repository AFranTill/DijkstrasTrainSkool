/**
 * Making a GUI and visuals
 *
 * @author Frances Till
 * @version 2 17/7/23
 */

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; //or events specifcally 
import java.awt.geom.*;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit; 

public class GUIMaker extends JFrame implements ActionListener, MouseListener // can use JFrame tools
{
    //menu bar items = class object intialisation
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    Canvas myGraphic;
    Nodes[] nodesAccessible;
    ArrayList<Links> linksAccessible;
    int followerNumber = 1;
    int circleSize = 30;
    //final String fileName = "blueRectangle.png";
    //ImageIcon image = new ImageIcon(fileName);

    /**
     * Constructor for objects of class CirclesAndSquares
     */
    public GUIMaker(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks)
    {

        String title = "huh?";
        int squareWindowSize = 600;
        this.setSize(squareWindowSize, squareWindowSize);

        nodesAccessible = arrayOfNodes; //HELP improve copying at some pint might pull up issues otherwise 
        linksAccessible = arrayOfLinks;

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
        int forwardDist = circleSize*2;
        int x = circleSize*2;
        int y = 100;
        int yChange;
        int yDiff;
        Nodes currentNode;
        nodesAccessible[0].setXCoord(50);
        nodesAccessible[0].setYCoord(y);
        for(int i = 0; i < nodesAccessible.length; i++){//HELP also don't set things for first node
            currentNode = nodesAccessible[i];
            linksForThisNode = currentNode.getLinks();
            
            for(Links link : linksForThisNode){
                System.out.println("added link to " + link.findOtherEnd(currentNode).getName() + " from " + currentNode.getName()); //HELP it's a little broken but it works for the firs tbit so we gonna work with it for now
                queue.addToQueue(link.findOtherEnd(currentNode), followerNumber);
            }

            //queue.printQueue(followerNumber);
            yDiff = circleSize* currentNode.getNumberOfLinks();
            yChange = yDiff/currentNode.getNumberOfLinks();
            int otherY = yChange; //if this equals 0 and hehe starts by equalling 0 i think it would also work
            int hehe = 1;
            while(queue.isQueueEmpty() != true){ 
                Nodes placingNode = queue.getHead();
                
                //System.out.println("yChange " + yChange + " yDiff " + yDiff + " otherY " + otherY + " hehe " + hehe);
                otherY = yDiff - yChange*hehe;
                System.out.println("Other Y " + otherY + " yDiff " + yDiff + " yChange " + yChange + " hehe " + hehe);
                slowPrint(1);
                hehe++;
                int newX = x + forwardDist*(i+0); //this shouldnt be working?? 
                
                placingNode.setXCoord(newX);
                int newY = y + otherY;
                placingNode.setYCoord(newY);
                
                //System.out.println("coordinates of " + placingNode.getName() + "x Coord " + placingNode.getXCoord() + " y coord " + placingNode.getYCoord());

                queue.takeFromQueue(followerNumber);
                
            }
            
            queue.printQueue(followerNumber);
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
        Graphics2D g2 = (Graphics2D) g;

        //image.paintIcon(this, g, x, y);

        Nodes currentNode;
        ToDoQueue queue = new ToDoQueue();
        ArrayList<Links> linksForThisNode;

        int forwardDist = circleSize*2;
        int x;
        int y;
        int yChange;
        int yDiff = 5;

        
        //int circleSize = 30;
        g2.setColor(Color.black);
        for(int i = 0; i < nodesAccessible.length; i++){
            System.out.println(i);
            x = nodesAccessible[i].getXCoord();
            y = nodesAccessible[i].getYCoord();
            g2.drawOval(x, y, circleSize, circleSize);
        }
        
        int i = 0;
        for(Links link : linksAccessible){
            int shift = circleSize/2;
            Line2D lin = new Line2D.Float(link.getStartNode().getXCoord()+shift, link.getStartNode().getYCoord()+shift, link.getEndNode().getXCoord()+shift, link.getEndNode().getYCoord()+shift);
            g2.draw(lin);
            i++;
            }

        }   

        // System.out.println("working????");
        //for(int i = 0; i < arrayOfNodes.length; i++){//HELP
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

    

        public static void slowPrint(int timeWaiting) { //makes the computer pause for the given amount of time
        timeWaiting = timeWaiting*1000;
        try{
            TimeUnit.MILLISECONDS.sleep(timeWaiting);
        }catch (Exception e){
            System.out.println("sorry the timer isn't working");
        }
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
