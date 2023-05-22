package com.mygdx.game.characters.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Character;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.powerUp.powerUp;
import com.mygdx.game.weapon.Weapon;
import com.mygdx.game.weapon.WeaponLvL0;
import com.mygdx.game.weapon.WeaponLvL3;
import com.mygdx.game.weapon.WeaponLvL5;

import java.util.Arrays;
import java.util.Iterator;

public class Hero extends Character {

    int taillex;
    int tailley;
    int level;

    double maxexp;
    double experience;

    public double bonus_damage;

    public int bonus_exp;

    public double shield;

    public double regen;

    public Weapon weapon;

    public Hero(int x,int y,MyGdxGame gdx) {
        super(x, y, 10, 10, 20, new Texture("player.png"),0.02,gdx);
        this.taillex = texture.getWidth();
        this.tailley = texture.getHeight();
        this.experience = 0;
        this.level = 1;
        this.bonus_damage = 1;
        this.shield = 0;
        this.maxexp = 20;
        this.regen = 0.01;
        this.degatCAC = 0.02;
        this.weapon = new WeaponLvL0(this);
    }


    public int getTaillex() {return taillex;}

    public void setBonus_damage(double x){this.bonus_damage = x;}

    public void SetMaxlife(double newlife){
        this.Maxlife = newlife;
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

    //Augmente certain parammetre du hero quand il lvlUp

    public void lvlUp(){
        SetMaxlife(Math.round(this.Maxlife * 1.1));
        this.setLife(Maxlife);
        this.bonus_damage = Math.round(this.bonus_damage*1.2);
        this.maxexp = Math.round(this.maxexp*1.5);
        }

    //ajoute a la barre d'exp du hero exp et le fait lvl up si l'experience depasse le plafond d'exp

    public void addExp(int exp) {
        while (this.experience + 1 <= maxexp && exp > 0) {
            this.experience++;
            exp--;
        }
        if (this.experience == maxexp) {
            this.level++;
            this.lvlUp();
            MAJWeapon();
            this.experience = exp;
            this.maxexp = (int) (this.maxexp * 1.2);
        }

    }

    //Regarde le niveau et change l'arme en fonction

    public void MAJWeapon(){
        if(getLevel()==3){
            this.weapon = new WeaponLvL3(this);
        }
        else if(getLevel()==5){
            this.weapon = new WeaponLvL5(this);
        }
    }



    //Reduit la vie ou le shield si il en a, du hero

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

    //Regenere le hero sur le temps

    public void regenOverTime() {
        if (getLife() + regen <= getMaxlife()){
            setLife(getLife() + regen);
        }
    }





    //Check les collisions du heros avec la balle bullM et  les monstres

    public void collisionAllie(Bullet bullM) {
        if ((bullM.getY() >= this.getY()) && (bullM.getY() - this.getTailley() <= this.getY())|| (this.getY() >= bullM.getY() && this.getY() <= (bullM.getY() + bullM.getTexture().getHeight()) )) {
            if (((bullM.getX() >= this.getX()) && (bullM.getX() - this.getTaillex() <= this.getX())) || (this.getX() >= bullM.getX() && this.getX() <= (bullM.getX() + bullM.getTexture().getWidth()) )) {
                bullM.existe = false;
                this.toucher(bullM.getDegat());
                this.mort();
                //Music a = Gdx.audio.newMusic(Gdx.files.internal("a.mp3"));
                //a.play();
            }
        }
        for (Iterator it = gdx.pg.m.iterator(); it.hasNext();) {
            Monster mon  = (Monster) it.next();
            if ((mon.getY() >= this.getY()) && (mon.getY() - this.getTailley() <= this.getY())|| ((this.getY() >= mon.getY()) && this.getY() <= (mon.getY() + mon.getTexture().getHeight()) )) {
                if ((mon.getX() >= this.getX()) && (mon.getX() - this.getTaillex() <= this.getX())|| ((this.getX() >= mon.getX()) && this.getX() <= (mon.getX() + mon.getTexture().getWidth()) )){
                    this.toucher(mon.getDegatCAC());
                    mon.toucher(this.getDegatCAC());
                    this.mort();
                    mon.mort();
                }
            }

        }
    }


    //mets a jour les mouvements du heros et check si il tire ou non

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
            if(this.weapon.getcooldown() <= 0) {
                BulletHero[] b = (BulletHero[]) this.weapon.tirer();
                this.gdx.pg.bullet.addAll(Arrays.asList(b));
                this.weapon.setCooldownreset();
                 Music pew = Gdx.audio.newMusic(Gdx.files.internal("pew.mp3"));
                 pew.play();
            }
            this.weapon.cooldownDown();

        }
        regenOverTime();
    }



}
