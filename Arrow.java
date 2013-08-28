
public class Arrow extends Position implements Skill
{
    private boolean hide;
    private int tid;
    private String img[];

    public Arrow()
    {
        // initialise instance variables
        hide = true;
        img = new String[] {"images/arrow-0.png",
                            "images/arrow-1.png",
                            "images/arrow-2.png",
                            "images/arrow-3.png"};
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
