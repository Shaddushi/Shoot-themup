package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;

public class BulletSmallEnnemi extends BulletEnnemi {

    public BulletSmallEnnemi(int x, int y){
        super(1,x,y,0,-5,new Texture("laserRed.png"), 70);


    }

}
