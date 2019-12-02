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
    int speed;
    Box jojo=new Box(x,y,2);
    int HP=100;
    ArrayList<Bullet> mybarrage;
    ArrayList<Bullet> enemyBarrage;
    Bullet attackMethod;
    Image appearance;

    public abstract void attack();

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

    public int behitted(ArrayList<Bullet> enemybarrage){
        int alldamage=0;
        for(Bullet b:enemybarrage){
            if(this.behitted(b)&&b.alive()){
                alldamage+=b.getdamage();
            }
        }
        return alldamage;
    }

    @Override
    public boolean behitted(GameObject from) {
        for(Box atk:from.getHitbox()){
            if(atk.hit(this.jojo)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void toattack(int damage) {
        this.HP-=damage;
        if(this.HP<0){
            //添加一个notify函数
        }
    }

    @Override
    public Box[] getHitbox() {
        return new Box[]{this.jojo};
    }

    @Override
    public void imagenary(){

    }
}
