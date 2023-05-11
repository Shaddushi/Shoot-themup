package com.mygdx.game.characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mygdx.game.weapon.Bullet;


public abstract class Character {
    protected int xspeed;
    protected int yspeed;
    protected int x;
    protected int y;
    protected int life;
    protected Texture texture;
    protected Bullet bullet;



    public Character(int x, int y,int xspeed, int yspeed, int life,Texture texture){
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.life = life;
        this.texture = texture;
    }

    public int getXspeed() {return xspeed;}

    public void setYspeed(int yspeed) {this.yspeed = yspeed;}

    public int getYspeed() {return yspeed;}

    public void setXspeed(int xspeed) {this.xspeed = xspeed;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public int getLife() {return life;}

    public void setLife(int life) {this.life = life;}

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Bullet getBullet() {return bullet;}

    public void setBullet(Bullet bullet) {this.bullet = bullet;}

    public void draw(SpriteBatch batch){
        batch.draw(getTexture(), getX(),getY());
    }




    public abstract void gauche();


    public abstract void droite();


    public abstract void haut();


    public abstract void bas();
    protected abstract Bullet tirer();

    public void toucher(int degat){
        setLife(getLife() - degat);
        if(getLife() <= 0){

        }
    }
    public void mort(){
        ;
    }



}

