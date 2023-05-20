package com.mygdx.game.bullet.boss;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;

public class Laser extends Bullet {
    public Laser(int x, int y, int xspeed, int yspeed){
        super(2,x,y,xspeed,yspeed,new Texture("laserRed.png"), 0);
    }

}
