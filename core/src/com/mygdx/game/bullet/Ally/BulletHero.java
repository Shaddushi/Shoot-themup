package com.mygdx.game.bullet.Ally;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;

public class BulletHero extends Bullet {

    public MyGdxGame gdx;
    public BulletHero(int x, int y, MyGdxGame gdx){
        super(Math.round(2 * gdx.pg.hero.bonus_damage),0,5,x,y,new Texture("laserGreen.png"), 70);
        this.gdx = gdx;
    }
}
