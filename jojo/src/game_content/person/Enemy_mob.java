package game_content.person;

import game_content.GameObject;
import game_content.barrage.Normal_circle;

public class Enemy_mob extends Enemy{
    public Enemy_mob(double x,double y,double dir,int HP,Player player) {
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.HP=HP;
        this.me=player;
        this.attackMethod=new Normal_circle[]{new Normal_circle(x,y,5,dir)};
    }

    @Override
    public void move() {

    }

    @Override
    public void attack() {
        this.enemyBullets.add(attackMethod[0]);
    }

    @Override
    public void update(int time) {
        if(this.alive()){
            this.move();
            if(time%100==0){
                this.attack();
            }
        }
    }

    @Override
    public boolean alive() {
        if(screenwidth+dio.r>dio.x && screenlength+dio.r>dio.y && dio.x>-dio.r && dio.y>-dio.r&&HP>0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean hit(GameObject to) {
        return false;
    }

    @Override
    public int getdamage() {
        return 0;
    }
}
