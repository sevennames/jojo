package game_content.person;

import game_content.Box;
import game_content.GameObject;
import game_content.barrage.Bullet;
import game_content.barrage.Fist;
import game_content.barrage.Shot;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player_far extends Player{
    public Player_far(double x,double y,int damage,ArrayList<Bullet> myBullet,ArrayList<Bullet> enemyBullet){
        this.x=x;
        this.y=y;
        this.dir=90;
        this.attackMethod=new Shot(x,y,dir,damage);
        this.mybarrage=myBullet;
        this.enemyBarrage=enemyBullet;
    }

    public void update(String input){//可能要在主程序中判断是远程型还是近身型，远程型替身需要额外调用hit(ArrayList)的函数
        //move,attack
        for(Bullet enemyATK:this.enemyBarrage){
            if(this.behitted(enemyATK)){
                this.toattack(enemyATK.getdamage());
            }
        }
    }

    public void deleteBullet(){
        for(Bullet x:mybarrage){
            if(!x.alive()){
                mybarrage.remove(x);
            }
        }
    }
    @Override
    public void move(String dir){//得确保不会走出边界
        super.move(dir);
        this.attackMethod.setbarrage(this.x,this.y,this.dir);
    }

    @Override
    public void attack() {
        mybarrage.add(new Shot(this.x,this.y,this.dir,this.attackMethod.getdamage()));
    }


    public void hit(ArrayList<GameObject> enemy){//不能消弹，所以远程型替身的主角hit判定的是是否击中敌人
        for(GameObject object:enemy){
            if(this.hit(object)){
                object.toattack(this.attackMethod.getdamage());
            }
        }
    }

    @Override
    public boolean hit(GameObject to) {
        for(Bullet shot:this.mybarrage){
            if(shot.hit(to)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getdamage() {
        return this.attackMethod.getdamage();
    }
}
