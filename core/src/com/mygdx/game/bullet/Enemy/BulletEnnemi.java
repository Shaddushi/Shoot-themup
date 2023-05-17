package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Bullet;

public class BulletEnnemi extends Bullet {

    public BulletEnnemi(int x, int y, int degat, int xspeed, int yspeed, Texture t, int cooldown) {
        super(degat, xspeed, yspeed, x, y, t, cooldown);
    }
}