package game_content.person;

import game_content.Box;
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
        this.x=this.x+speed*Math.cos(dir);
        this.y=this.y+speed*Math.sin(dir);
    }

    @Override
    public void attack() {
        enemyBullets.add(new Normal_circle(this.x,this.y,2,this.shotdir()));
    }

    @Override
    public void update() {
        if(this.alive()){
            this.move();
            if(age%50==0){
                this.attack();
            }
            age+=10;
        }
    }

    @Override
    public boolean alive() {
        return screenwidth + dio.r > dio.x && screenlength + dio.r > dio.y && dio.x > -dio.r && dio.y > -dio.r && HP > 0;
    }


    @Override
    public boolean hit(GameObject to) {
        for(Box edge:to.getHitbox()){
            if(dio.hit(edge)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getdamage() {
        return 10;
    }
}
