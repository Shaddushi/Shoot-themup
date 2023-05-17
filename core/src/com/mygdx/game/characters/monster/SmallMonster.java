package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletSmallEnnemi;

import java.util.Random;

public class SmallMonster extends Monster{
    public SmallMonster(int x, int y, MyGdxGame gdx){
        super(x,y,5, 5, 1, new Texture("dreadnaught.png"), 2 , 70,0.01,gdx);

        direction();
    }

    public void direction(){
        Random ran = new Random();
        int nbr = ran.nextInt(4);
        if (nbr == 1) {
            xspeed  = -xspeed;
        }
        if (nbr == 2) {
            yspeed  = -yspeed;
        }
        if (nbr == 3) {
            xspeed  = -xspeed;
            yspeed = -yspeed;
        }
    }

    public Bullet[] tirer() {
        Bullet[] BE =new Bullet[1];
        BulletSmallEnnemi b = new BulletSmallEnnemi(this.x,this.y);

        BE[0] = b ;
        return BE;

    }

    @Override
    public void update(){

        x += xspeed;
        y += yspeed;

        if (x < 0 || x > Gdx.graphics.getWidth() - this.getTaillex()) {
            xspeed = -xspeed;
        }
        if (y < (int)(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()*0.4) || y > Gdx.graphics.getHeight() - this.getTailley()) {
            yspeed = -yspeed;
        }
    }



}
