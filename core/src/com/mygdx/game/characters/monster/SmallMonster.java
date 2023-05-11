package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SmallMonster extends Monster{
    public SmallMonster(int x, int y){
        super(x,y,5, 5, 1, new Texture("dreadnaught.png"), 2 );

    }
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
