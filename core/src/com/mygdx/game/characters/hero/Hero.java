package com.mygdx.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;

public class Hero extends Character {


    int level;

    public Hero(int x, int y, int speed, int life, Texture texture,int hauteur,int largeur) {
        super(x, y, speed, life, texture,hauteur,largeur);
    }


    public Bullet tirer(){
        Texture bulletimg = new Texture("laserGreen.png");
        Bullet bullet = new Bullet(5,12,3, this.getY() + 75, this.getX() + 44, bulletimg);
        return bullet;
        }




}
