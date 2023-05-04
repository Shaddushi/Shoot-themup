package com.mygdx.game.characters.monster;

public class Monster {
    int xspeed;
    int yspeed;
    int x;
    int y;
    int life;

    public Monster(int x, int y, int xspeed, int yspeed, int life){
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.life = life;
    }
}
