
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character
{
    // instance variables - replace the example below with your own
    protected int x;
    protected int y;
    protected String character[];
    protected String outCharacter;
    public static final int N = 0;
    public static final int S = 1;
    public static final int W = 2;
    public static final int E = 3;

    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
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
        outCharacter = character[tid];
    }
    
    public String getImage() {
        return outCharacter;
    }
}
