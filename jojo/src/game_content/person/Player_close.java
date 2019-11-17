package game_content.person;

import game_content.Box;
import game_content.barrage.Bullet;
import game_content.barrage.Fist;

import java.util.LinkedList;

public class Player_close extends Player{

    public Player_close(double x,double y,int damage){
        this.x=x;
        this.y=y;
        this.dir=90;
        this.attack=new Fist(x,y,dir,damage);
    }


    @Override
    public void attack() {
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
}
