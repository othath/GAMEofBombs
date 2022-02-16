import greenfoot.*;

public class Block extends Actor
{
    //check collision with other objects of any class
    public boolean checkCollisions(int x,int y,Class cls)
    {
      Actor actor = getOneObjectAtOffset(x,y,cls);
      return actor != null;
    }    
}
