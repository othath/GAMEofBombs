import greenfoot.*;

public class BombPlus extends Powers
{
    public void act()
    {
        Actor pow1 = getOneObjectAtOffset(0, 0,Player1.class);
        Actor pow2 = getOneObjectAtOffset(0, 0,Player2.class);

        if (pow1 != null)
        {
            getWorld().getObjects(Player1.class).get(0).increaseBombs();
            Greenfoot.playSound("woah.mp3");
            getWorld().removeObject(this);
        }
        else if (pow2 != null)
        {
            getWorld().getObjects(Player2.class).get(0).increaseBombs();
            getWorld().removeObject(this);
        }
    }
}
