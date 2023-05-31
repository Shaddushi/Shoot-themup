package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.Snipe;

public class MonstreChinois extends Monster{

    public MonstreChinois(int x, int y, MyGdxGame gdx){
        super(x,y,8,8 , 10, new Texture("monstrechinois.png"), 2 , 30,0, gdx,13);
    }
    public Bullet[] tirer(){
        Bullet[] BE = new Bullet[0];
        return BE;
    }

    public MonstreJaponais creer(){
        MonstreJaponais MJ = new MonstreJaponais(x,y, gdx);
        return MJ;
    }

    public void update(){
        x += xspeed;
        y += yspeed;

        if (x < 0 || x > Gdx.graphics.getWidth() - this.getTaillex()) {
            xspeed = -xspeed;
        }
        if (y < (int)(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()*0.2) || y > Gdx.graphics.getHeight() - this.getTailley()) {
            yspeed = -yspeed;
        }
    }
}
