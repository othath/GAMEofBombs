import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
public class Player2 extends Player
{
    public ArrayList <Life2> LP2 = new ArrayList<Life2>();
    public Player2()
    {
      Lives=3;
      BombsCanPlace=1;
      LP2.add(new Life2(24,24));
      LP2.add(new Life2(23,24));
      LP2.add(new Life2(22,24));
    }
    public void increaseBombs(){
        BombsCanPlace++;
    }
    public void act()
    {
      List BombsInWorld = getWorld().getObjects(Bomb2.class);
      checkMovements("w","s","d","a", "Bback.png","Bfront.png","Bright.png","Bleft.png");
      List BombsInPlayerCorrd = getObjectsInRange(0,Bomb.class);
      if(BombsInWorld.size() != BombsCanPlace && BombsInPlayerCorrd.size()==0)
      {
        placeBombs();
      }
      checkCollisionWithFire();
      dead();
      for(Life2 O : LP2){
          if (getWorld().getObjectsAt(O.x, O.y, Life1.class).size() == 0)
          getWorld().addObject(O, O.x, O.y);
        }
    }
    public void placeBombs()
    {
      if(Greenfoot.isKeyDown("space"))
      {
        getWorld().addObject(new Bomb2(),this.getX(),this.getY());
      }
    }
    public void dead()
    {
              if(Lives == 0)
      {
        Greenfoot.playSound("winxp.mp3");
        Player2Dead P2Dead = new Player2Dead();
        Greenfoot.setWorld(P2Dead);
      }
    }
    public void checkCollisionWithFire()
    {
      if(checkCollisions(0,0,Fire.class) && AlreadyTouchedBomb)
      {
        if(Lives != 0)
        {
          Greenfoot.playSound("fart.mp3");
          Lives--;
          getWorld().removeObject(LP2.get(LP2.size() - 1));
          LP2.remove(LP2.size() - 1);
         
        }
        AlreadyTouchedBomb = false;
      }
      
      else if(!checkCollisions(0,0,Fire.class))
      {
        AlreadyTouchedBomb = true ;
      }
    }
}
