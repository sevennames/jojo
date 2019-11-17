package game_content.person;

import game_content.BeImage;
import game_content.Box;
import game_content.barrage.Bullet;
import game_content.barrage.*;
import game_content.barrage.Shot;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Player implements BeImage {
    final static double screenwidth=200;
    final static double screenlength=400;
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

    public void imagenary(){

    };
}
