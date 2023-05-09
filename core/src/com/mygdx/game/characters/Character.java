package com.mygdx.game.characters;

public abstract class Character {
    int speed;
    int x;
    int y;
    int life;

    int level;

    public Character(int x, int y, int speed, int life, int degat){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.life = life;

    }

    public void gauche(){
        this.x = this.x - this.speed;
    }


    public void droite(){
        this.x = this.x + this.speed;
    }



    public void haut(){
        this.y = this.y + this.speed;
    }


    public void bas(){
        this.y = this.y - this.speed;
    }


}


