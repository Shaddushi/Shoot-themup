package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.weapon.Weapon;

public class Overload extends PowerUp {

    Weapon weapon;
    public Overload(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("boss1.jpg"), 1000,gdx);
    }

    @Override
    public void use() {
        this.gdx.pg.hero.weapon.cooldownMax = this.gdx.pg.hero.weapon.cooldownMax /2;
        this.existe = false;
    }

    @Override
    public void undo() {
        this.gdx.pg.hero.weapon.cooldownMax = this.gdx.pg.hero.weapon.cooldownMax  * 2;
    }
}

