package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class HealthPack extends PowerUp{

    int bonus = 20;
    public HealthPack(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("HealthPickup.png"), 0,gdx);
    }

    @Override
    public void use() {
        if(this.gdx.pg.hero.getLife() + this.bonus <= this.gdx.pg.hero.getMaxlife()){
            this.gdx.pg.hero.setLife(this.gdx.pg.hero.getLife() + this.bonus);
        }
        else{
            this.gdx.pg.hero.setLife(this.gdx.pg.hero.getMaxlife());
        }
        this.existe = false;
    }

    @Override
    public void undo() {}
}
