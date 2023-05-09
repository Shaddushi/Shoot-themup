package com.mygdx.game.characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mygdx.game.weapon.Bullet;


public abstract class Character {
    private int speed;
    private int x;
    private int y;
    private int life;
    private Texture texture;
    private Bullet bullet;

    public Character(int x, int y, int speed, int life,Texture texture, Bullet bullet){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.life = life;
        this.texture = texture;
        this.bullet = bullet;
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



    public void draw(SpriteBatch batch){
        batch.draw(getTexture(), getX(),getY());
    }




    public void gauche(){
        if(this.x - this.speed < 0){
            this.x = 0;}
        else {
            this.x = this.x - this.speed;
        }
    }


    public void droite(){

        if(this.x + this.speed > Gdx.graphics.getWidth() - 99) {
            this.x = Gdx.graphics.getWidth() - 99;
        }
        else {
            this.x = this.x + this.speed;
        }

    }



    public void haut(){
        if (this.y + this.speed > Gdx.graphics.getHeight() - 75){
            this.y = Gdx.graphics.getHeight() - 75;
        }
        else{
            this.y = this.y + this.speed;
        }

    }


    public void bas(){
        if(this.y - this.speed < 0){
            this.y = 0;
        }
        else{
            this.y = this.y - this.speed;
        }

    }



}

