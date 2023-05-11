package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;

public class Monster extends Character {

    int taillex;
    int tailley;
    public int xp;
    public Monster(int x, int y, int speed, int life,Texture texture, int xp,int hauteur,int largeur){
        super(x, y, speed, life,texture,hauteur,largeur);
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
        Bullet bullet = new Bullet(5, 12, 12, this.getY() + this.getTailley(), this.getX() +(this.getTaillex() /2), bulletimg, 3);
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

    public void update(){
        if(this.getX() < 0){
            this.droite();
        }
        if(this.getX() > Gdx.graphics.getWidth()) {
            this.gauche();
        }
        if(this.getY() < (int)(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()*0.4)){
            this.haut();
        }
        if(this.getY() > Gdx.graphics.getHeight()){
            this.bas();
        }
    }
}


