package game_content.person;

import game_content.Box;
import game_content.GameObject;
import game_content.barrage.Bullet;
import game_content.barrage.Fist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player_close extends Player{

    boolean attacking;

    public Player_close(double x, double y, int damage, ArrayList<Bullet> enemyBarrage){
        this.x=x;
        this.y=y;
        this.dir=90;
        this.attackMethod=new Fist(x,y,dir,damage);
        this.enemyBarrage=enemyBarrage;
    }

    public void update(String input){//根据输入更新
        //switch():attack,move；
        if(this.attacking=true){
            for(Bullet enemyATK:enemyBarrage){
                if(enemyATK.behitted(this.attackMethod)){
                    enemyATK.toattack(this.getdamage());
                }
            }
        }
        this.HP-=this.behitted(this.enemyBarrage);//判断敌人弹幕是否还存在已经放入这个方法里面了
        if(this.HP<0){
            //notify();
        }
        this.imagenary();
        this.attacking=false;//每次更新之后回归false，从而一旦停止攻击就不再进行攻击判断
    }

    @Override
    public void attack() {
        this.attacking=true;
    }


    @Override
    public void move(String dir){
        super.move(dir);
        this.attackMethod.setbarrage(this.x,this.y,this.dir);
    }

    @Override
    public boolean hit(GameObject to) {
        if(this.attackMethod.hit(to)&&this.attacking==true){
            return true;
        }
        return false;
    }

    @Override
    public int getdamage() {
        return this.attackMethod.getdamage();
    }
}
