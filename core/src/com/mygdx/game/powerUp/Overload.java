package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.weapon.Weapon;

import java.util.Objects;

public class Overload extends PowerUp {
    String weapon;
    public Overload(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("faster.jpg"), 1000,gdx);
    }

    @Override
    public void use() {
        this.gdx.pg.hero.weapon.cooldownMax = this.gdx.pg.hero.weapon.cooldownMax /2;
        this.existe = false;
        this.weapon = gdx.pg.hero.weapon.name;
    }

    @Override
    public void undo() {
        if(Objects.equals(this.weapon, gdx.pg.hero.weapon.name)) {
            System.out.println(this.weapon +"    " + gdx.pg.hero.weapon.name);
            this.gdx.pg.hero.weapon.cooldownMax = this.gdx.pg.hero.weapon.cooldownMax * 2;
        }
    }
}

