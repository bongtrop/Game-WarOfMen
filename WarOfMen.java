import ucigame.*;

public class WarOfMen extends Ucigame
{
    private State state;
    private Swordman swordman;
    private Image pblock;
    private Image pswordman;
    
    public void setup()
    {
        window.size(250, 250);
        window.title("War of men");
        canvas.background(255, 200, 255);
        pblock = getImage("images/block.png", 255, 255, 255);
        framerate(30);
        state = new State();
        swordman = new Swordman();
    }

    public void draw()
    {
        canvas.clear();
       
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if(state.getSymbol(i,j)==1){
                    pblock.draw(i*40,j*40);
                }
                if(swordman.getX()==i  && swordman.getY()==j) {
                    pswordman = getImage(swordman.getImage(), 255, 255, 255);
                    pswordman.draw(i*40,j*40);
                }
            }
        }
    }
    
    public void onKeyRelease()
    {
        if(keyboard.key() == keyboard.W) {
            if (swordman.getY()>0 && state.getSymbol(swordman.getX(),swordman.getY()-1)==0) {
                swordman.walk(0);
            }
        }
        if(keyboard.key() == keyboard.S) {
            if (swordman.getY()<4 && state.getSymbol(swordman.getX(),swordman.getY()+1)==0) {
                swordman.walk(1);
            }
        }
         if(keyboard.key() == keyboard.A) {
            if (swordman.getX()>0 && state.getSymbol(swordman.getX()-1,swordman.getY())==0) {
                swordman.walk(2);
            }
        }
        if(keyboard.key() == keyboard.D) {
            if (swordman.getX()<4 && state.getSymbol(swordman.getX()+1,swordman.getY())==0) {
                swordman.walk(3);
            }
        }
    }
}
