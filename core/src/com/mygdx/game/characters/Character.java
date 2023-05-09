package com.mygdx.game.characters;

public class Character {
    int xspeed;
    int yspeed;
    int x;
    int y;
    int life;

    int level;

    public Character(int x, int y, int xspeed, int yspeed, int life) {
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.life = life;
    }

    public void gauche(){
        this.x = this.x - this.xspeed;
    }


    public void droite(){
        this.x = this.x + this.xspeed;
    }



    public void haut(){
        this.y = this.y + this.yspeed;
    }


    public void bas(){
        this.y = this.y - this.yspeed;
    }




}