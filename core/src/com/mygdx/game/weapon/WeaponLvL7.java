package com.mygdx.game.weapon;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.Ally.BulletHeroBetter;
import com.mygdx.game.characters.hero.Hero;

public class WeaponLvL7 extends Weapon{
    public WeaponLvL7(Hero hero) {
        super(10,hero,"7");
    }

    @Override
    public BulletHero[] tirer() {
        BulletHero[] b = new BulletHero[8];
        int x = this.hero.getX()+(this.hero.getTaillex() / 2);
        int y = this.hero.getY()+this.hero.getTailley() / 2;
        MyGdxGame gdx1 = this.hero.gdx;
        b[0] = new BulletHeroBetter(x,y ,gdx1 , 20, 0);
        b[1] = new BulletHeroBetter(x, y,gdx1, 0, 20);
        b[2] = new BulletHeroBetter(x, y,gdx1, -20, 0);
        b[3] = new BulletHeroBetter(x, y,gdx1, 0, -20);
        b[4] = new BulletHeroBetter(x, y,gdx1, -10, -10);
        b[5] = new BulletHeroBetter(x, y,gdx1, 10, 10);
        b[6] = new BulletHeroBetter(x, y,gdx1, -10, 10);
        b[7] = new BulletHeroBetter(x, y,gdx1, 10, -10);

        return b;
    }
}
