import ucigame.*;

public class WarOfMen extends Ucigame
{
    private State state;
    private Kapook kapook;
    private Sanook sanook;
    private Image pblock;
    private Image pcharacter;
    
    public void setup()
    {
        window.size(800, 600);
        window.title("War of men");
        canvas.background(214, 187, 150);
        framerate(15);
        state = new State();
        kapook = new Kapook();
        sanook = new Sanook();
    }

    public void draw()
    {
        canvas.clear();
        
        for (int i=0;i<state.MAX_COL;i++) {
            for (int j=0;j<state.MAX_ROW;j++) {
                
                pblock = getImage(state.getImage(i, j),255,255,255);
                pblock.draw(i*state.WIDTH,j*state.WIDTH);
                
                if(kapook.getX()==i  && kapook.getY()==j) {
                    pcharacter = getImage(kapook.getImage(), 255, 255, 255);
                    pcharacter.draw(i*state.WIDTH,j*state.WIDTH);
                }
                
                if(sanook.getX()==i  && sanook.getY()==j) {
                    pcharacter = getImage(sanook.getImage(), 255, 255, 255);
                    pcharacter.draw(i*state.WIDTH,j*state.WIDTH);
                }
            }
        }
    }
    
    public void onKeyRelease()
    {
        if(keyboard.key() == keyboard.W) {
            if (state.canWalk(kapook.getX(),kapook.getY()-1)) {
                kapook.walk(kapook.N);
            }
        }
        if(keyboard.key() == keyboard.S) {
            if (state.canWalk(kapook.getX(),kapook.getY()+1)) {
                kapook.walk(kapook.S);
            }
        }
         if(keyboard.key() == keyboard.A) {
            if (state.canWalk(kapook.getX()-1,kapook.getY())) {
                kapook.walk(kapook.W);
            }
        }
        if(keyboard.key() == keyboard.D) {
            if (state.canWalk(kapook.getX()+1,kapook.getY())) {
                kapook.walk(kapook.E);
            }
        }
        
        if(keyboard.key() == keyboard.UP) {
            if (state.canWalk(sanook.getX(),sanook.getY()-1)) {
                sanook.walk(sanook.N);
            }
        }
        if(keyboard.key() == keyboard.DOWN) {
            if (state.canWalk(sanook.getX(),sanook.getY()+1)) {
                sanook.walk(sanook.S);
            }
        }
         if(keyboard.key() == keyboard.LEFT) {
            if (state.canWalk(sanook.getX()-1,sanook.getY())) {
                sanook.walk(sanook.W);
            }
        }
        if(keyboard.key() == keyboard.RIGHT) {
            if (state.canWalk(sanook.getX()+1,sanook.getY())) {
                sanook.walk(sanook.E);
            }
        }
    }
}
