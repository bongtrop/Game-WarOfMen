
/**
 * Write a description of interface iState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface iState
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    void setState(int stat);
    int getSymbol(position pos);
    void updateState(position pos);
}
