package com.mygdx.game.weapon;

import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.characters.hero.Hero;

public class WeaponLvL5 extends Weapon {
    public WeaponLvL5(Hero hero) {
        super(15,hero);
    }

    @Override
    public BulletHero[] tirer() {
        BulletHero[] b = new BulletHero[3];
        b[0] = new BulletHero(this.hero.getX(), this.hero.getY() + this.hero.getTailley(), this.hero.gdx);
        b[1] = new BulletHero(this.hero.getX() + this.hero.getTaillex() , this.hero.getY() + this.hero.getTailley(), this.hero.gdx);
        b[1] = new BulletHero(this.hero.getX() + this.hero.getTaillex() + (this.hero.getTailley()/2), this.hero.getY() + this.hero.getTailley(), this.hero.gdx);
        return b;
    }
}
