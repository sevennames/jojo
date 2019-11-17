package game_content.gameMap;

import game_content.BeImage;
import game_content.Box;

public class Entrance implements BeImage {
    public double x;
    public double y;
    Box range=new Box(this.x,this.y,100);
    public Entrance(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Box gotoNext(){
        return range;
    }

    @Override
    public void imagenary() {

    }
}
