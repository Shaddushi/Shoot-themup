package com.mygdx.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Character;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Ally.BulletHero;

public class Hero extends Character {

    int taillex;
    int tailley;
    int level;




    public Hero(int x, int y, int xspeed, int yspeed, int life, Texture texture, int cooldownMax,MyGdxGame gdx) {
        super(x, y, xspeed, yspeed, life, texture, cooldownMax,0.02,gdx);
        this.taillex = texture.getWidth();
        this.tailley = texture.getHeight();
    }


    public int getTaillex() {return taillex;}



    public void setTaillex(int taillex) {this.taillex = taillex;}

    public int getTailley() {return tailley;}

    public void setTailley(int tailley) {this.tailley = tailley;}

    public int getLevel() {return level;}

    public void setLevel(int level) {this.level = level;}



    public Bullet tirer() {
        return new BulletHero(this.getX() +(this.getTaillex() /2),this.getY() + this.getTailley());}





    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if(this.x - this.xspeed < -getTaillex() + 10){
                this.x = Gdx.graphics.getWidth() - this.getTaillex() + getTaillex() - 10;}
            else {
                this.x = this.x - this.xspeed;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if(this.x + this.xspeed > Gdx.graphics.getWidth() - this.getTaillex() + getTaillex() - 10) {
                this.x = 0 - getTaillex() + 10;
            }
            else {
                this.x = this.x + this.xspeed;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (this.y + this.yspeed > Gdx.graphics.getHeight() - this.getTailley()) {
                this.y = Gdx.graphics.getHeight() - this.getTailley();
            } else {
                this.y = this.y + this.yspeed;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (this.y - this.yspeed < 0 ) {
                this.y = 0;
            } else {
                this.y = this.y - this.yspeed;
            }
        }
    }












        }
