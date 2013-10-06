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
    
    public int randomSkill()
    {
        int tid = rnd.nextInt(speed*10);
        if (tid<2) {
            return tid;
        }
        return -1;
    }
    
    public int attack(int x1, int x2, int y1, int y2)
    {
        if (x1==x2) {
            if (y1>y2) {
                return 0;
            } else {
                return 1;
            }
        }
        else if (y1==y2) {
            if (x1>x2) {
                return 2;
            } else {
                return 3;
            }
        } else {
            return -1;
        }
    }
    
    
    public boolean randomAttack()
    {
        int tid = rnd.nextInt(speed);
        if (tid>12) {
            return true;
        }
        return false;
    }
    
    public int randomState() {
        int tid = rnd.nextInt(3);
        return tid%3;
    }    
}
