package game_content.person;

import game_content.Box;
import game_content.GameObject;
import game_content.barrage.Bullet;
import game_content.barrage.Fist;

import java.util.LinkedList;

public class Player_close extends Player{

    boolean attacking;
    public Player_close(double x,double y,int damage){
        this.x=x;
        this.y=y;
        this.dir=90;
        this.attack=new Fist(x,y,dir,damage);
    }


    @Override
    public void attack() {
        this.attacking=true;
        if(!this.barrage.contains(this.attack)){
            this.barrage.add(this.attack);
        }else{
            return;
        }
    }

    @Override
    public void move(String dir){
        super.move(dir);
        this.attack.setbarrage(this.x,this.y,this.dir);
    }
    public void stopAttack(){
        if(!this.barrage.isEmpty()){
            this.barrage.clear();
        }else{
            return;
        }
    }

    @Override
    public boolean hit(GameObject to) {
        for(Box fist:this.attack.getHitbox()){
            for(Box target:to.getHitbox()){
                if(fist.hit(target)){
                    to.toattack(this.attack.getdamage());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getdamage() {
        return this.attack.getdamage();
    }
}
