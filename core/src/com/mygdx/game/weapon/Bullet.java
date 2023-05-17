package com.mygdx.game.weapon;

import java.util.LinkedHashSet;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet {
    LinkedHashSet<Bullet> bulletList = new LinkedHashSet<>() ;


    private int x;
    private int y;
    protected int degat;
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

    public Bullet(int degat, int xspeed, int yspeed, int x, int y, Texture texture, int cooldown){
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

    private Texture getTexture() {return texture;}

    public int getDegat() {return degat;}

    public void setTexture(Texture texture) {this.texture = texture;}

    public void updateBullet() {
        if (this.xspeed > 0) this.x = this.x + this.xspeed ; // bullet va a droite
        if (this.xspeed < 0) this.x = this.x - -this.xspeed ; //bullet va a gauche
        if (this.yspeed > 0) this.y = this.y + this.yspeed ; //bullet va en hau
        if (this.yspeed < 0) this.y = this.y - -this.yspeed ; //bullet va en bas
    }
}
