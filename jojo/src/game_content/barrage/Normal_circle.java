package game_content.barrage;

import game_content.Box;

public class Normal_circle extends Bullet {
    private double radius;
    public Normal_circle(double x,double y,double radius,double dir,int damage,int HP,int speed){
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.radius=radius;
        this.damage=damage;
        this.HP=HP;
        this.speed=speed;
        Box[] circleBox={new Box(x,y,radius)};
        this.hitbox=circleBox;
    }
    public Normal_circle(double x,double y,double radius,double dir){
        this(x,y,radius,dir,10,10,1);
    }


    @Override
    protected void reposition(double dir) { //用于转向dir方向
        this.dir=dir;
        this.hitbox[0].x=this.x;
        this.hitbox[0].y=this.y;
    }

    @Override
    protected void position() {//根据弹幕定位点方向确定分布
        this.hitbox[0].x=this.x;
        this.hitbox[0].y=this.y;
    }

    public void update(){
        super.update();
        if(this.alive()){
            this.position();
        }
    }

    @Override
    public boolean alive() {
        if(this.HP<0||this.outEdge()){
            return false;
        }
        return true;
    }
}
