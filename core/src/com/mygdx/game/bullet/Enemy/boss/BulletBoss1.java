package com.mygdx.game.bullet.Enemy.boss;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletEnnemi;

public class BulletBoss1  extends BulletEnnemi {
    private int xdep;

    public BulletBoss1(int x, int y, int xspeed, int yspeed){
        super(2,x,y,xspeed,yspeed,new Texture("laserRedShot.png"), 50);
        this.xdep = x;
    }

    public int getXdep() {
        return xdep;
    }
}
