package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;

public class BlastNv2 extends Bullet {
    private static int degat = 3 ;
    private static int xspeed = 20 ;
    private static int yspeed = 20 ;
    private static  int cooldownMax = 1000 ;

    public BlastNv2(int y, int x) {
        super(1, xspeed, yspeed, y, x, new Texture("laserGreen.png"), cooldownMax);
    }
}
