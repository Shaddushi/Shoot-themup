package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class BulletMediumEnnemi extends BulletEnnemi {

    public BulletMediumEnnemi(int x, int y){
        super(2,x,y,0,-10,new Texture("laserRedShot.png"), 70);
    }
}
