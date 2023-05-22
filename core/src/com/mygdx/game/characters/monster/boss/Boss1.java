package com.mygdx.game.characters.monster.boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.boss.BulletBoss1;
import com.mygdx.game.characters.monster.Monster;

public class Boss1 extends Monster {

    public Boss1(int x, int y, MyGdxGame gdx){
        super(x,y,2,0 , 30, new Texture("mediumMonster.png"), 2 , 30,10 ,gdx,20);
    }

    @Override
    public Bullet[] tirer() {
        Bullet[] BB = new Bullet[2];
        BB[0] = new BulletBoss1(this.x , this.y, 5, 8);
        BB[1] = new BulletBoss1(this.x + (texture.getWidth()/2), this.y, -5, 8);
        return BB;
    }

    public void update(){
        if(this.x <= Gdx.graphics.getWidth() || this.x >= Gdx.graphics.getWidth()){
            this.xspeed = -this.xspeed;
        }
    }
}
