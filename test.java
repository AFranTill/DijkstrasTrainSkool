
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class test
     */
    public test()
    {

        int randomValue = generateRandomOneOrMinusOne();
        System.out.println("Random Value: " + randomValue);
    }

    
    public static int generateRandomOneOrMinusOne() {
        int oneOrMinusOne = (int) Math.floor(Math.random() *(1 - -1 + 1) + -1);
        return oneOrMinusOne;
    }

}
