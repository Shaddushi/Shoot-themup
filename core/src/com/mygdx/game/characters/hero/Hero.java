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



    public Hero(int x, int y, int speed, int life,Texture texture, Bullet bullet){
       super(x,y,speed, life, texture, bullet);
    }








}
