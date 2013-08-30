import java.util.Random;

/**
  * Use to control Character by computer
  * 
  * @author (Pongsakorn Sommalai) 
  * @version (29/8/2556)
**/
public class AI
{
    private Random rnd;
    private int speed;
    
    public AI(int speed)
    {
        rnd = new Random();
        this.speed = speed;
    }

    public int randomWalk()
    {
        int tid = rnd.nextInt(speed);
        if (tid < 4) {
            return tid;
        }
        return -1;
    }
    
    public boolean randomAttack()
    {
        int tid = rnd.nextInt(speed);
        if (tid==0) {
            return true;
        }
        return false;
    }
}
