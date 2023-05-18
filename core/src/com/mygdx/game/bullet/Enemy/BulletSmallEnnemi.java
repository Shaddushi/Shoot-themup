package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;

public class BulletSmallEnnemi extends Bullet {

    public BulletSmallEnnemi(int x, int y){
        super(1,0,-3,x,y,new Texture("laserRed.png"), 70);


    }

}
