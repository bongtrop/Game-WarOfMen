public class Panda extends Character
{
    public Panda()
    {
        super();
        x = 10;
        y = 14;
        character = new String[] {"images/panda-0.png",
                                  "images/panda-1.png",
                                  "images/panda-2.png",
                                  "images/panda-3.png",
                                  "images/panda-4.png"
                                 };
                                  
        outCharacter = character[tid];
    }
    
    public void clear() {
        isDied = false;
        x = 10;
        y = 14;
        tid = S;
        outCharacter = character[tid];
    }
}
