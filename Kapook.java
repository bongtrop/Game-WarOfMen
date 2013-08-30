/**
  * This class use to make kapook (kapook is a character in game use magic for attack)
  * 
  * @author (Pongsakorn Sommalai) 
  * @version (29/8/2556)
**/
public class Kapook extends Character
{
    public Kapook()
    {
        super();
        x = 0;
        y = 0;
        character = new String[] {"images/kapook-0.png",
                                  "images/kapook-1.png",
                                  "images/kapook-2.png",
                                  "images/kapook-3.png",
                                  "images/kapook-4.png"
                                 };
                                  
        outCharacter = character[tid];
    }
    
    public void clear() {
        isDied = false;
        x = 0;
        y = 0;
        tid = S;
        outCharacter = character[tid];
    }
}
