import greenfoot.*;
public class Menu extends World
{
    GreenfootSound sound = new GreenfootSound("Opaul.mp3");
    public Menu()
    {    
        super(25, 25, 32); 
       
        sound.setVolume(50);
        sound.playLoop();
        
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("space"))
    {
            HowToPlay p = new HowToPlay();
            Greenfoot.setWorld(p);
            sound.stop();
        }
    }
    
}
