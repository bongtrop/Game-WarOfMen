
/**
 * Write a description of class Swordman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Swordman
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    /**
     * Constructor for objects of class Swordman
     */
    public Swordman()
    {
        // initialise instance variables
        x = 0;
        y = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getX()
    {
        // put your code here
        return x;
    }
    
    public int getY()
    {
        // put your code here
        return y;
    }
    
    public void walk(int tid)
    {
        if (tid==0) {
            y--;
        }
        if (tid==1) {
            y++;
        }
        if (tid==2) {
            x--;
        }
        if (tid==3) {
            x++;
        }
        if (y>4) {
            y--;
        }
        if (y<0) {
            y++;
        }
        if (x>4) {
            x--;
        }
        if (x<0) {
            x++;
        }
    }
}
