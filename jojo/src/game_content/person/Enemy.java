package game_content.person;

import game_content.BeImage;
import game_content.Box;
import game_content.barrage.Bullet;

import java.awt.*;
import java.util.ArrayList;

public abstract class Enemy implements BeImage {
    public double x;
    public double y;
    public double dir;
    int Hp;
    Box dio=new Box(x,y,2);
    Bullet[] attack;
    Image appearance;

    public abstract void move();
    public abstract void attack(ArrayList<Bullet> enemyBarrage);

    public boolean hitted(ArrayList<Bullet> barrage){
        for(Bullet b:barrage){
            for(Box edge : b.getHitbox()){
                if(edge.hit(this.dio)){
                    return true;
                }
            }
        }
        return false;
    }

    public void imagenary(){
    }
}
