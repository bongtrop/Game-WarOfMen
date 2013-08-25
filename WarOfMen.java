import ucigame.*;

public class WarOfMen extends Ucigame
{
    private State state;
    private Swordman swordman;
    private Image pblock;
    private Image pswordman;
    
    public void setup()
    {
        window.size(800, 600);
        window.title("War of men");
        canvas.background(255, 200, 255);
        framerate(15);
        state = new State();
        swordman = new Swordman();
    }

    public void draw()
    {
        canvas.clear();
       
        pblock = getImage(state.getImage(1, 1), 255, 255, 255);
        pblock.draw(1*state.WIDTH,1*state.WIDTH);
        
        
        for (int i=0;i<state.MAX_COL;i++) {
            for (int j=0;j<state.MAX_ROW;j++) {
                
                pblock = getImage(state.getImage(i, j));
                pblock.draw(i*state.WIDTH,j*state.WIDTH);
                
                if(swordman.getX()==i  && swordman.getY()==j) {
                    pswordman = getImage(swordman.getImage(), 255, 255, 255);
                    pswordman.draw(i*state.WIDTH,j*state.WIDTH);
                }
            }
        }
    }
    
    public void onKeyRelease()
    {
        if(keyboard.key() == keyboard.W) {
            if (state.canWalk(swordman.getX(),swordman.getY()-1)) {
                swordman.walk(swordman.N);
            }
        }
        if(keyboard.key() == keyboard.S) {
            if (state.canWalk(swordman.getX(),swordman.getY()+1)) {
                swordman.walk(swordman.S);
            }
        }
         if(keyboard.key() == keyboard.A) {
            if (state.canWalk(swordman.getX()-1,swordman.getY())) {
                swordman.walk(swordman.W);
            }
        }
        if(keyboard.key() == keyboard.D) {
            if (state.canWalk(swordman.getX()+1,swordman.getY())) {
                swordman.walk(swordman.E);
            }
        }
    }
}
