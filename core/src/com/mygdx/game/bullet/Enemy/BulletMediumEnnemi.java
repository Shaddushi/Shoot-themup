package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class BulletMediumEnnemi extends BulletEnnemi {

    public BulletMediumEnnemi(int x, int y){
        super(x,y,0,-10,new Texture("laserRed.png"), 70);
        degat = 2;
    }
}
