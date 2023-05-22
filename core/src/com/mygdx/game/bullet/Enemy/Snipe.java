package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class Snipe extends BulletEnnemi {
    MyGdxGame gdx;
    public Snipe(int x, int y, MyGdxGame gdx){

        super(5,x,y,-((x-gdx.pg.hero.getX())/((y-gdx.pg.hero.getY())/50)),-50,new Texture("snipe.png"), 1000);
        this.gdx = gdx;
    }



}
