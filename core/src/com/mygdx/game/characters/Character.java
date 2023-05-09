package com.mygdx.game.characters;

public abstract class Character {
    int speed;
    int x;
    int y;
    int life;
    int degat;

    public Character(int x, int y, int speed, int life, int degat){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.life = life;
        this.degat = degat;
    }

    abstract protected void deplacement();

}
