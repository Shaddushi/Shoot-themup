package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletEnnemi extends Bullet {

    public BulletEnnemi(int x, int y, int degat, int xspeed, int yspeed, Texture t, int cooldown) {
        super(degat, xspeed, yspeed, x, y, t, cooldown);
    }
}
