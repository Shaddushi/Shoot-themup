package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BlastNv0 extends Bullet{
    private static int degat = 1 ;
    private static int xspeed = 0 ;
    private static int yspeed = 10 ;
    private static  int cooldownMax = 500 ;

    public BlastNv0(int y, int x) {

        super(degat, xspeed, yspeed, y, x, new Texture("laserGreen.png"), cooldownMax);
    }
}