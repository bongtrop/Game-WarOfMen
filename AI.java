import java.util.Random;

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
