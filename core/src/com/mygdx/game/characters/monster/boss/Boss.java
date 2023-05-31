package com.mygdx.game.characters.monster.boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.boss.BulletBoss1;
import com.mygdx.game.characters.monster.Monster;

public abstract class Boss extends Monster {

    public Boss(int x, int y, int xspeed, int yspeed, int life, Texture texture, int xp, int cooldown, int cac, MyGdxGame gdx){
        super(x,y,xspeed,yspeed , life* (gdx.nbvague/5), texture, xp,cooldown / (gdx.nbvague/5 +1), cac,gdx, 100);
    }

    @Override
    public abstract Bullet[] tirer();

    public abstract void update();
}
