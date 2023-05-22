package com.mygdx.game.bullet.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class Snipe extends BulletEnnemi {
    public snipe(int x, int y, int xspeed, int yspeed, int sens, MyGdxGame gdx){
        super(2,x,y,xspeed,yspeed,new Texture("bulletBoss1.png"), 50);
        this.xdep = x;
        this.sens = sens;
        this.gdx = gdx;
    }

}
