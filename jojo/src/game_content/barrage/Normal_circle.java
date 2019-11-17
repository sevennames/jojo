package game_content.barrage;

import game_content.Box;

public class Normal_circle extends Bullet {
    private double radius;
    private int maxhit;
    private int hittimes;
    public Normal_circle(double x,double y,double radius,double dir,int damage,int HP,int speed,int maxhit){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.radius=radius;
        this.damage=damage;
        this.HP=HP;
        this.speed=speed;
        this.maxhit=maxhit;
        hittimes=0;
        Box[] circleBox={new Box(x,y,radius)};
        this.hitbox=circleBox;
    }
    public Normal_circle(double x,double y,double radius,double dir){
        this(x,y,radius,dir,10,10,1,1);
    }
    @Override
    public void reposition(double dir) { //用于转向dir方向
        this.dir=dir;
        this.hitbox[0].x=this.x;
        this.hitbox[0].y=this.y;
    }

    @Override
    protected void position() {//根据弹幕定位点方向确定分布
        this.hitbox[0].x=this.x;
        this.hitbox[0].y=this.y;
    }

    private void reflect(){//考虑是否发生反射
        switch (super.atEdge()){
            case "up":
                this.dir=-dir;
                break;
            case "down":
                this.dir=-dir;
                break;
            case "left":
                this.dir=180-dir;
                break;
            case "right":
                this.dir=180-dir;
                break;
            case "no":
                return;
        }
        hittimes++;
        return;

    }
    @Override
    public void move() {
        this.x=this.x+speed*Math.cos(dir);
        this.y=this.y+speed*Math.sin(dir);
        position();
        if(super.atEdge()!="no"){
            reflect();
        }
    }

    @Override
    public boolean exit() {
        if(hittimes>=maxhit){
            this.exist=false;
            return true;
        }else{
            return false;
        }
    }
}
