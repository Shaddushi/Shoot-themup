package com.mygdx.game.characters;

public class Character {
    int xspeed;
    int yspeed;
    int x;
    int y;
    int life;
    int degat;

    public Character(int x, int y, int xspeed, int yspeed, int life, int degat){
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.life = life;
        this.degat = degat;
    }
}
