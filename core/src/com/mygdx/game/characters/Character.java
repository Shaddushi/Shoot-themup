package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Character {
    private int speed;
    private int x;
    private int y;
    private int life;
    private int degat;
    private Texture texture;

    public Character(int x, int y, int speed, int life, int degat, Texture texture){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.life = life;
        this.degat = degat;
        this.texture = texture;
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

    public int getDegat() {return degat;}

    public void setDegat(int degat) {this.degat = degat;}

    abstract protected void deplacement(int newx, int newy);

    public void draw(SpriteBatch batch){
        batch.draw(getTexture(), getX(),getY());
    }

}
