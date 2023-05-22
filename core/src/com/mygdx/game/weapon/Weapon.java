package com.mygdx.game.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.characters.hero.Hero;

public abstract class Weapon {
    public int cooldownMax;

    int cooldown;

    public String name;
    Hero hero;

    public Weapon(int cooldown, Hero hero,String Name) {
        this.cooldown =cooldown;
        this.cooldownMax = cooldown;
        this.hero = hero;
        this.name = name;
    }

    //fonction pour les cooldowns

    public double getcooldown() {return cooldown;}
    public void cooldownDown() {
        this.cooldown--;
    }

    //reset le cooldown quand il est a zero

    public void setCooldownreset() {
        if(this.cooldown <= 0 ) {
            this.cooldown = this.cooldownMax ;
        }
    }

    //Methode Abstracte pour tirer des balles avec l'arme
    public abstract Bullet[] tirer();

}
