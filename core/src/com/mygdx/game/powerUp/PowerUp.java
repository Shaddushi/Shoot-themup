package com.mygdx.game.powerUp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public abstract class PowerUp {
    private int x;
    private int y;

    public boolean existe;



    public int timer;

    protected Texture t;

    public MyGdxGame gdx;

    public PowerUp(int x, int y, Texture texture, int timer,MyGdxGame gdx) {
        this.x = x;
        this.y = y;
        this.t = texture;
        this.timer = timer;

        existe = true;
        this.gdx = gdx;

    }


    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    public Texture getTexture() {
        return t;
    }

    public void Move(){
        if(this.y >= Gdx.graphics.getHeight()/5){
            this.y -= 5;
        }
    }

    //active l'effet de l'item

    public abstract void use();

    //retire l'effet de l'item

    public abstract void undo();

    //draw
    public void draw(SpriteBatch batch){
        batch.draw(this.t, this.x,this.y);
    }


}
