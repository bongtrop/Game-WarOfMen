/**
  * This interface of all skill 
  * 
  * @author (Apiwat Ruemsuk) 
  * @version (29/8/2556)
**/
public interface Weapon
{
    public void start(int x, int y, int tid);
    public void next();
    public boolean isHide();
    public void setHide();
    public String getImage();
    public int getX();
    public int getY();
}
