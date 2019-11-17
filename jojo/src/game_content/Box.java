package game_content;

import java.io.IOException;

public class Box implements BeImage{
    public double x;
    public double y;
    public double r;
    public Box(double x,double y,double r){
        this.x=x;
        this.y=y;
        this.r=r;
    }
    public Box(double[] data){
        if(data.length!=3){
            throw new IllegalStateException();
        }else{
            this.x=data[0];
            this.y=data[1];
            this.r=data[2];
        }
    }
    private static double dsquare(double x1,double y1,double x2,double y2){
        return Math.pow(x1-x2,2)+Math.pow(y1-y2,2);
    }
    public boolean hit(Box circle2){
        if(dsquare(this.x,this.y,circle2.x,circle2.y)>Math.pow(circle2.r+this.r,2)){
            return false;
        }
        return true;
    }
    public boolean hit(String line,double xy){
        switch(line){
            case "x":
                if(Math.abs(xy-this.x)<this.r){
                    return true;
                }
                return false;
            case "y":
                if(Math.abs(xy-this.y)<this.r){
                    return true;
                }
                return false;
            default:System.out.println("wrong input");
        }
        return false;
    }
    public boolean hit(double x,double y){
        if(dsquare(this.x,this.y,x,y)<Math.pow(this.r,2)){
            return true;
        }
        return false;
    }
    public void imagenary(){
    }

}
