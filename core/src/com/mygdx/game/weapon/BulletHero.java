package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;

public class BulletHero extends Bullet{


    int x;
    int y;
    public BulletHero(int y, int x){
        super(1,12,12,x,y,new Texture("laserGreen.png"), 10);
    }

    public void updateBH(){
            this.x += xspeed;
            this.y = yspeed;
    }
}
