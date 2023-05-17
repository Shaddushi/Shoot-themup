package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletMediumEnnemi extends Bullet{

    public BulletMediumEnnemi(int x, int y){
        super(1,5,5,x,y,new Texture("laserRedShot.png"), 100);

    }
}
