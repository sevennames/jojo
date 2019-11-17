package game_content.barrage;

import game_content.BeImage;
import game_content.Box;

import javax.swing.*;
import java.awt.*;

public abstract class Bullet implements BeImage {
    public double x;
    public double y;
    public double dir;
    final static double screenwidth=200;
    final static double screenlength=400;
    Box[] hitbox;
    public int speed;
    int damage;
    int HP;
    public boolean exist=true;
    Image appearance;

    abstract public void reposition(double dir);
    abstract protected void position();
    abstract public void move();
    abstract public boolean exit();

    public void setbarrage(double x,double y,double dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }

    public int getDamage(){
        int a=damage;
        return a;
    }

    public Box[] getHitbox(){
        Box[] a=hitbox;
        return a;
    }

    public String atEdge(){
        for(Box edge:this.hitbox){
            if(edge.hit("x",0)){
                return "left";
            }
            if(edge.hit("x",screenwidth)){
                return "right";
            }
            if(edge.hit("y",0)){
                return "down";
            }
            if(edge.hit("y",screenlength)){
                return "up";
            }
        }
        return "false";
    }

    public boolean outEdge(){
        for(Box edge:this.hitbox){
            if(screenwidth>edge.x+edge.r && screenlength>edge.y+edge.r && edge.x>edge.r && edge.y>edge.r){
                return false;
            }
        }
        return true;
    }

    public double ImgAngle(){  //画图时的角度坐标可能和设计使用的角度坐标不同，这个用于转换
        return (this.dir+90)%360;
    }

    @Override
    public void imagenary() {
    }
}
