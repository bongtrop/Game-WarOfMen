
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
    public static final int GROUND = 0;
    public static final int STONE = 1;
    public static final int WATER = 2;
    public static final int WOOD = 3;
    public static final int BWOOD = 4;
    
    /**
     * Constructor for objects of class State
     */
    public State()
    {
        state = new int[][][] {
                               {
                                {0,0,0,0,0,0,0,0,3,3,3,0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,4,4,4,0,0,0,0,0,0,0,0,0},
                                {0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0},
                                {0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0},
                                {0,0,0,1,0,0,0,1,0,2,0,0,1,0,0,0,1,0,0,0},
                                {0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1},
                                {0,0,0,0,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,1},
                                {0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1},
                                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                                {0,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1},
                                {0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0},
                                {1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0},
                                {1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0},
                                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                               },
                                {{0,0,0,0,0,0,0,0,3,3,3,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,3,3,3,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,2,0,0,0,2,0,0,2,0,2,0,0,0,2,0,0},
                                 {0,0,0,0,2,0,0,0,2,0,0,2,0,2,0,0,0,2,0,0},
                                 {0,0,0,0,2,0,0,0,2,0,0,2,0,0,2,0,2,0,0,0},
                                 {0,0,0,0,2,0,0,0,2,0,0,2,0,0,2,0,2,0,0,0},
                                 {0,0,0,0,2,2,2,0,2,2,2,2,0,0,0,2,0,0,0,0},
                                 {0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,1,1,1,0,0},
                                 {0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0},
                                 {0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,0,1,0,0,0},
                                 {0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,0,0},
                                 {0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0}
                               }};
        
    }
    
    public boolean checkOutState(int x, int y) 
    {
        if (y<0 || x<0 || y>=MAX_ROW || x>=MAX_COL) {
            return true;
        }
        return false;
    }
    
    public boolean canWalk(int x, int y)
    {
        if (checkOutState(x, y) || state[0][y][x]!=0) {
            return false;
        }
        
        return true;
    }
    
    public String getImage(int x, int y)
    {
        String img[] = new String[] {"images/bg.png", 
                                     "images/stone.png",
                                     "images/water.png",
                                     "images/wood.png",
                                     "images/bwood.png"};

        return img[state[0][y][x]];
    }
    
    public void setSymbol(int x, int y, int value) {
        state[0][y][x] = value;
    }
    
    public int getSymbol(int x, int y) {
        return state[0][y][x];
    }
}
