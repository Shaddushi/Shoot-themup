package com.mygdx.game.weapon;

public class Bullet {


    int x;

    int y;
    int degat;

    int yspeed;
    int xspeed;

    public Bullet(int degat,int xspeed,int yspeed,int y,int x){
        this.degat = degat;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }


    public void gauche(){
        this.x = this.x - this.xspeed;
    }


    public void droite(){
        this.x = this.x + this.xspeed;
    }

    public void bas(){
        this.y = this.y - this.yspeed;
    }





}
