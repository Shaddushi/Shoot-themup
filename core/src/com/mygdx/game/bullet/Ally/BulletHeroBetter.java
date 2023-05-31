package com.mygdx.game.bullet.Ally;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class BulletHeroBetter extends BulletHero{
    public BulletHeroBetter(int x, int y, MyGdxGame gdx, int xspeed, int yspeed){
        super(x,y, gdx,xspeed,yspeed);
        this.degat = Math.round(5 * gdx.pg.hero.bonus_damage);
        this.setTexture(new Texture("ballevert.png"));
    }
}
