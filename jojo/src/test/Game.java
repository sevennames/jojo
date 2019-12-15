package test;

import game_content.barrage.Bullet;
import game_content.person.Enemy;
import game_content.person.Enemy_mob;
import game_content.person.Player;
import game_content.person.Player_far;

import java.util.ArrayList;

public class Game {
    int world_width = 50;
    int world_height = 50;
    ArrayList<Player> players;
    ArrayList<Enemy> enemies;
    ArrayList<Bullet> myBullet;
    ArrayList<Bullet> enemyBullet;
    public void initialize(){
        Player player1;
        Enemy_mob enemy_mob1;
        player1 = new Player_far(0,0,2,myBullet,enemyBullet);
        enemy_mob1 = new Enemy_mob(25,25,90,50,player1);
        players = new ArrayList<Player>();
        enemies = new ArrayList<Enemy>();
        players.add(player1);
        enemies.add(enemy_mob1);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public int getWorld_width() {
        return world_width;
    }

    public int getWorld_height() {
        return world_height;
    }
}
