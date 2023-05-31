package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.characters.monster.Monster;

public class Damagepack extends PowerUp {
    public Damagepack(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("x2.png"), 1000,gdx);
    }

    @Override
    public void use() {
        this.gdx.pg.hero.degatCAC = this.gdx.pg.hero.degatCAC *2;
        this.gdx.pg.hero.bonus_damage = this.gdx.pg.hero.bonus_damage + this.gdx.pg.hero.bonus_damage;
        this.existe = false;
    }

    @Override
    public void undo() {
        this.gdx.pg.hero.setBonus_damage(this.gdx.pg.hero.bonus_damage / 2) ;
        this.gdx.pg.hero.degatCAC = this.gdx.pg.hero.degatCAC /2;
    }
}

