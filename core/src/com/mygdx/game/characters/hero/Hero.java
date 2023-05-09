package com.mygdx.game.characters.hero;

import com.mygdx.game.characters.Character;

public class Hero extends Character {
    int speed;
    int x;
    int y;
    int life;
    int level;

    public Hero(int x, int y, int speed, int life, int degat){
       super(x,y,speed, life, degat);
        this.level = 0;
    }

    public void deplacement(){

    }

    public void draw(){

    }




}
