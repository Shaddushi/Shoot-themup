package com.mygdx.game.powerUp;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.characters.monster.Monster;

public class damagepack extends powerUp {
    public damagepack(int x, int y, MyGdxGame gdx) {
        super(x,y, new Texture("kamikaze.png"), 1000,gdx);
    }

    @Override
    public void use() {

        this.gdx.hero.degatCAC = this.gdx.hero.degatCAC *2;
        this.gdx.hero.bonus_damage = this.gdx.hero.bonus_damage *2;
        this.existe = false;
    }

    @Override
    public void undo() {
        this.gdx.hero.bonus_damage = this.gdx.hero.bonus_damage /2;
    }
}
