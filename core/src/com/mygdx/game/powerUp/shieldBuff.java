package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class shieldBuff extends powerUp{
    int bonus = 5;
    public shieldBuff(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("laserRedShot.png"), 0,gdx);
    }

    @Override
    public void use() {
        if(this.gdx.hero.shield + this.bonus <= this.gdx.hero.getMaxlife()){
            this.gdx.hero.setShield(this.gdx.hero.getLife() + this.bonus);
        }
        else{
            this.gdx.hero.setShield(this.gdx.hero.getMaxlife());
        }
        this.existe = false;
    }

    @Override
    public void undo() {}
}