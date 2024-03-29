package game_content.person;

import game_content.BeImage;
import game_content.Box;
import game_content.GameObject;
import game_content.barrage.Bullet;
import javafx.beans.InvalidationListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public abstract class Enemy extends Observable implements BeImage , GameObject{
    public double x;
    public double y;
    public double dir;
    int speed;
    int HP;
    int age=0;
    Box dio=new Box(x,y,2);
    Bullet[] attackMethod;
    static ArrayList<Bullet> enemyBullets;//敌人的弹幕池
    Player me;//对于玩家的引用，方便实现自机狙一类的功能
    Image appearance;


    public abstract void move();
    public abstract void attack();
    abstract public void update();
    abstract public boolean alive();

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

    protected double shotdir(){
        if(this.x==me.x){
            if(this.y>me.y){
                return -90;
            }else{
                return 90;
            }
        }
        return Math.atan((this.y-me.y)/(this.x-me.x));
    }

    public static void deleteBullet(){
        for(Bullet x:enemyBullets){
            if(!x.alive()){
                enemyBullets.remove(x);
            }
        }
    }
    @Override
    public void imagenary(){
    }

    @Override
    public void toattack(int damage) {
        this.HP-=damage;
        if(HP<0){
            this.setChanged();
            this.notifyObservers();
        }

    }

    @Override
    public Box[] getHitbox() {
        return new Box[]{this.dio};
    }

    @Override
    public boolean behitted(GameObject from) {
        for(Box bullet:from.getHitbox()){
            if(bullet.hit(this.dio)){
                return true;
            }
        }
        return false;
    }
}
