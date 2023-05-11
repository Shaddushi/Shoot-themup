package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class SmallMonster extends Monster{
    public int cpt;
    public SmallMonster(int x, int y){
        super(x,y,5, 5, 1, new Texture("dreadnaught.png"), 2 ,7);
        this.cpt = 100;
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
