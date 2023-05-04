package com.mygdx.game.characters.monster;

import com.mygdx.game.characters.Character;

public class Monster extends Character {
    int xspeed;
    int yspeed;
    int x;
    int y;
    int life;

    public Monster(int x, int y, int xspeed, int yspeed, int life, int degat){
        super(x, y, xspeed, yspeed, life, degat);
    }

}
