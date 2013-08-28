public interface Skill
{
    public void start(int x, int y, int tid);
    public void next();
    public boolean isHide();
    public void setHide();
    public String getImage();
    public int getX();
    public int getY();
}
