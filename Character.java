
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Position
{
    // instance variables - replace the example below with your own
    protected String character[];
    protected String outCharacter;
    protected int tid;
    protected boolean isDied;
    
    public Character() {
        tid = S;
        isDied = false;
    }
    
    public void walk(int tid)
    {
        if (isDied) {
            return;
        }
        
        if (tid==N) {
            y--;
        }
        if (tid==S) {
            y++;
        }
        if (tid==W) {
            x--;
        }
        if (tid==E) {
            x++;
        }
    }
    
    public void turn(int tid) {
        if (isDied) {
            return;
        }
        
        this.tid=tid;
        outCharacter = character[tid];
    }
    
    public String getImage() {
        return outCharacter;
    }
    
    public boolean attack(Skill obj) {
        if (isDied) {
            return false;
        }
        
        if (obj.isHide()) {
            obj.start(x, y, tid);
            return true;
        }
        
        return false;
    }
    
    public void die() {
        outCharacter = character[4];
        isDied = true;
    }
    
    public boolean isDied() {
        return isDied;
    }
}
