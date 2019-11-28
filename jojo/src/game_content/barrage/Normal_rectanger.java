package game_content.barrage;

import game_content.Box;

public class Normal_rectanger extends Bullet {
    private double width;
    private int ratio;
    private  double length;
    private int maxhit;
    private int hittimes=0;
    public Normal_rectanger(double x,double y,double width,int ratio,double dir,int damage,int HP,int speed,int maxhit){//为了确保能用一排圆逼近，用宽和长宽比来创建
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.damage=damage;
        this.HP=HP;
        this.speed=speed;
        this.width=width;
        this.length=ratio*width;
        this.maxhit=maxhit;
        Box[] shape=new Box[ratio];
        for(int i=0;i<ratio;i++){
            double shapex=x+i*width*Math.cos(dir);
            double shapey=y+i*width*Math.sin(dir);
            shape[i]=new Box(shapex,shapey,width/2);
        }
    }

    public Normal_rectanger(double x,double y,double width,int ratio,double dir){
        this(x,y,width,ratio,dir,20,20,1,1);
    }
    @Override
    protected void reposition(double dir) {
        this.dir=dir;
        this.x=this.hitbox[this.hitbox.length-1].x;
        this.y=this.hitbox[this.hitbox.length-1].y;
        position();
    }

    @Override
    protected void position() {
        for(int i=0;i<ratio;i++){
            hitbox[i].x=x+i*width*Math.cos(dir);
            hitbox[i].y=y+i*width*Math.sin(dir);

        }
    }
    private void reflect(){//考虑是否发生反射
        switch (super.atEdge()){
            case "up":
            case "down":
                this.reposition(-dir);
                break;
            case "left":
            case "right":
                this.reposition(180-this.dir);
                break;
            case "false":
                return;
        }
        return;

    }
    public void update(){
        if(!this.alive()){
            return;
        }
        if(this.atEdge()=="false"){
            super.update();
        }else{
            reflect();
            this.HP-=5;
        }
    }


    @Override
    public boolean alive() {
        if(this.outEdge()||this.HP<0){
            return false;
        }else{
            return true;
        }
    }

}
