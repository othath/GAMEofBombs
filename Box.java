import greenfoot.*;

public class Box extends Solid
{
    public void act()
    {
      if(checkCollisions(0,0,Fire.class))
      {
        getWorld().removeObject(this);
      }
    }
}
