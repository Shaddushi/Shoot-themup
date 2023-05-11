package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletHero extends Bullet{


    public BulletHero(int y, int x){
        super(1,12,12,x,y,new Texture("laserGreen.png"), 10);
    }
}
