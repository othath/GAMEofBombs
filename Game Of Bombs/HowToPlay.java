import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay extends World
{

    /**
     * Constructor for objects of class HowToPlay.
     * 
     */
    public HowToPlay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(25, 25, 32); 
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("space"))
	{
            MainWorld M = new MainWorld();
            Greenfoot.setWorld(M);
        }
        
    }
}
