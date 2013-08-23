
/**
 * Write a description of class state here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class state implements iState
{
    // instance variables - replace the example below with your own
    private int nstate;
    private int state[][][];
    public static final int WATER = 0;
    public static final int EARTH = 1;
    public static final int BREAKWOOD = 2;
    public static final int WOOD = 3;
    public static final int STONE = 4;
    public static final int BRIDGE = 5;

    /**
     * Constructor for objects of class state
     */
    public state(int nstate)
    {
        // initialise instance variables
        state = new int[5][15][20];
        this.nstate = nstate;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setState(int nstate)
    {
        // put your code here
        this.nstate = nstate;
    }
    
    public int getSymbol(position pos) {
        return this.state[nstate][pos.getY()][pos.getX()];
    }
    
    
    public void updateState(position pos) {
        
    }
    
    
}
