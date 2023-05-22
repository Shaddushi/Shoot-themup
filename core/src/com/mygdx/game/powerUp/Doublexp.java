package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class Doublexp extends PowerUp {
    public Doublexp(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("x2.png"), 2000,gdx);
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

