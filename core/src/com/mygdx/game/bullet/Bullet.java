package com.mygdx.game.bullet;

import java.util.LinkedHashSet;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Bullet {

    private int x;
    private int y;
    public double degat;
    protected int yspeed;
    protected int xspeed;
    private Texture texture;
     private int cooldown;


     public boolean existe;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet(double degat,int xspeed, int yspeed, int x, int y, Texture texture, int cooldown){
        this.degat = degat;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.x = x ;
        this.y = y ;
        this.texture = texture;
        this.existe = true;
        this.cooldown = cooldown;
    }

    public void draw(SpriteBatch batch){batch.draw(getTexture(), getX(),getY());}


    public double getDegat() {return degat;}

    public void setDegat(int degatplus) {degat = degatplus;}

    public void setXspeed(int xspeed) {
        this.xspeed = xspeed;
    }

    public int getXspeed() {
        return xspeed;
    }

    public void setTexture(Texture texture) {this.texture = texture;}

    public Texture getTexture(){return this.texture;}

    //mets a jour la position de la balle

    public void updateBullet() {
        if (this.xspeed > 0) this.x = this.x + this.xspeed ; // bullet va a droite
        if (this.xspeed < 0) this.x = this.x - -this.xspeed ; //bullet va a gauche
        if (this.yspeed > 0) this.y = this.y + this.yspeed ; //bullet va en haut
        if (this.yspeed < 0) this.y = this.y - -this.yspeed ; //bullet va en bas

    }
}
