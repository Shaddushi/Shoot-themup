package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;

public class Monster extends Character {

    public int xp;
    public Monster(int x, int y, int speed, int life,Texture texture, int xp){
        super(x, y, speed, life,texture);
        this.xp = xp;
    }

    public int getXp() {return xp;}

    public void setXp(int xp) {this.xp = xp;}
}


