import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Player1 extends Player
{
    public ArrayList <Life1> LP1 = new ArrayList<Life1>();
    
    
    public Player1()
    {
      Lives=3;
      BombsCanPlace=1;
      LP1.add(new Life1(0,0));
      LP1.add(new Life1(1,0));
      LP1.add(new Life1(2,0));
      
    }
    
    public void increaseBombs(){
        BombsCanPlace++;
    }
    
    
    public void act()
    {
      List BombsInWorld = getWorld().getObjects(Bomb1.class);
      List BombsInPlayerCorrd = getObjectsInRange(0,Bomb.class);
      checkMovements("up","down","right","left", "Gback.png","Gfront.png","Gright.png","Gleft.png");
      if(BombsInWorld.size() != BombsCanPlace && BombsInPlayerCorrd.size()==0)
      {
        placeBombs();
     }
      checkCollisionWithFire();
      dead();
      for(Life1 O : LP1){
          if (getWorld().getObjectsAt(O.x, O.y, Life1.class).size() == 0)
          getWorld().addObject(O, O.x, O.y);
        }
    }
    public void placeBombs()
    {  
      if(Greenfoot.isKeyDown("l"))
      {
        {
             getWorld().addObject(new Bomb1(),this.getX(),this.getY());}   
         }   
    }
    public void dead()
    {
      if(Lives == 0)
      {
        Greenfoot.playSound("winxp.mp3");  
        Player1Dead P1Dead = new Player1Dead();
        Greenfoot.setWorld(P1Dead);
      }
      
    }
    
    public void checkCollisionWithFire()
    {
      if(checkCollisions(0,0,Fire.class) && AlreadyTouchedBomb)
      {
        if(Lives != 0)
        {
          Lives--;
          Greenfoot.playSound("bruh.mp3");
          getWorld().removeObject(LP1.get(LP1.size() - 1));
          LP1.remove(LP1.size() - 1);
         
        }
        AlreadyTouchedBomb = false;
      }
      
      else if(!checkCollisions(0,0,Fire.class))
      {
        AlreadyTouchedBomb = true ;
      }
    }
        
        
    
}
