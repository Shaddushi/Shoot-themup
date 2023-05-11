package com.mygdx.game.weapon;

import java.util.LinkedHashSet;

public class Bullet {
    LinkedHashSet<Bullet> bulletList = new LinkedHashSet<>() ;

    private int x;

    private int y;
    protected int degat;

    protected int yspeed;
    protected int xspeed;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet(int degat, int xspeed, int yspeed, int y, int x){
        this.degat = degat;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.x = x ;
        this.y = y ;
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
