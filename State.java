
public class State
{
    // instance variables - replace the example below with your own
    private int x;
    private int state[][][];
    private int numState;
    public static final int MAX_COL = 20;
    public static final int MAX_ROW = 15;
    public static final int WIDTH = 40;
    public static final int GROUND = 0;
    public static final int STONE = 1;
    public static final int WATER = 2;
    public static final int WOOD = 3;
    public static final int BWOOD = 4;
    
    public State(int numState)
    {
        state = new int[][][] {
                               {
                                 {0,0,4,1,1,0,0,0,3,3,3,0,0,1,1,0,3,4,0,0},
                                 {0,4,4,3,0,0,0,0,0,3,0,0,0,1,1,0,0,3,4,0},
                                 {0,4,3,0,0,0,1,0,0,3,0,0,0,0,0,0,0,0,3,4},
                                 {1,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,3},
                                 {0,0,0,0,0,0,0,0,3,3,3,0,0,0,0,0,0,0,0,0},
                                 {3,2,2,2,3,0,2,2,2,2,0,1,1,1,1,0,3,3,0,0},
                                 {3,3,2,2,3,0,2,0,0,0,0,1,0,0,0,0,3,2,3,0},
                                 {3,2,3,2,3,0,2,2,2,2,0,1,1,1,1,0,3,2,2,3},
                                 {3,2,2,3,3,0,2,0,0,0,0,1,0,0,0,0,3,2,3,0},
                                 {3,2,2,2,3,0,2,2,2,2,0,1,1,1,1,0,3,3,0,0},
                                 {0,0,0,0,0,0,0,3,3,3,3,3,0,0,0,0,0,0,0,0},
                                 {2,0,0,0,0,0,0,3,0,0,0,3,0,0,0,0,0,0,0,2},
                                 {2,2,0,0,0,0,0,3,3,3,3,3,0,0,0,0,0,0,2,2},
                                 {1,2,2,0,0,0,0,3,0,0,0,3,0,0,0,0,0,2,2,1},
                                 {1,1,2,2,0,0,0,3,0,0,0,3,0,0,0,0,2,2,1,1}  
                               },
                                {{0,0,0,1,3,0,1,1,1,1,1,1,1,0,0,4,1,0,0,0},
                                 {0,0,0,3,4,0,0,0,0,1,1,0,0,0,0,4,1,0,3,3},
                                 {1,0,0,4,4,0,0,0,0,1,1,0,0,0,0,4,4,4,4,4},
                                 {4,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,0,0,3,3,0,0,0,1,3,3,3,3,3},
                                 {1,1,1,1,2,0,0,4,4,2,2,0,0,0,2,2,2,2,2,2},
                                 {2,2,2,2,2,0,0,2,2,2,2,0,0,0,2,2,2,2,2,2},
                                 {2,2,2,2,2,0,0,2,2,2,2,0,0,0,2,2,2,2,2,2},
                                 {2,2,2,2,2,0,0,2,2,2,2,0,0,0,2,2,2,2,2,2},
                                 {3,3,3,3,0,0,0,1,1,1,4,0,0,0,4,1,1,1,1,1},
                                 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                 {0,0,0,0,0,0,0,1,1,4,4,0,0,0,0,0,0,0,0,0},
                                 {4,4,4,0,0,0,0,4,3,3,4,0,0,0,0,0,0,3,3,3},
                                 {4,4,4,0,0,0,0,4,0,0,4,0,0,0,0,0,0,3,3,3},
                                 {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3}
                               },{
                                 {0,0,4,1,1,0,0,0,2,2,2,0,0,1,1,0,3,4,0,0},
                                 {0,4,4,3,0,0,0,0,0,2,0,0,0,1,1,0,0,3,4,0},
                                 {0,4,3,0,0,0,1,0,0,2,0,0,0,0,0,0,0,0,3,4},
                                 {1,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,3},
                                 {0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0},
                                 {3,0,0,0,0,3,3,3,3,0,3,0,0,0,3,0,3,3,3,3},
                                 {3,0,0,0,0,3,0,0,3,0,3,0,0,0,3,0,3,0,0,0},
                                 {3,0,0,0,0,3,0,0,3,0,3,0,0,0,3,0,3,3,3,3},
                                 {3,0,0,0,0,3,0,0,3,0,0,3,0,3,0,0,3,0,0,0},
                                 {3,3,3,3,0,3,3,3,3,0,0,0,3,0,0,0,3,3,3,3},
                                 {0,0,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,0},
                                 {0,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0},
                                 {0,0,1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0},
                                 {0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
                                 {0,0,1,1,1,1,0,1,0,0,0,0,0,0,1,1,1,1,0,0} 
                                }
                               
                                 
                            };
        
        this.numState = numState;
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

        return img[state[numState][y][x]];
    }
    
    public void setSymbol(int x, int y, int value) {
        state[numState][y][x] = value;
    }
    
    public int getSymbol(int x, int y) {
        return state[numState][y][x];
    }
}
