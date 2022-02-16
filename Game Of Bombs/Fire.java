import greenfoot.*;

public class Fire extends Actor
{
    private int FireDisappear;
    public void act()
    {
      if(++FireDisappear == 10)
      {
        getWorld().removeObject(this);
      }
    }
}
