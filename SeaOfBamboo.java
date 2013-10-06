public class SeaOfBamboo implements Skill 
{
    private boolean hide;
    private int count;
    private String img;

    public SeaOfBamboo()
    {
        // initialise instance variables
        hide = false;
        count = 0;
        img = "images/bamboo-sk1.png";
    }
    
    public boolean deley()
    {
        if (count>20) {
            if (count>25) {
                count = 0;
                hide = false;
            }
            count++;
            return true;
        }
        if (hide==true) {
            count++;
        }
        return false;
    }
    
    public boolean getStatus() {
        return hide;
    }
    
    public void setStatus(boolean status) {
        hide = status;
    }
    
    public String getImage() {
        return img;
    }
}