package game_content.barrage;

import game_content.Box;

public class Shot extends Bullet {
    public Shot(double x,double y,double dir,int damage){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.hitbox=new Box[1];
        hitbox[0]=new Box(x,y,screenwidth/40);
        this.damage=damage;
        this.speed=4;
        this.HP=-1;
    }
    @Override
    public void reposition(double dir) {//远程替身的子弹发射出去之后一直只按原轨道运行，不需要position之类的方法
        return;
    }

    @Override
    protected void position() {
        return;
    }

    @Override
    public boolean alive() {
        if(this.outEdge()){
            return false;
        }
        return true;
    }//远程射击型替身

}
