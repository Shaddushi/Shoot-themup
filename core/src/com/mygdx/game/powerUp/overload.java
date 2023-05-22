package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.weapon.Weapon;

public class overload extends powerUp {

    String weapon;
    public overload(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("boss1.jpg"), 1000,gdx);
    }

    @Override
    public void use() {
        this.gdx.pg.hero.weapon.cooldownMax = this.gdx.pg.hero.weapon.cooldownMax /2;
        this.existe = false;
        this.weapon = gdx.pg.hero.weapon.name;
    }

    @Override
    public void undo() {
        if(this.weapon == gdx.pg.hero.weapon.name) {
            this.gdx.pg.hero.weapon.cooldownMax = this.gdx.pg.hero.weapon.cooldownMax * 2;
        }
    }
}

