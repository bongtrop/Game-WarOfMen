import ucigame.*;
/**
  * This class use to create Applet , draw canvas and play sound
  * 
  * @author (Pongsakorn Sommalai) 
  * @version (29/8/2556)
**/
public class WarOfMen extends Ucigame
{
    private State state;
    private Kapook kapook;
    private Sanook sanook;
    private Panda panda;
    private Weapon arrow, fire, bamboo;
    private Skill sob, bod;
    private Image pblock, pcharacter, pskill;
    private AI ai;
    private boolean isStart;
    private String scene[];
    private int numScene;
    private Sound music;
    private Sound skapook;
    private Sound ssanook;
    private Sound spanda;
    private Sound skapookdie;
    private Sound ssanookdie;
    private Sound spandadie;
    
    
    public void setup()
    {
        window.size(800, 600);
        window.title("War Of Men");
        canvas.background(214, 187, 150);
        framerate(15);
        kapook = new Kapook();
        sanook = new Sanook();
        panda = new Panda();
        arrow = new Arrow();
        fire = new Fire();
        bamboo = new Bamboo();
        sob = new SeaOfBamboo();
        bod = new BambooOfDied();
        ai = new AI(15);
        state = new State(ai.randomState());
        
        isStart = false;
        numScene = 0;
        scene = new String[] {"images/title.png", "images/youwin.png", "images/gameover.png"};
        
        music = getSound("sounds/music.mp3");
        skapook = getSound("sounds/kapook.mp3");
        ssanook = getSound("sounds/sanook.mp3");
        spanda = getSound("sounds/panda.mp3");
        skapookdie = getSound("sounds/kapookdie.mp3");
        ssanookdie = getSound("sounds/sanookdie.mp3");
        spandadie = getSound("sounds/pandadie.mp3");
        
        music.loop();
    }

    public void draw()
    {
        canvas.clear();
        
        if (!isStart) {
            pblock = getImage(scene[numScene],255,255,255);
            pblock.draw(0,0);
            return;
        }
        
        boolean iarrow = false;
        boolean ifire = false;
        boolean ibamboo = false;
        boolean skill1 = false;
        boolean skill2 = false;
        String sPanda="";
        skill1=sob.deley();
        skill2=bod.deley();
        if (sob.getStatus()) {
            sPanda="r";
        }
        if (bod.getStatus()) {
            sPanda="g";
        }
        
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
                
                if(panda.getX()==i  && panda.getY()==j) {
                    pcharacter = getImage(panda.getImage(sPanda), 255, 255, 255);
                    pcharacter.draw(i*state.WIDTH,j*state.WIDTH);
                }
                
                if(arrow.getX()==i  && arrow.getY()==j && !arrow.isHide()) {
                    pskill = getImage(arrow.getImage(), 255, 255, 255);
                    pskill.draw(i*state.WIDTH,j*state.WIDTH);
                    iarrow = true;
                }
                
                if(fire.getX()==i  && fire.getY()==j && !fire.isHide()) {
                    pskill = getImage(fire.getImage(), 255, 255, 255);
                    pskill.draw(i*state.WIDTH,j*state.WIDTH);
                    ifire = true;
                }
                
                if(bamboo.getX()==i  && bamboo.getY()==j && !bamboo.isHide()) {
                    pskill = getImage(bamboo.getImage(), 255, 255, 255);
                    pskill.draw(i*state.WIDTH,j*state.WIDTH);
                    ibamboo = true;
                }
                
                if (skill1 && i%2==1 && j%2==1) {
                    pskill = getImage(sob.getImage(), 255, 255, 255);
                    pskill.draw(i*state.WIDTH,j*state.WIDTH);
                }
                
                if (skill2 && (panda.getX()+3>=i && panda.getX()-3<=i) && (panda.getY()+3>=j && panda.getY()-3<=j)) {
                    pskill = getImage(sob.getImage(), 255, 255, 255);
                    pskill.draw(i*state.WIDTH,j*state.WIDTH);
                }
            }
        }
        
        if (iarrow) 
        {
            arrow.next();
            checkCrash(arrow);
        }
        
        if (ifire) 
        {
            fire.next();
            checkCrash(fire);
        }
        
        if (ibamboo) 
        {
            bamboo.next();
            checkCrash(bamboo);
        }
        
        if (skill2) {
            if ((panda.getX()+3>=kapook.getX() && panda.getX()-3<=kapook.getX()) && (panda.getY()+3>=kapook.getY() && panda.getY()-3<=kapook.getY()) && !kapook.isDied()) {
                kapook.die();
                skapookdie.play();
            }
            if ((panda.getX()+3>=sanook.getX() && panda.getX()-3<=sanook.getX()) && (panda.getY()+3>=sanook.getY() && panda.getY()-3<=sanook.getY()) && !sanook.isDied()) {
                sanook.die();
                ssanookdie.play();
            }
        }
        
        if (skill1) {
            if (kapook.getX()%2==1 && kapook.getY()%2==1 && !kapook.isDied()) {
                kapook.die();
                skapookdie.play();
            }
            if (sanook.getX()%2==1 && sanook.getY()%2==1 && !sanook.isDied()) {
                sanook.die();
                ssanookdie.play();
            }
        }
        
        killPanda();
        killSanook();
        killKapook();
        
        if (panda.isDied()) {
            numScene = 1;
            isStart = false;
            panda.clear();
            kapook.clear();
            sanook.clear();
            state = new State(ai.randomState());
        }
        
        if (sanook.isDied() && kapook.isDied()) {
            numScene = 2;
            isStart = false;
            panda.clear();
            kapook.clear();
            sanook.clear();
            state = new State(ai.randomState());
        }
        
        changeAI();
    }
    
    private void killPanda()
    {
        if (panda.getX()==fire.getX() && panda.getY()==fire.getY() && !fire.isHide() && !panda.isDied()) 
        {
             panda.die();
             spandadie.play();
        }
        
        if (panda.getX()==arrow.getX() && panda.getY()==arrow.getY() && !arrow.isHide() && !panda.isDied())
        {
            panda.die();
            spandadie.play();
        }
    }
    
    private void killKapook()
    {
        if (kapook.getX()==bamboo.getX() && kapook.getY()==bamboo.getY() && !bamboo.isHide() && !kapook.isDied())
        {
             kapook.die();
             skapookdie.play();
        }
    }
    
    private void killSanook()
    {
        if (sanook.getX()==bamboo.getX() && sanook.getY()==bamboo.getY() && !bamboo.isHide() && !sanook.isDied())
        {
             sanook.die();
             ssanookdie.play();
        }
    }
    
    private void changeAI() 
    {
        int tid;
        tid = ai.randomWalk();
        if (tid != -1)
        {
            panda.turn(tid);
            
            if (tid == panda.N)
            {
                if (state.canWalk(panda.getX(),panda.getY()-1)) 
                {
                    panda.walk(panda.N);
                }
            }
            if (tid == panda.S)
            {
                if (state.canWalk(panda.getX(),panda.getY()+1)) 
                {
                    panda.walk(panda.S);
                }
            }
            if (tid == panda.W)
            {
                if (state.canWalk(panda.getX()-1,panda.getY())) 
                {
                    panda.walk(panda.W);
                }
            }
            if (tid == panda.E)
            {
                if (state.canWalk(panda.getX()+1,panda.getY())) 
                {
                    panda.walk(panda.E);
                }
            }
        }
        tid = ai.attack(panda.getX(), sanook.getX(), panda.getY(), sanook.getY());
        if (tid!=-1 && !sanook.isDied()) {
            panda.turn(tid);
            if (panda.attack(bamboo)) {
                spanda.play();
            }
        }
        tid = ai.attack(panda.getX(), kapook.getX(), panda.getY(), kapook.getY());
        if (tid!=-1 && !kapook.isDied()) {
            panda.turn(tid);
            if (panda.attack(bamboo)) {
                spanda.play();
            }
        }
        
        if (ai.randomAttack()) 
        {
            if (panda.attack(bamboo)) {
                spanda.play();
            }
        }
        
        tid = ai.randomSkill();
        if (tid==1 && !sob.getStatus() && !bod.getStatus()) {
            sob.setStatus(true);
        }
        if (tid==0 && !bod.getStatus() && !sob.getStatus()) {
            bod.setStatus(true);
        }
            
    }
    
    private void checkCrash(Weapon obj)
    {
        if (!state.checkOutState(obj.getX(), obj.getY())) 
        {
            int symbol = state.getSymbol(obj.getX(),obj.getY());
            if (symbol == state.WOOD || symbol == state.BWOOD || symbol == state.STONE)
            {
                if (symbol == state.WOOD)
                {
                    state.setSymbol(obj.getX(), obj.getY(), state.BWOOD);
                }
                else if (symbol == state.BWOOD)
                {
                    state.setSymbol(obj.getX(), obj.getY(), state.GROUND);
                }
                obj.setHide();
            }
        } else {
            obj.setHide();
        }
    }
    
    public void onKeyRelease()
    {
        if(keyboard.key() == keyboard.W) {
            kapook.turn(kapook.N);
            if (state.canWalk(kapook.getX(),kapook.getY()-1)) {
                kapook.walk(kapook.N);
            }
        }
        if(keyboard.key() == keyboard.S) {
            kapook.turn(kapook.S);
            if (state.canWalk(kapook.getX(),kapook.getY()+1)) {
                kapook.walk(kapook.S);
            }
        }
         if(keyboard.key() == keyboard.A) {
            kapook.turn(kapook.W);
            if (state.canWalk(kapook.getX()-1,kapook.getY())) {
                kapook.walk(kapook.W);
            }
        }
        if(keyboard.key() == keyboard.D) {
            kapook.turn(kapook.E);
            if (state.canWalk(kapook.getX()+1,kapook.getY())) {
                kapook.walk(kapook.E);
            }
        }
        
        if(keyboard.key() == keyboard.UP) {
            sanook.turn(sanook.N);
            if (state.canWalk(sanook.getX(),sanook.getY()-1)) {
                sanook.walk(sanook.N);
            }
        }
        if(keyboard.key() == keyboard.DOWN) {
            sanook.turn(sanook.S);
            if (state.canWalk(sanook.getX(),sanook.getY()+1)) {
                sanook.walk(sanook.S);
            }
        }
         if(keyboard.key() == keyboard.LEFT) {
            sanook.turn(sanook.W);
            if (state.canWalk(sanook.getX()-1,sanook.getY())) {
                sanook.walk(sanook.W);
            }
        }
        if(keyboard.key() == keyboard.RIGHT) {
            sanook.turn(sanook.E);
            if (state.canWalk(sanook.getX()+1,sanook.getY())) {
                sanook.walk(sanook.E);
            }
        }
        
        if(keyboard.key() == keyboard.ENTER) {
            if (sanook.attack(arrow)) {
                ssanook.play();
            }
        }
        if(keyboard.key() == keyboard.H) {
            if (kapook.attack(fire)) {
                skapook.play();
            }
        }
        
        if(keyboard.key() == keyboard.SPACE) {
            isStart = true;
        }
    }
}
