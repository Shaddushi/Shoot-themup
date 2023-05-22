package com.mygdx.game.bullet.Enemy.boss;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletEnnemi;

public class BulletBoss1  extends BulletEnnemi {
    private int xdep;

    public BulletBoss1(int x, int y, int xspeed, int yspeed){
        super(2,x,y,xspeed,yspeed,new Texture("bulletBoss1.png"), 50);
        this.xdep = x;
    }

    public int getXdep() {
        return xdep;
    }

    @Override
    public void updateBullet() {
        if(this.x + (getTexture().getWidth() /2)<= this.getXdep() + 150|| this.x + (getTexture().getWidth() /2) >=this.getXdep() -150 ){
            this.xspeed = -this.xspeed;
        }

        this.x += this.xspeed;
        this.y += this.yspeed;



    }
}
