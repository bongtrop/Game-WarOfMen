public class Sanook extends Character
{
    public Sanook()
    {
        super();
        x = 19;
        y = 0;
        character = new String[] {"images/sanook-0.png",
                                  "images/sanook-1.png",
                                  "images/sanook-2.png",
                                  "images/sanook-3.png",
                                  "images/sanook-4.png"
                                 };
        outCharacter = character[tid];
    }
    
    public void clear() {
        isDied = false;
        x = 19;
        y = 0;
        tid = S;
        outCharacter = character[tid];
    }
}
