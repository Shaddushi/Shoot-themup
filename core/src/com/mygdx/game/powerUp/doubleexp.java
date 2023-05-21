package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class doubleexp extends powerUp {
    public doubleexp(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("dreadnaught.png"), 2000,gdx);
    }

    @Override
    public void use() {
        this.gdx.pg.hero.bonus_exp = this.gdx.pg.hero.bonus_exp *2;
        this.existe = false;
    }

    @Override
    public void undo() {
        this.gdx.pg.hero.bonus_exp = this.gdx.pg.hero.bonus_exp /2;
    }
}

