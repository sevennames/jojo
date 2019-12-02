package game_content.barrage;

import game_content.BeImage;
import game_content.Box;
import game_content.GameObject;

import javax.swing.*;
import java.awt.*;

public abstract class Bullet implements BeImage, GameObject {
    public double x;
    public double y;
    public double dir;
    Box[] hitbox;
    public int speed;
    int damage;
    int HP;
    Image appearance;

    abstract protected void reposition(double dir);
    abstract protected void position();
    abstract public boolean alive();

    public void setbarrage(double x,double y,double dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }


    public void update(){//更新判定点位置
        if(!this.alive()){
            return;
        }
        this.x=this.x+speed*Math.cos(dir);
        this.y=this.y+speed*Math.sin(dir);
        this.position();
        imagenary();
    }

    protected String atEdge(){
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

    protected boolean outEdge(){
        for(Box edge:this.hitbox){
            if(screenwidth+edge.r>edge.x && screenlength+edge.r>edge.y && edge.x>-edge.r && edge.y>-edge.r){
                return false;
            }
        }
        return true;
    }

    @Override
    public int getdamage(){
        int a=damage;
        return a;
    }

    @Override
    public void toattack(int damage){
        this.HP-=damage;
    }

    @Override
    public boolean behitted(GameObject atk){
        for(Box body:this.hitbox){
            for(Box strike:atk.getHitbox()){
                if(strike.hit(body)){
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean hit(GameObject to){
        for(Box body:this.getHitbox()){
            for(Box hitted:to.getHitbox()){
                if(body.hit(hitted)){
                    return true;
                }
            }
        }
        return false;
    }
    protected double ImgAngle(){  //画图时的角度坐标可能和设计使用的角度坐标不同，这个用于转换
        return (this.dir+90)%360;
    }

    @Override
    public Box[] getHitbox(){
        Box[] a=hitbox;
        return a;
    }

    @Override
    public void imagenary() {
    }
}
