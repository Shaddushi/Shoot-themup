package com.mygdx.game.weapon;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.Ally.BulletHeroBetter;
import com.mygdx.game.characters.hero.Hero;

public class WeaponLvL10 extends Weapon {

    public WeaponLvL10(Hero hero) {
        super(10, hero,"10");
    }

    @Override
    public BulletHero[] tirer() {
        BulletHero[] b = new BulletHero[24];
        int x = this.hero.getX() + (this.hero.getTaillex() / 2);
        int y = this.hero.getY() + this.hero.getTailley() / 2;
        MyGdxGame gdx1 = this.hero.gdx;
        int ok = 0;
        for (int i = -20; i <= 20; i = i + 10) {
            for (int j = 20; j >= -20; j = j - 10) {
                if (!((j == i) && i == 0)) {
                    b[ok] = new BulletHeroBetter(x, y, gdx1, i, j);
                    ok++;
                }
            }
        }
        return b;
    }
}
