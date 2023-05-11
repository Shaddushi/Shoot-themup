package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;

public class Monster extends Character {

    int taillex;
    int tailley;
    public int xp;
    public Monster(int x, int y, int speed, int life,Texture texture, int xp){
        super(x, y, speed, life,texture);
        this.xp = xp;
        this.taillex = 52;
        this.tailley = 42;

    }

    public int getTaillex() {return taillex;}

    public void setTaillex(int taillex) {this.taillex = taillex;}

    public int getTailley() {return tailley;}

    public void setTailley(int tailley) {this.tailley = tailley;}

    public int getXp() {return xp;}

    public void setXp(int xp) {this.xp = xp;}

    public Bullet tirer() {
        Texture bulletimg = new Texture("laserRed.png");
        Bullet bullet = new Bullet(5, 12, 12, this.getY() + this.getTailley(), this.getX() +(this.getTaillex() /2), bulletimg);
        return bullet;
    }
}


