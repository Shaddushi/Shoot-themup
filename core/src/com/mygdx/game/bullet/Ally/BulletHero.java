package com.mygdx.game.bullet.Ally;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;

public class BulletHero extends Bullet {


    public BulletHero(int x, int y){
        super(1,0,12,x,y,new Texture("laserGreen.png"), 10);
    }
}
