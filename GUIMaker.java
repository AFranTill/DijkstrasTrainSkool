/**
 * Making a GUI and visuals
 *
 * @author Frances Till
 * @version 5 28/9/23
 */

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; //or events specifcally 
import java.awt.geom.*;
import java.util.ArrayList;
//import java.awt.BasicStroke;
import java.util.concurrent.TimeUnit; 
import java.awt.geom.Line2D;
import java.util.List;
import java.util.Scanner;

public class GUIMaker extends JFrame implements ActionListener, MouseListener // can use JFrame tools
{
    //menu bar items = class object intialisation
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    private Nodes hoveredNode = null; //addition

    Canvas myGraphic;
    Nodes[] nodesAccessible;
    ArrayList<Links> linksAccessible;
    int followerNumber = 1;
    int circleSize = 30;
    //final String fileName = "blueRectangle.png";
    //ImageIcon image = new ImageIcon(fileName);

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

    private static final int MIN_DISTANCE_BETWEEN_NODES = 65; //fixing need HELP added
    private int printingLinks;
    private int screenWidth;
    private int screenHeight;

    private int squareWindowSize;

    private static List<Point> nodePositions = new ArrayList<>();

    /**
     * Constructor for objects of class CirclesAndSquares
     */
    public GUIMaker(Nodes[] arrayOfNodes, ArrayList<Links> arrayOfLinks, int graphType)
    {

        String title = "Dijkstra's Algorithm Visualisation";
        squareWindowSize = 600;
        getScreenSize();
        this.setSize(squareWindowSize, squareWindowSize);

        nodesAccessible = arrayOfNodes; //HELP improve copying at some pint might pull up issues otherwise 
        linksAccessible = arrayOfLinks;

        System.out.println("Would you like to print the link weights (please input y/n)");
        printingLinks = yesOrNoQuestionMethod(0);

        //circles = new Circle[nodesAccessible.length]; addition

        int maxY = squareWindowSize - circleSize;
        int maxX = squareWindowSize - circleSize; //HELP - these should be dependant on the screensize
        int minY = 30 + circleSize; // 30 being the size of the menubar at the top
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

        if(graphType != 3){
            nodesAccessible[0].setXCoord(50);
            nodesAccessible[0].setYCoord(y);
        }

        for(int i = 0; i < nodesAccessible.length; i++){//HELP also don't set things for first node
            currentNode = nodesAccessible[i];
            linksForThisNode = currentNode.getLinks();
            for(Links link : linksForThisNode){
                //System.out.println("added link to " + link.findOtherEnd(currentNode).getName() + " from " + currentNode.getName()); //HELP it's a little broken but it works for the firs tbit so we gonna work with it for now
                queue.addToQueue(link.findOtherEnd(currentNode), followerNumber);
            }

            if(graphType == 3){
                System.out.println("cool");

            }else if(graphType == 1 || graphType == 2){
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
        g2.setColor(rectColor);
        g2.fillRect(0, 0, 600, 600); //x, y, width, height
        //int circleSize = 30;

        // for(int i = 0; i < nodesAccessible.length; i++){
        // System.out.println(i);
        // x = nodesAccessible[i].getXCoord();
        // y = nodesAccessible[i].getYCoord();
        // g2.setColor(nodesAccessible[i].getColor());

        // //g2.setColor(circleColor);
        // g2.fillOval(x, y, circleSize, circleSize);

        // }
        int i = 0;
        for(Links link : linksAccessible){
            int shift = circleSize/2;
            g2.setColor(linkColor);
            int snx = link.getStartNode().getXCoord();
            int sny = link.getStartNode().getYCoord();
            int enx = link.getEndNode().getXCoord();
            int eny = link.getEndNode().getYCoord();
            Line2D lin = new Line2D.Float(snx+shift, sny+shift, enx+shift, eny+shift);
            g2.draw(lin);

            String linkNumber = String.valueOf(link.getWeight());
            g2.setColor(linkColor);
            // Draw the node number near the node
            int fontSize = 5;
            int weightX = enx + snx;
            int weightY = eny + sny;

            if(printingLinks == 1){
                g2.drawString(linkNumber, weightX/2, weightY/2);
            }else{

            }

            i++;
        }
        int end = nodesAccessible.length - 1; 
        currentNode = nodesAccessible[end];
        while (currentNode.getPathBack() != null) {

            int shift = circleSize/2;
            float lineWidth = 3.0f;
            g.setColor(Color.RED); 
            g2.setStroke(new BasicStroke(lineWidth));
            g.drawLine(currentNode.getXCoord()+shift, currentNode.getYCoord()+shift, currentNode.getPathBack().getXCoord()+shift, currentNode.getPathBack().getYCoord()+shift);

            currentNode = currentNode.getPathBack();
        }

        for( i = 0; i < nodesAccessible.length; i++){
            //System.out.println(i);
            x = nodesAccessible[i].getXCoord();
            y = nodesAccessible[i].getYCoord();
            //g2.setColor(circleColor);
            end = nodesAccessible.length - 1;
            int shift = circleSize/2;

            //System.out.println(nodesAccessible[i].getColor());
            if (i == 0 || i == end) g2.setColor(linkColor);
            //else if () g2.setColor(linkColor);
            else g2.setColor(circleColor);
            //g2.setColor(circleColor);
            g2.fillOval(x, y, circleSize, circleSize);

            String nodeNumber = String.valueOf(nodesAccessible[i].getNumber());

            g2.setColor(rectColor);
            // Draw the node number near the node
            int fontSize = 5;

            g2.drawString(nodeNumber, x+shift-fontSize, y+shift+fontSize);
        }
    }

    public void setNodePosition(int x, int y, Nodes currentNode) {
        // Check for collisions with existing nodes

        while (isColliding(x, y)) {
            // int offScreen = isOffScreen(x,y);
            // if(offScreen == 1){
                // //MIN_DISTANCE_BETWEEN_NODES = 1;
                // x = (int) Math.floor(Math.random() *(squareWindowSize - MIN_DISTANCE_BETWEEN_NODES  + 1) + MIN_DISTANCE_BETWEEN_NODES);; 
                // y = (int) Math.floor(Math.random() *(squareWindowSize - MIN_DISTANCE_BETWEEN_NODES  + 1) + MIN_DISTANCE_BETWEEN_NODES);
            // }else if(offScreen == 2){
                x = (int) Math.floor(Math.random() *(squareWindowSize - MIN_DISTANCE_BETWEEN_NODES  + 1) + MIN_DISTANCE_BETWEEN_NODES);; 
                y = (int) Math.floor(Math.random() *(squareWindowSize - MIN_DISTANCE_BETWEEN_NODES  + 1) + MIN_DISTANCE_BETWEEN_NODES);
            
            // }else{
                // int xOneOrMinusOne = generateRandomOneOrMinusOne();
                // int yOneOrMinusOne = generateRandomOneOrMinusOne();
                // x += MIN_DISTANCE_BETWEEN_NODES*xOneOrMinusOne; // Adjust horizontal position
                // y += MIN_DISTANCE_BETWEEN_NODES*yOneOrMinusOne; // Adjust vertical position
            // }
        }

        currentNode.setXCoord(x); 
        System.out.println("node " + currentNode.getName() + " set x " + x + "set y " + y);
        currentNode.setYCoord(y);
        nodePositions.add(new Point(x, y));
    }

    private boolean isColliding(int x, int y) {
        for (Point position : nodePositions) {
            // float xPos = (x - position.x);
            // float yPos = (y - position.y);
            // double distanceSquared = Math.sqrt(xPos * xPos + yPos * yPos);
            // int distance = (int) distanceSquared;
            
            int distanceSquared = ((x - position.x) * (x - position.x) + (y - position.y) * (y - position.y));
            //int radius = MIN_DISTANCE_BETWEEN_NODES + MIN_DISTANCE_BETWEEN_NODES ;
            if (distanceSquared <= MIN_DISTANCE_BETWEEN_NODES + MIN_DISTANCE_BETWEEN_NODES) {
                System.out.println("colldiing with another node " +  " x " + x + " y " + y);
                return true; // Colliding
            }

            if (x < 0 || y < 0 ||x > squareWindowSize-30 || y > squareWindowSize-30) {
                System.out.println("colldiing " +  " x " + x + " y " + y);
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

    public void mouseExited(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void mouseClicked(MouseEvent e) {}

    public static int generateRandomOneOrMinusOne() {
        int oneOrMinusOne = (int) Math.floor(Math.random() *(1 - -1 + 1) + -1);
        if(oneOrMinusOne == 1 || oneOrMinusOne == -1 ){
            return oneOrMinusOne;
        }else{
            return generateRandomOneOrMinusOne();
        }

    }

    public void getScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();

        System.out.println("Screen Width: " + screenWidth);
        System.out.println("Screen Height: " + screenHeight);
    }

    // public void mouseMoved(Graphics g, MouseEvent e) { //addition
    // int mousex = e.getX();
    // int mousey = e.getY();

    // // Check if the mouse is hovering over a node
    // for (Nodes node : nodesAccessible) {
    // int nodeX = node.getXCoord();
    // int nodeY = node.getYCoord();
    // if (mousex >= nodeX && mousex <= nodeX + circleSize &&
    // mousey >= nodeY && mousey <= nodeY + circleSize) {
    // // Mouse is hovering over this node
    // if (hoveredNode != node) {
    // // Highlight the node and its links
    // hoveredNode = node;
    // highlightNodeAndLinks(g, hoveredNode);
    // repaint(); // Redraw the canvas to update the highlighting
    // slowPrint(1);
    // }
    // return; // Exit the loop since we only want to highlight one node at a time
    // }
    // }

    // }
    // private void highlightNodeAndLinks(Graphics g, Nodes node) {
    // System.out.println(node.getName());
    // //g.setColour(BLACK );
    // g.fillOval(node.getXCoord(), node.getYCoord(), circleSize, circleSize);
    // }
}
