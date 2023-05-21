package com.mygdx.game.characters;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;


public abstract class Character {
    protected int xspeed;

    protected int yspeed;

    protected int x;

    protected int y;

    protected double life;

    protected double Maxlife;

    protected Texture texture;

    public boolean existe;



    public double degatCAC;

    public MyGdxGame gdx;

    public Character(int x, int y,int xspeed, int yspeed, int life,Texture texture,double degatCAC,MyGdxGame gdx){
        this.gdx=gdx;
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.life = life;
        this.texture = texture;

        this.Maxlife = life;
        this.degatCAC = degatCAC;
    }

    // Getter / Setter

    public double getDegatCAC(){return this.degatCAC;}


    public double getMaxlife(){
        return Maxlife;
    }

    public int getXspeed() {return xspeed;}

    public void setYspeed(int yspeed) {this.yspeed = yspeed;}

    public int getYspeed() {return yspeed;}

    public void setXspeed(int xspeed) {this.xspeed = xspeed;}

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public double getLife() {return life;}

    public void setLife(double life) {this.life = life;}

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }


    public void draw(SpriteBatch batch){
        batch.draw(getTexture(), getX(),getY());
    }


    //enleve de la vie les degats recu
    public void toucher(double degat){
        if(getLife() - degat < 0 ){
            setLife(0);
        }
        else {
            setLife(getLife() - degat);
        }
    }

    //check si le personnage est mort

    public void mort(){
        if(this.getLife() <= 0){
            this.existe = false;
        }
    }


}

