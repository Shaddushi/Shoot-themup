package com.mygdx.game.bullet.Enemy.boss;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletEnnemi;

public class Laser extends BulletEnnemi {
    public Laser(int x, int y, int xspeed, int yspeed){
        super(2,x,y,xspeed,yspeed,new Texture("laser.png"), 5);
    }

}
