package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletHero extends Bullet{


    public BulletHero(int x, int y){
        super(1,0,12,x,y,new Texture("laserGreen.png"), 10);
    }
}
