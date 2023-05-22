package com.mygdx.game.bullet.Enemy.boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletEnnemi;

public class BulletBoss1  extends BulletEnnemi {
    private int xdep;
    private int sens;
    public MyGdxGame gdx;

    public BulletBoss1(int x, int y, int xspeed, int yspeed, int sens, MyGdxGame gdx){
        super(2,x,y,xspeed,yspeed,new Texture("bulletBoss1.png"), 50);
        this.xdep = x;
        this.sens = sens;
        this.gdx = gdx;
    }

    public int getXdep() {
        return xdep;
    }

    @Override
    public void updateBullet() {
        this.x += this.xspeed;
        this.y += this.yspeed;
        if(gdx.pg.boss1.getY() <= this.y){
            this.xspeed = gdx.pg.boss1.getXspeed();
        }
        if(this.xspeed < 0 && this.xspeed >= -15 && this.y < gdx.pg.boss1.getY()){
            this.xspeed = this.xspeed - 1;
        }
        if(this.xspeed > 0 && this.xspeed <= 15 && this.y < gdx.pg.boss1.getY()){
            this.xspeed = this.xspeed + 1 ;
        }
        if(this.sens == 1) {

            if (this.x <= this.xdep || this.x >= this.xdep + this.gdx.pg.boss1.getTaillex() - 150) {
                this.xspeed = -this.xspeed;
            }
        }
        else{
            if (this.x >= this.xdep || this.x <= this.xdep - this.gdx.pg.boss1.getTaillex()  +150) {
                this.xspeed = -this.xspeed;
            }
        }






    }
}
