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

    double maxexp;
    double experience;

    public double bonus_damage;

    public int bonus_exp;

    public double shield;

    public Hero(int x, int y, int xspeed, int yspeed, int life, Texture texture, int cooldownMax,MyGdxGame gdx) {
        super(x, y, xspeed, yspeed, life, texture, cooldownMax,0.02,gdx);
        this.taillex = texture.getWidth();
        this.tailley = texture.getHeight();
        this.experience = 0;
        this.level = 1;
        this.bonus_damage = 1;
        this.shield = 0;
        this.maxexp = 20;
    }


    public int getTaillex() {return taillex;}

    public void lvlUp(){
        SetMaxlife(Math.round(this.Maxlife * 1.1));
        this.setLife(Maxlife);
        this.bonus_damage = Math.round(this.bonus_damage*1.2);
        this.maxexp = Math.round(this.maxexp*1.5);
    }

    public void setBonus_damage(double x){this.bonus_damage = x;}

    public void SetMaxlife(double newlife){
        this.Maxlife = newlife;
    }
    public void addExp(int exp){
        while (this.experience + 1 <= maxexp && exp > 0){
            this.experience ++;
            exp--;
        }
        if(this.experience == maxexp){
            this.level ++;
            this.lvlUp();
            this.experience = exp;
            this.maxexp = (int)(this.maxexp *1.2);
        }

        }

    public double getMaxExp() {
        return maxexp;
    }

    public void setTaillex(int taillex) {this.taillex = taillex;}

    public int getTailley() {return tailley;}

    public void setTailley(int tailley) {this.tailley = tailley;}

    public int getLevel() {return level;}

    public void setLevel(int level) {this.level = level;}

    public double getExp() {
        return this.experience;
    }
    public void setShield(double shield) {this.shield = shield;}

    public Bullet tirer() {
        return new BulletHero(this.getX() +(this.getTaillex() /2),this.getY() + this.getTailley(),this.gdx);}

    @Override
    public void toucher(double degat){
        double shieldminus = this.shield - degat;
        if(shieldminus < 0){
            this.setShield(0);
            this.setLife(this.getLife() + shieldminus);
        }
        else{
            this.shield = shieldminus;
        }

    }


    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if(this.x - this.xspeed < -getTaillex() + 10){
                this.x = Gdx.graphics.getWidth() - this.getTaillex() + getTaillex() - 10;}
            else {
                this.x = this.x - this.xspeed;
            }
            setTexture(new Texture("playerLeft.png"));
        }
        else{
            setTexture(new Texture("player.png"));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if(this.x + this.xspeed > Gdx.graphics.getWidth() - this.getTaillex() + getTaillex() - 10) {
                this.x = 0 - getTaillex() + 10;
            }
            else {
                this.x = this.x + this.xspeed;
            }
            setTexture(new Texture("playerRight.png"));
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
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if(this.getcooldown() <= 0) {
                this.gdx.bullet.add((BulletHero) this.tirer());
                this.setCooldownreset();
            }
            this.cooldownDown();

        }
    }



}
