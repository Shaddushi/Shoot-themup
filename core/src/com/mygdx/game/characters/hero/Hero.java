package com.mygdx.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

    public Hero(int x, int y, int xspeed, int yspeed, int life, Texture texture) {
        super(x, y, xspeed, yspeed, life, texture,10);
        this.taillex = 99;
        this.tailley = 75;
    }


    public int getTaillex() {return taillex;}



    public void setTaillex(int taillex) {this.taillex = taillex;}

    public int getTailley() {return tailley;}

    public void setTailley(int tailley) {this.tailley = tailley;}

    public int getLevel() {return level;}

    public void setLevel(int level) {this.level = level;}


    public void gauche(){
        if(this.x - this.xspeed < -getTaillex() + 10){
            this.x = Gdx.graphics.getWidth() - this.getTaillex() + getTaillex() - 10;}
        else {
            this.x = this.x - this.xspeed;
        }
    }


    public void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.gauche();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.droite();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.haut();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.bas();
        }
    }


    public BulletHero tirer() {
        BulletHero bullet = new BulletHero(this.x, this.y);
        return bullet;
    }



        }
