package game_content.person;

import game_content.GameObject;

public class Enemy_Boss extends Enemy{
    @Override
    public void move() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void update() {

    }

//    @Override
//    public void update(int time) {
//
//    }

    @Override
    public boolean alive() {
        return false;
    }

    @Override
    public boolean hit(GameObject to) {
        return false;
    }

    @Override
    public int getdamage() {
        return 0;
    }
}
