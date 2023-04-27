
/**
 * Class to run in order to create a new network with nodes
 *
 * @author Frances Till
 * @version 1 16/4/23
 */

import java.util.Scanner;
public class OnStart
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class OnStart
     */
    public OnStart()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("how many nodes would you like?");
        x = keyboard.nextInt(); //HELP make a foolproof take int method
        
        //intialise a 2d array of objects which has the amount of nodes I'd like 
        //we probs want the array to be in main rather than here tbh. 
        
        
    }

    
}
