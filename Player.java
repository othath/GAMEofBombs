import greenfoot.*;
import java.util.List;

abstract public class Player extends Actor
{
    protected int Lives;
    protected int BombsCanPlace;
    protected boolean AlreadyTouchedBomb = true ;

    abstract public void placeBombs();
    abstract public void dead();

    //check collision with other objects of any class
    public boolean checkCollisions(int x,int y,Class cls)
    {
      Actor actor = getOneObjectAtOffset(x,y,cls);
      return actor != null;
    }


    //Player Movements along with all the possible collisions
    public void checkMovements(String UpKey,String DownKey,String RightKey,String LeftKey, String imgUp, String imgDown, String imgRight, String imgLeft)
    {
      int x=getX();
      int y=getY();

      if(Greenfoot.isKeyDown(UpKey))
      {
        setImage(imgUp);
        if(checkCollisions(0,-1,Solid.class))//check collisions with (Box,Wall and Bomb)
        {
          move(0);
        }
        else
        {
          setLocation(x,y-1);
        }
      }

      else if(Greenfoot.isKeyDown(DownKey))
      {
          setImage(imgDown);
        if(checkCollisions(0,1,Solid.class))//check collisions with (Box,Wall and Bomb)
        {
          move(0);
        }
        else
        {
          setLocation(x,y+1);
        }
      }

      else if(Greenfoot.isKeyDown(RightKey))
      {
        setImage(imgRight);
        if(checkCollisions(1,0,Solid.class))//check collisions with (Box,Wall and Bomb)
        {
          move(0);
        }
        else
        {
          setLocation(x+1,y);
        }
      }

      else if(Greenfoot.isKeyDown(LeftKey))
      {
        setImage(imgLeft);
        if(checkCollisions(-1,0,Solid.class))//check collisions with (Box,Wall and Bomb)
        {
          move(0);
        }
        else
        {
          setLocation(x-1,y);
        }
      }
    }


    //method for checking collisions with fire and reducing player's live by one

}
