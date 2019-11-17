package game_content.barrage;

import game_content.Box;

public class Fist extends Bullet {
    public Fist(double x,double y,double dir,int damage){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.hitbox=new Box[2];
        hitbox[0]=new Box(x+(screenlength/12)*Math.cos(dir),y+(screenlength/12)*Math.sin(dir),screenlength/12);
        hitbox[1]=new Box(x+(screenlength/6)*Math.cos(dir),y+(screenlength/6)*Math.sin(dir),screenlength/12);
        this.speed=0;
        this.HP=-1;
        this.damage=damage;
    }

    @Override
    public void reposition(double dir) {
        this.dir=dir;
        position();
    }

    @Override
    protected void position() {
        hitbox[0]=new Box(x+(screenlength/12)*Math.cos(dir),y+(screenlength/12)*Math.sin(dir),screenlength/12);
        hitbox[1]=new Box(x+(screenlength/6)*Math.cos(dir),y+(screenlength/6)*Math.sin(dir),screenlength/12);
    }

    @Override
    public void move() {//近战替身的弹幕只随角色移动

    }

    @Override
    public boolean exit() {//不会退出
        return false;
    }
}
