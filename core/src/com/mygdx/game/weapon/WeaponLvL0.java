package com.mygdx.game.weapon;

import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.characters.hero.Hero;

public class WeaponLvL0 extends Weapon {

    public WeaponLvL0(Hero hero) {
        super(25,hero);
    }

    @Override
    public BulletHero[] tirer() {
        BulletHero[] b = new BulletHero[1];
        b[0] = new BulletHero(this.hero.getX() + (this.hero.getTaillex() / 2), this.hero.getY() + this.hero.getTailley(), this.hero.gdx,2);
        return b;
    }
}
