package game_content;

import game_content.barrage.Bullet;
import game_content.barrage.Normal_circle;
import game_content.person.Player_close;

import java.util.ArrayList;

public class Test {
    public static void main(String args[]){
        ArrayList<Bullet> enemyb=new ArrayList<Bullet>();
        enemyb.add(new Normal_circle(0,0,2,90));
        Player_close me=new Player_close(0,0,30,enemyb);
        System.out.println(enemyb.get(0).alive());
        me.update("2");
        System.out.println(enemyb.get(0).alive());
    }


}
