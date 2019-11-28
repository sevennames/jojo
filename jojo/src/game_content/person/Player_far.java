package game_content.person;

import game_content.Box;
import game_content.GameObject;
import game_content.barrage.Bullet;
import game_content.barrage.Fist;
import game_content.barrage.Shot;

import java.util.LinkedList;

public class Player_far extends Player{
    public Player_far(double x,double y,int damage){
        this.x=x;
        this.y=y;
        this.dir=90;
        this.attack=new Shot(x,y,dir,damage);
    }

    @Override
    public void move(String dir){
        super.move(dir);
        this.attack.setbarrage(this.x,this.y,this.dir);
    }

    @Override
    public void attack() {
        barrage.add(new Shot(this.x,this.y,this.dir,this.attack.getdamage()));
    }

    @Override
    public void stopAttack() {//远程射击的弹幕的消除是看是否超过了边界，攻击的时候就将attack加入循环中，停止攻击就将attack拿出循环
    }

    @Override
    public boolean hit(GameObject to) {
        return true;
    }

    @Override
    public int getdamage() {
        return this.attack.getdamage();
    }
}
