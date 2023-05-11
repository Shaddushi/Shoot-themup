package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletHero extends Bullet{

    private final Texture bulletHeroimg = new Texture("laserGreen.png");
    public BulletHero(int x, int y){
        super(1,3,3,x,y);
        this.setTexture(this.bulletHeroimg);
    }
}
