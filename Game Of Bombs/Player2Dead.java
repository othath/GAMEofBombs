import greenfoot.*;  
public class Player2Dead extends World
{
    GifImage gif=new GifImage("Player2won.gif");
    public Player2Dead()
    {    
        super(540, 540, 1); 
    }
    public void act()
    {
        setBackground(gif.getCurrentImage());
        if(Greenfoot.isKeyDown("r"))
        {
            MainWorld mainworld = new MainWorld();
            Greenfoot.setWorld(mainworld);
        }
        else if(Greenfoot.isKeyDown("q"))
        {
            Menu menu=new Menu();
            Greenfoot.setWorld(menu);
            Greenfoot.stop();
        }
    }
}
