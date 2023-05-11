package com.mygdx.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletHero;

public class Hero extends Character {

    int taillex;
    int tailley;
    int level;

    public Hero(int x, int y, int speed, int life, Texture texture) {
        super(x, y, speed, life, texture);
        this.taillex = 99;
        this.tailley = 75;
    }

    public int getTaillex() {return taillex;}

    public void setTaillex(int taillex) {this.taillex = taillex;}

    public int getTailley() {return tailley;}

    public void setTailley(int tailley) {this.tailley = tailley;}

    public int getLevel() {return level;}

    public void setLevel(int level) {this.level = level;}

    public Bullet tirer() {
        BulletHero bullet = new BulletHero(this.getX() +(this.getTaillex() /2),this.getY() + this.getTailley());
        return bullet;
    }
}
