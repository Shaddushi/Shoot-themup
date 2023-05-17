package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletMediumEnnemi extends BulletEnnemi{

    public BulletMediumEnnemi(int x, int y){
        super(x,y,5,0,-5,new Texture("laserRedShot.png"), 100);

    }
}
