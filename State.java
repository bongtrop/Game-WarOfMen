
/**
 * Write a description of class State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class State
{
    // instance variables - replace the example below with your own
    private int x;
    private int state[][][];
    public static final int MAX_COL = 20;
    public static final int MAX_ROW = 15;
    public static final int WIDTH = 40;
    
    /**
     * Constructor for objects of class State
     */
    public State()
    {
        state = new int[][][] {{{0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0},
                                {0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0},
                                {0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0},
                                {0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0}}};
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getSymbol(int x, int y)
    {
        // put your code here
        return state[0][y][x];
    }
    
    public String getImage(int x, int y)
    {
        String block = "images/block.png";
        String bg = "images/bg.png";

        if (state[0][y][x]==1) {
            return block;
        } else {
            return bg;
        }
            
    }
    
    public void setSymbol(int x, int y, int value) {
        state[0][y][x] = value;
    }
}
