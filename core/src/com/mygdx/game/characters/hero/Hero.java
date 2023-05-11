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

    public void gauche(){
        if(this.x - this.speed < 0){
            this.x = 0;}
        else {
            this.x = this.x - this.speed;
        }
    }


    public void droite(){

        if(this.x + this.speed > Gdx.graphics.getWidth() - this.getTaillex()) {
            this.x = Gdx.graphics.getWidth() - this.getTaillex();
        }
        else {
            this.x = this.x + this.speed;
        }

    }



    public void haut(){
        if (this.y + this.speed > Gdx.graphics.getHeight() - this.getTailley()){
            this.y = Gdx.graphics.getHeight() - this.getTailley();
        }
        else{
            this.y = this.y + this.speed;
        }

    }


    public void bas(){
        if(this.y - this.speed < 0){
            this.y = 0;
        }
        else{
            this.y = this.y - this.speed;
        }

    }
}
