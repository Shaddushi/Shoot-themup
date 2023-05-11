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

    private int cooldownMax ;
    private int cooldown;



    public Character(int x, int y,int xspeed, int yspeed, int life,Texture texture,int cooldownMax){
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.life = life;
        this.texture = texture;
        this.cooldownMax = cooldownMax;
        this.cooldown = cooldownMax;
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

    protected abstract Bullet shoot();
    public void draw(SpriteBatch batch){
        batch.draw(getTexture(), getX(),getY());
    }
    public void toucher(int degat){
        setLife(getLife() - degat);
    }

    public void cooldownDown() {
        this.cooldown--;
    }

    public void setCooldownreset() {
        if(this.cooldown <= 0 ) {
            this.cooldown = this.cooldownMax ;
        }
    }

    public int getcooldown() {return cooldown;}


}

