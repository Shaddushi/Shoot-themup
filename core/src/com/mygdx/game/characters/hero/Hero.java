package com.mygdx.game.characters.hero;

public class Hero {
    int xspeed;
    int yspeed;
    int x;
    int y;
    int life;
    int level;

    public Hero(int x, int y, int xspeed, int yspeed, int life){
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.life = life;
        this.level = 0;
    }

    public void update(int newx, int newy){
        this.x = newx;
        this.y = newy;
    }

    public void draw(){

    }




}
