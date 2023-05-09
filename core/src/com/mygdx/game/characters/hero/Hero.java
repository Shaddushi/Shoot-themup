package com.mygdx.game.characters.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;

public class Hero extends Character {

    int level;

    public Hero(int x, int y, int speed, int life, Texture texture) {
        super(x, y, speed, life, texture);
    }

    public void tirer(){
        Bullet bullet = new Bullet(5,12,12, this.getY()+ 75, this.getY() + 47);

    }


}




