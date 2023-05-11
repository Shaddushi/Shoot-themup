package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletHero extends Bullet{


    public BulletHero(int x, int y){
        super(1,3,3,x,y,new Texture("laserGreen.png"), 2);
    }
}
