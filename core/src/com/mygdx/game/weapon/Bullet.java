package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {


    int x;

    int y;
    int degat;

    int yspeed;
    int xspeed;
    Texture texture;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet(int degat, int xspeed, int yspeed, int y, int x, Texture texture){
        this.degat = degat;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.texture = texture;
    }

    public void draw(SpriteBatch batch){
        batch.draw(getTexture(), getX(),getY());
    }

    private Texture getTexture() {return texture;}


    public void gauche(){
        this.x = this.x - this.xspeed;
    }


    public void droite(){
        this.x = this.x + this.xspeed;
    }

    public void bas(){
        this.y = this.y - this.yspeed;
    }

    public void haut(){this.y = this.y + this.yspeed;}

}
