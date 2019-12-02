package game_content.person;

import game_content.BeImage;
import game_content.Box;
import game_content.GameObject;
import game_content.barrage.Bullet;

import java.awt.*;
import java.util.ArrayList;

public abstract class Enemy implements BeImage , GameObject {
    public double x;
    public double y;
    public double dir;
    boolean alive=true;
    int Hp;
    Box dio=new Box(x,y,2);
    Bullet[] attackMethod;
    ArrayList<Bullet> enemyBullets;//敌人的弹幕池的
    Player me;//对于玩家的引用，方便实现自机狙一类的功能
    Image appearance;


    public abstract void move();
    public abstract void attack();
    abstract public void update(int time);

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

    @Override
    public void toattack(int damage) {
        this.Hp-=damage;
        if(Hp<0){
            this.alive=false;
            //notify
        }

    }

    @Override
    public Box[] getHitbox() {
        return new Box[]{this.dio};
    }
}
