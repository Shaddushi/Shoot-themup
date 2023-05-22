package com.mygdx.game.characters.monster.boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.boss.BulletBoss1;
import com.mygdx.game.characters.monster.Monster;

public class Boss1 extends Monster {


    public Boss1(int x, int y, MyGdxGame gdx){
        super(x,y,2,0 , 30, new Texture("boss1.png"), 2 , 30,10 ,gdx,20);
    }

    @Override
    public Bullet[] tirer() {
        Bullet[] BB = new Bullet[2];
        BB[0] = new BulletBoss1(this.x + 45 , this.y +(texture.getHeight()/3), 1, -5, 1,this.gdx );
        BB[1] = new BulletBoss1(this.x + (texture.getWidth() /2)  +130, this.y +(texture.getHeight()/3), -1, -5,2, this.gdx);
        return BB;
    }

    public void update(){
        this.x += this.xspeed;
        if(this.x >= Gdx.graphics.getWidth() - getTaillex() || this.x <= 0){
            this.xspeed = -this.xspeed;
        }
    }
}
