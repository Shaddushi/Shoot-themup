package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;

public class blastNv1 extends Bullet {
    private static int degat = 2 ;
    private static int xspeed = 15 ;
    private static int yspeed  = 15 ;
    private static  int cooldownMax = 500 ;

    public blastNv1(int y, int x) {
        super(1, xspeed, yspeed, y, x, new Texture("laserGreen.png"), cooldownMax);
    }
}
