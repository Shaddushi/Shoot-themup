package com.mygdx.game.characters.hero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;

public class Hero extends Character {

    public int speed;
    public int x;
    public int y;
    public int life;
    int level;
<<<<<<< HEAD



    public Hero(int x, int y, int speed, int life,Texture texture, Bullet bullet){
       super(x,y,speed, life, texture, bullet);
    }








}
=======



    public Hero(int x, int y, int speed, int life, int degat, Texture texture){
        super(x,y,speed, life, degat, texture);
    }
}
>>>>>>> e61774f1be7b6acbda42a181bcdbd0eb330e13db
