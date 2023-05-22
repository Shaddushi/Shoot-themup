package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;

public class MonstreSnipe extends Monster {
    public MonstreSnipe(int x, int y, MyGdxGame gdx){
        super(x,y,5,-5 , 0.01, new Texture("kamikaze.png"), 2 , 0,0, gdx,13);

    }

    public Bullet[] tirer(){
        Bullet[] BE = new Bullet[0];
        return BE;
    }

    public void update(){
        if(gdx.pg.hero.getX() < this.x){
            this.x -= xspeed;
        }
        if(gdx.pg.hero.getX() > this.x){
            this.x += xspeed;
        }
        this.y += yspeed;
        if(this.getY() <= 0 ){
            this.xp = 0;
            this.dropChance = 0;
            this.existe = false;
        }
    }
}
