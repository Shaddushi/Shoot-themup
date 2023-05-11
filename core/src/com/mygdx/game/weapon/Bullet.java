package com.mygdx.game.weapon;

<<<<<<< HEAD
import java.util.LinkedHashSet;
=======
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
>>>>>>> origin/main

public class Bullet {
    LinkedHashSet<Bullet> bulletList = new LinkedHashSet<>() ;

    private int x;

    private int y;
    protected int degat;

<<<<<<< HEAD
    protected int yspeed;
    protected int xspeed;
=======
    int y;
    int degat;

    int yspeed;
    int xspeed;
    Texture texture;
>>>>>>> origin/main

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
<<<<<<< HEAD
        this.x = x ;
        this.y = y ;
=======
        this.texture = texture;
>>>>>>> origin/main
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
