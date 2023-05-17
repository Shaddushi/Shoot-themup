package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.Character;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletEnnemi;
import com.mygdx.game.weapon.BulletHero;

public abstract class Monster extends Character {

    protected int taillex;
    protected int tailley;
    public int xp;


    public Monster(int x, int y, int xspeed, int yspeed, int life,Texture texture, int xp,int cooldown){
        super(x, y, xspeed, yspeed, life,texture,cooldown);
        this.xp = xp;
        this.taillex = 52;
        this.tailley = 42;
        this.existe=true;

    }

    public int getTaillex() {return taillex;}

    public void setTaillex(int taillex) {this.taillex = taillex;}

    public int getTailley() {return tailley;}

    public void setTailley(int tailley) {this.tailley = tailley;}

    public int getXp() {return xp;}

    public void setXp(int xp) {this.xp = xp;}


    public void updateM(){
        if(this.getcooldown()<=0){
            this.setCooldownreset();
        }
        this.cooldownDown();
    }

    public abstract void update();


    public void updateall(){
        //updateM();
        update();
    }

    public BulletEnnemi tirer() {
        return new BulletEnnemi(this.x,this.y);
    }
}







