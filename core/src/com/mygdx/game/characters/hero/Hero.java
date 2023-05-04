package com.mygdx.game.characters.hero;

import com.mygdx.game.characters.Character;

public class Hero extends Character {
    int xspeed;
    int yspeed;
    int x;
    int y;
    int life;
    int level;

    public Hero(int x, int y, int xspeed, int yspeed, int life, int degat){
       super(x,y,xspeed,yspeed, life, degat);
        this.level = 0;
    }

    public void update(int newx, int newy){
        this.x = newx;
        this.y = newy;
    }

    public void draw(){

    }




}
