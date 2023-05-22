package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class ShieldBuff extends PowerUp{
    int bonus = 5;
    public ShieldBuff(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("laserRedShot.png"), 0,gdx);
    }

    @Override
    public void use() {
        if(this.gdx.pg.hero.shield + this.bonus <= this.gdx.pg.hero.getMaxlife()){
            this.gdx.pg.hero.setShield(this.gdx.pg.hero.shield + this.bonus);
        }
        else{
            this.gdx.pg.hero.setShield(this.gdx.pg.hero.getMaxlife());
        }
        this.existe = false;
    }

    @Override
    public void undo() {}
}