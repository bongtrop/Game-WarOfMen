public class Swordman
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private String pswordman;
    public static final int N = 0;
    
    /**
     * Constructor for objects of class Swordman
     */
    public Swordman()
    {
        // initialise instance variables
        x = 0;
        y = 0;
        pswordman = "images/swordman-0.png";
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
            pswordman = "images/swordman-1.png";
        }
        if (tid==1) {
            y++;
            pswordman = "images/swordman-0.png";
        }
        if (tid==2) {
            x--;
            pswordman = "images/swordman-2.png";
        }
        if (tid==3) {
            x++;
            pswordman = "images/swordman-3.png";
        }
    }
    
    public String getImage() {
        return pswordman;
    }
}
