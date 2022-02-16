import greenfoot.*;
import java.util.List;

public class RangBooster extends Powers
    {

        public void act()
        {
          Actor pow1 = getOneObjectAtOffset(0, 0,Player1.class);
          Actor pow2 = getOneObjectAtOffset(0, 0,Player2.class);
          if (pow1 != null)
          {
            getWorld().removeObject(this);
            Greenfoot.playSound("aha.mp3");
            Bomb1.Range++;
          }
          else if (pow2 != null)
          {
            getWorld().removeObject(this);
            Bomb2.Range++;
          }
    }        
}
