package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletEnnemi;

public class Monster extends Character {

    int taillex;
    int tailley;
    public int xp;
    public Monster(int x, int y, int xspeed, int yspeed, int life,Texture texture, int xp,int cooldown){
        super(x, y, xspeed, yspeed, life,texture,cooldown);
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
        BulletEnnemi bullet = new BulletEnnemi(this.y, this.x);
        return bullet;
    }
    public void gauche(){
        if(this.x - this.xspeed < 0){
            this.x = 0;}
        else {
            this.x = this.x - this.xspeed;
        }
    }


    public void droite(){

        if(this.x + this.xspeed > Gdx.graphics.getWidth() - this.getTaillex()) {
            this.x = Gdx.graphics.getWidth() - this.getTaillex();
        }
        else {
            this.x = this.x + this.xspeed;
        }

    }



    public void haut(){
        if (this.y + this.yspeed > Gdx.graphics.getHeight() - this.getTailley()){
            this.y = Gdx.graphics.getHeight() - this.getTailley();
        }
        else{
            this.y = this.y + this.yspeed;
        }

    }


    public void bas(){
        if(this.y - this.yspeed < 0){
            this.y = 0;
        }
        else{
            this.y = this.y - this.yspeed;
        }


    }

    }







