import greenfoot.*;
import java.util.*;
import java.awt.Point;
public class MainWorld extends World
{
    public MainWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(25, 25, 32);
        int d = 6;

        Random rand = new Random();
        //list of block that need to be empty
        ArrayList<Point> E = new ArrayList<Point>();
        E.add(new Point(d+1, d+1));E.add(new Point(d+1, d+2));E.add(new Point(d+11, d+1));E.add(new Point(d+2, d+1));E.add(new Point(d+10, d+1));E.add(new Point(d+11, d+2));E.add(new Point(d+1, d+11));
        E.add(new Point(d+1, d+10));E.add(new Point(d+2, d+11));E.add(new Point(d+11, d+11));E.add(new Point(d+10, d+11));E.add(new Point(d+11, d+10));
        
        
        
        Player1 P1 = new Player1();
        
        Player2 P2 = new Player2();
        addObject(P1, d+1, d+1);
        addObject(P2, d+11, d+11);
  
        for(int i=0; i<13; i++)
        {
            addObject(new Wall(), d+i, d);
            addObject(new Wall(), d+i, d+12);
        }
        for(int i=1; i<12; i++){
            addObject(new Wall(), d, d+i);
            addObject(new Wall(), d+12, i+6);
        }
        for(int i=d+1; i<d+12;i++){
            for(int j=d+1; j<d+12; j++){
                if(i%2==0 && j%2==0){
                    addObject(new Wall(), i, j);
                }
            }
        }

        // random insert of blocks
        int p =0, q=0;
        for(int i=d+1; i<d+12;i++){
            for(int k=0; k<14; k++){
                int j = (int)(Math.random() * ((d+11) - (d+1) + 1) + (d+1));
                if (getObjectsAt(i,j, Solid.class).size() == 0){
                    int rd = rand.nextInt(10);
                    if ( rd == 0 && p<8){
                        addObject(new RangBooster(), i, j);
                        p++;
                    } else if (rd == 1 && q <8){
                        addObject(new BombPlus(), i, j);
                        q++;
                    }
                    addObject(new Box(), i, j);
                }
            }

        }

        setPaintOrder(Box.class);
        setPaintOrder(Fire.class);
        setPaintOrder(Player.class);

        // clearing area for the player
        for (Point P : E)
        {
            removeObjects(getObjectsAt((int)P.getX(),(int)P.getY(), Box.class));
            removeObjects(getObjectsAt((int)P.getX(),(int)P.getY(), Powers.class));
        }
        
        GreenfootSound sound = new GreenfootSound("main.mp3");
        sound.setVolume(20);
        sound.playLoop();
        
    }

       
}
