
/**
 * Write a description of class Main here.
 *
 * @author Frances Till
 * @version Verision 1 24/2/23
 */

import java.util.Scanner;


public class Main
{
    // instance variables - replace the example below with your own
    private int x;
    public Nodes[] arrayOfNodes;
    //Canvas myGraphic;
    /**
     * Constructor for objects of class Main extends Nodes
     */
    public Main()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("how many nodes would you like?");
        x = keyboard.nextInt(); //HELP make a foolproof take int method
        arrayOfNodes = new Nodes[x];
       
        
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
    }
}
