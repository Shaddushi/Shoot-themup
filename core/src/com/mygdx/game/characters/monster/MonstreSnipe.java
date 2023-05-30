package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.Snipe;

public class MonstreSnipe extends Monster {
    public MonstreSnipe(int x, int y, MyGdxGame gdx){
        super(x,y,3,0 , 0.01, new Texture("sniper.png"), 2 , 100,0, gdx,13);

    }

    public Bullet[] tirer(){
        Bullet[] BE = new Bullet[1];
        BE[0] = new Snipe(this.x, this.y, this.gdx);
        return BE;
    }

    public void update(){
        x += xspeed;
        if (x < 0 || x > Gdx.graphics.getWidth() - this.getTaillex()) {
            xspeed = -xspeed;
        }
    }
}
