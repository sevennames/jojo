package game_content.gameMap;

import game_content.BeImage;

import java.awt.*;
import java.io.File;

public class GameMap implements BeImage {

    Entrance nextlevel;
    Image img;
    public GameMap(){

    }

    public Entrance getNextlevel(){
        return nextlevel;
    }
    @Override
    public void imagenary() {

    }
}
