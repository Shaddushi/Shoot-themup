package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;

public class Monster extends Character {

    public Monster(int x, int y, int speed, int life, Texture texture, Bullet bullet){
        super(x, y, speed, life,texture, bullet);
    }


}


