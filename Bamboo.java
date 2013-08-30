/**
  * This class use to make bamboo (bamboo is weapon of panda)
  * 
  * @author (Nont Panda) 
  * @version (29/8/2556)
**/
public class Bamboo extends Position implements Skill
{
    private boolean hide;
    private int tid;
    private String img[];

    public Bamboo()
    {
        // initialise instance variables
        hide = true;
        x = 19;
        y = 14;
        img = new String[] {"images/bamboo-0.png",
                            "images/bamboo-1.png",
                            "images/bamboo-2.png",
                            "images/bamboo-3.png"};
    }
    
    public void start(int x, int y, int tid)
    {
        this.x = x;
        this.y = y;
        this.tid = tid;
        hide = false;
    }
    
    public void next()
    {
        if (this.tid==N) {
            this.y--;
        }
        if (this.tid==S) {
            this.y++;
        }
        if (this.tid==W) {
            this.x--;
        }
        if (this.tid==E) {
            this.x++;
        }
    }
    
    public boolean isHide() 
    {
        return hide;
    }
    
    public void setHide()
    {
        hide = true;
    }
    
    public String getImage() {
        return img[tid];
    }
}
