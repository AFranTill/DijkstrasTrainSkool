/**
 * Making a GUI and visuals
 *
 * @author Frances Till
 * @version 5 28/9/23
 */

//IMPORTS
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit; 
import java.awt.geom.Line2D;
import java.util.List;
import java.util.Scanner;

public class GUIMaker extends JFrame implements ActionListener // can use JFrame tools
{
    //VARS
    
    //menu bar items = class object intialisation
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    Canvas myGraphic;
    
    // have to create new arrays to work in here (same info as prev)
    Nodes[] nodesAccessible; 
    ArrayList<Links> linksAccessible;
    
    
    int followerNumber = 1; //placeholder for a node iteration thing
    int circleSize = 30; //size of circles
    
    //COLOUR OPTIONS

    //orange "#ff6108" 
    //Barbie colors: rect ##ffdae4, circ "#ea377f" ,  link #bf1567
    //meditarenan: rect "#b2d8d8", circ "#ffeead", link "#ffcc5c", 
    // #ff9999, #ffcaa7, #ffee8, #b2f2b0, #d2e9ff
    //aggressive pan flag circ "#540D6E", link "#EE4266", rect "#FFD23F"
    //light greens rect "#f3f9d2", circ "#cbeaa6", link "#c0d684"
    //baby pastels rect "#c9def4" ,circ "#f5ccd4", link "#b8a4c9"
    //blues rect "#dae1ed", circ "#6a86b7", link #4568a5
    //oranges rect "#fee2cc", circ "#f98d35", link "#f87002" 
    //black     #000000
    //white     #ffffff

    private String hexRectColor = "#ffdae4"; 
    Color rectColor = Color.decode(hexRectColor);

    private String hexCircleColor = "#ea377f"; 
    Color circleColor = Color.decode(hexCircleColor);

    private String hexLinkColor = "#bf1567"; 
    Color linkColor = Color.decode(hexLinkColor);

    private static final int MIN_DISTANCE_BETWEEN_NODES = 35; //distance betwene nodes (buffer)
    private int printingLinks; // for if we are prinitng link weights
    
    private int menuBuffer; // distance needed for the menu bar at top 

    private int squareWindowSize; // size of window

    private static List<Point> nodePositions = new ArrayList<>(); // where the other nodes are (to check against) 

    /**
     * Constructor for objects of class CirclesAndSquares
     */
    public GUIMaker(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int graphType)
    {

        String title = "Dijkstra's Algorithm Visualisation";
        squareWindowSize = 600;
        this.setSize(squareWindowSize, squareWindowSize);
        this.setResizable(false);

        nodesAccessible = arrayOfNodes; 
        linksAccessible = arrayOfLinks;

        System.out.println("Would you like to print the link weights (please input y/n)");
        printingLinks = yesOrNoQuestionMethod(0);

         menuBuffer = 50; 

        int maxY = squareWindowSize - circleSize;
        int maxX = squareWindowSize - circleSize; 
        int minY = menuBuffer + circleSize; // being the size of the menubar at the top and the circle size 
        int minX = circleSize; // gives buffer room

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
        menu = new JMenu("quit");
        menuBar.add(menu);

        //add items
        menuItem = new JMenuItem("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        ToDoQueue queue = new ToDoQueue(); //set up a new queue to go through the nodes/links
        ArrayList<Links> linksForThisNode;

        int forwardDist = circleSize*2;
        int x = circleSize*2;
        int y = 100;
        int yChange;
        int yDiff;
        Nodes currentNode;

        if(graphType != 3){ //as long as not reading from file, intialise first node
            nodesAccessible[0].setXCoord(50);
            nodesAccessible[0].setYCoord(y);
        }

        for(int i = 0; i < nodesAccessible.length; i++){// sets up link and uses them to manage adding nodoes to queue
            currentNode = nodesAccessible[i];
            linksForThisNode = currentNode.getLinks();
            for(Links link : linksForThisNode){ // set up links 
                queue.addToQueue(link.findOtherEnd(currentNode), followerNumber);
            }

            if(graphType == 3){ // if file reading, do nothing

            }else if(graphType == 1 || graphType == 2){ // if not, iterate through nodes and generate a locale for them 
                while(queue.isQueueEmpty() != true){ 
                    Nodes placingNode = queue.getHead();
                    int newY = (int) Math.floor(Math.random() *(maxY - minY + 1) + minY);
                    int newX = (int) Math.floor(Math.random() *(maxX - minX + 1) + minX);
                    setNodePosition(newX, newY, currentNode);
                    queue.takeFromQueue(followerNumber);
                }
            }else{
            }
        }

        this.pack(); // magical pack always needs to be after, other it won't load the menus until it's resized
    }

    public void actionPerformed(ActionEvent e){
        String itemToActOn = e.getActionCommand(); //string of the clicked on menu item title's 

        //allows for user freedom
        switch (itemToActOn){
            case "quit":
                System.exit(0);
                break;
        }
    }

    public void paint (Graphics g){ //Here is where everything is dranw in
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
        g2.setColor(rectColor);
        g2.fillRect(0, menuBuffer, 600, 600); //x, y, width, height
        
        int i = 0;
        for(Links link : linksAccessible){ //itater through all the links
            int shift = circleSize/2;
            g2.setColor(linkColor);
            int snx = link.getStartNode().getXCoord();
            int sny = link.getStartNode().getYCoord();
            int enx = link.getEndNode().getXCoord();
            int eny = link.getEndNode().getYCoord();
            g2.setColor(linkColor);
            Line2D lin = new Line2D.Float(snx+shift, sny+shift, enx+shift, eny+shift); // draw then, accouting for circle radius, locale
            g2.draw(lin);

            String linkNumber = String.valueOf(link.getWeight());
            // Draw the node number near the node
            int fontSize = 5;
            int weightX = enx + snx;
            int weightY = eny + sny;

            if(printingLinks == 1){ // if printing the link weights 
                g2.drawString(linkNumber, weightX/2, weightY/2);
            }else{

            }

            i++;
        }
        int end = nodesAccessible.length - 1; 
        currentNode = nodesAccessible[end];
        while (currentNode.getPathBack() != null) { // set up pathback links 
            int shift = circleSize/2;
            float lineWidth = 3.0f;
            g.setColor(Color.RED); //stand out colour
            g2.setStroke(new BasicStroke(lineWidth)); //make it bolder
            g.drawLine(currentNode.getXCoord()+shift, currentNode.getYCoord()+shift, currentNode.getPathBack().getXCoord()+shift, currentNode.getPathBack().getYCoord()+shift);
            currentNode = currentNode.getPathBack(); // move down the path
        }

        for( i = 0; i < nodesAccessible.length; i++){ // iterate thrrough nodes
            x = nodesAccessible[i].getXCoord();
            y = nodesAccessible[i].getYCoord();
            end = nodesAccessible.length - 1;
            int shift = circleSize/2;

            if (i == 0 || i == end) g2.setColor(linkColor); // change color if start or end
            else g2.setColor(circleColor);

            g2.fillOval(x, y, circleSize, circleSize); // draw nodes
            String nodeNumber = String.valueOf(nodesAccessible[i].getNumber());
            g2.setColor(rectColor); // set a different color for node numbers
            int fontSize = 5;

            g2.drawString(nodeNumber, x+shift-fontSize, y+shift+fontSize);
        }
    }

    public void setNodePosition(int x, int y, Nodes currentNode) {
        while (isColliding(x, y)) { // check if overlappign with other nodes or off page
                x = (int) Math.floor(Math.random() *(squareWindowSize - MIN_DISTANCE_BETWEEN_NODES  + 1) + MIN_DISTANCE_BETWEEN_NODES);; 
                y = (int) Math.floor(Math.random() *(squareWindowSize - MIN_DISTANCE_BETWEEN_NODES + menuBuffer + 1) + MIN_DISTANCE_BETWEEN_NODES + menuBuffer);
        }
        currentNode.setXCoord(x); 
        currentNode.setYCoord(y);
        nodePositions.add(new Point(x, y));
    }

    private boolean isColliding(int x, int y) {
        for (Point position : nodePositions) {
            int distanceSquared = ((x - position.x) * (x - position.x) + (y - position.y) * (y - position.y)); // works out circle collision 
            int radiiSquared = MIN_DISTANCE_BETWEEN_NODES * MIN_DISTANCE_BETWEEN_NODES;
            if (distanceSquared <= MIN_DISTANCE_BETWEEN_NODES + MIN_DISTANCE_BETWEEN_NODES) { // overlapping
                return true; // Colliding
            }
            if (x < 0 || y < menuBuffer ||x > squareWindowSize-30 || y > squareWindowSize-30) { //off screen
                return true;
            }
        }
        return false; // Not colliding
    }

    private int isOffScreen(int x, int y) {
        for (Point position : nodePositions) {
            if (x < 0 || y < 0 ) {
                return 1; // Colliding due to being off the screen
            }else if (x > squareWindowSize-30 || y > squareWindowSize-30){
                return 2;
            }
        }
        return 0;
    }

    public int yesOrNoQuestionMethod(int yesOrNo){ 
        Scanner keyboard = new Scanner(System.in); 
        //takes userInput, mainuplates it into the simplest form, so it can compare to the simplest form in the if statement
        String userInput = keyboard.nextLine(); //creates 'userInput' as a string variable, assigns it the just receieved input
        userInput = userInput.toLowerCase().trim(); //converts it to lowercase and trims it 

        if(userInput.equals("yes")||userInput.equals("y")){ //if it receives yes
            yesOrNo = 1;
        }else if (userInput.equals("no")||userInput.equals("n")){ //if it receives no
            yesOrNo = 2;
        }else{ //if it gets an invalid answer
            System.out.println("sorry that was an invalid input. Try yes or no, or y/n");
            yesOrNo = yesOrNoQuestionMethod(1); //calls method again until it gets a valid answer
        }
        return yesOrNo;
    }
    
    public static void slowPrint(int timeWaiting) { //makes the computer pause for the given amount of time
        timeWaiting = timeWaiting*1000;
        try{
            TimeUnit.MILLISECONDS.sleep(timeWaiting);
        }catch (Exception e){
            System.out.println("sorry the timer isn't working");
        }
    }

}
