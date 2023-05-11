package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BlastNv2 extends BulletHero{
    private static int degat = 3 ;
    private static int xspeed = 20 ;
    private static int yspeed = 20 ;
    private static  int cooldownMax = 1000 ;

    public BlastNv2(int y, int x) {
        super(degat, xspeed, yspeed, y, x, new Texture("laserGreen.png"), cooldownMax);
    }
}
