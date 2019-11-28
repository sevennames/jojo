package game_content.person;

import game_content.BeImage;
import game_content.Box;
import game_content.GameObject;
import game_content.barrage.Bullet;
import game_content.barrage.*;
import game_content.barrage.Shot;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Player implements BeImage, GameObject {
    public double x;
    public double y;
    public double  dir;
    public int speed;
    Box jojo=new Box(x,y,2);
    int HP=100;
    ArrayList<Bullet> barrage;
    Bullet attack;
    Image appearance;

    public abstract void attack();
    public abstract void stopAttack();

    public void move(double x,double y){
        this.x=x;
        this.y=y;
    }

    public void move(String dir){
        switch (dir){
            case "w":
                this.dir=90;
                y+=speed;
                break;
            case "a":
                this.dir=180;
                x-=speed;
                break;
            case "s":
                this.dir=-90;
                y-=speed;
                break;
            case "d":
                this.dir=0;
                x+=speed;
                break;
        }
    }

    public boolean hitted(ArrayList<Bullet> barrage){
        for(Bullet b:barrage){
            for(Box edge : b.getHitbox()){
                if(edge.hit(this.jojo)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean behitted(GameObject from) {
        for(Box atk:from.getHitbox()){
            if(atk.hit(this.jojo)){
                this.HP-=from.getdamage();
                return true;
            }
        }
        return false;
    }

    @Override
    public void toattack(int damage) {
        this.HP-=damage;
    }

    @Override
    public Box[] getHitbox() {
        return new Box[]{this.jojo};
    }

    @Override
    public void imagenary(){

    }
}
