package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class BulletMediumEnnemi extends BulletEnnemi {

    public BulletMediumEnnemi(int x, int y, int xspeed, int yspeed){
        super(2,x,y,xspeed,yspeed,new Texture("laserRedShot.png"), 70);
    }
}
