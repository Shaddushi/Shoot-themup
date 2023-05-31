package com.mygdx.game.characters.monster.boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.boss.BulletBoss1;
import com.mygdx.game.bullet.Enemy.boss.Laser;

public class Boss2 extends Boss{
    public int dlaser;
    public Boss2(int x, int y, MyGdxGame gdx){
        super(x,y,3,0 , 40, new Texture("boss2.png"), 2 , 100,10 ,gdx);
        dlaser = 100;
    }

    public int getDlaser() {
        return dlaser;
    }

    public void setDlaser(){
        dlaser = 100;
    }

    public void dlaserdown(){
        dlaser--;
    }

    @Override
    public Bullet[] tirer() {
        Bullet[] BB = new Bullet[1];
        BB[0] = new Laser(this.x + (texture.getWidth()/2) -13 , this.y +(texture.getHeight()/3) -10 , 0, -10);
        return BB;
    }

    public void update(){
        this.x += this.xspeed;
        if(this.x >= Gdx.graphics.getWidth() - getTaillex() || this.x <= 0){
            this.xspeed = -this.xspeed;
        }
    }
}
