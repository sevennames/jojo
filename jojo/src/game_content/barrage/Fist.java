package game_content.barrage;

import game_content.Box;

public class Fist extends Bullet {
    private boolean attacking=false;

    public Fist(double x,double y,double dir,int damage){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.hitbox=new Box[2];
        hitbox[0]=new Box(x+(screenlength/12)*Math.cos(dir),y+(screenlength/12)*Math.sin(dir),screenlength/12);
        hitbox[1]=new Box(x+(screenlength/6)*Math.cos(dir),y+(screenlength/6)*Math.sin(dir),screenlength/12);
        this.speed=0;
        this.HP=10;
        this.damage=damage;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
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
    public void update(){//根据输入更新
        return;
    }

    @Override
    public boolean alive() {//不会退出
        return this.isAttacking();
    }
}
