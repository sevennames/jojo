package game_content.barrage;

import game_content.Box;

public class Normal_rectanger extends Bullet {
    private double width;
    private int ratio;
    private  double length;
    private int maxhit;
    private int hittimes=0;
    public Normal_rectanger(double x,double y,double width,int ratio,double dir,int damage,int HP,int speed,int maxhit){
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
    public void reposition(double dir) {
        this.dir=dir;
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
                this.dir=-dir;
                position();
                break;
            case "left":
            case "right":
                this.dir=180-dir;
                position();
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
        if (hittimes >= maxhit) {
            this.exist=false;
            return true;
        } else {
            return false;
        }
    }

}
