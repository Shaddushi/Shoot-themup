package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class HealthPack extends powerUp{

    int bonus = 20;
    public HealthPack(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("HealthPickup.png"), 0,"instant",gdx);
    }

    @Override
    public void use() {
        if(this.gdx.hero.getLife() + this.bonus <= this.gdx.hero.getMaxlife()){
            this.gdx.hero.setLife(this.gdx.hero.getLife() + this.bonus);
        }
        else{
            this.gdx.hero.setLife(this.gdx.hero.getMaxlife());
        }
        this.existe = false;
    }
}
