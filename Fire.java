/**
  * This class use to make fire (fire is weapon of kapook)
  * 
  * @author (Nont Panda) 
  * @version (29/8/2556)
**/
public class Fire extends Position implements Skill
{
    private boolean hide;
    private int tid;
    private String img[];

    public Fire()
    {
        // initialise instance variables
        hide = true;
        img = new String[] {"images/fire-0.png",
                            "images/fire-1.png",
                            "images/fire-2.png",
                            "images/fire-3.png"};
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
