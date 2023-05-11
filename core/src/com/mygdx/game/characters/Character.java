package com.mygdx.game.characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mygdx.game.weapon.Bullet;


public abstract class Character {
    protected int speed;
    protected int x;
    protected int y;
    protected int life;
    protected Texture texture;
    protected Bullet bullet;

    public int largeur;

    public int hauteur;

    public Character(int x, int y, int speed, int life,Texture texture,int hauteur,int largeur){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.life = life;
        this.texture = texture;
        this.largeur = largeur;
    }

    public int getSpeed() {return speed;}

    public void setSpeed(int speed) {this.speed = speed;}

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

