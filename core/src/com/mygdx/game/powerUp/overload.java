package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class overload extends powerUp {
    public overload(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("kamikaze.png"), 1000,gdx);
    }

    @Override
    public void use() {
        this.gdx.pg.hero.cooldownmax = this.gdx.pg.hero.cooldownmax /2;
        this.existe = false;
    }

    @Override
    public void undo() {
        this.gdx.pg.hero.cooldownmax = this.gdx.pg.hero.cooldownmax * 2;
    }
}

