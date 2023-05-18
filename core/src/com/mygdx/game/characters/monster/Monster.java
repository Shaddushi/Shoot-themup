package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Character;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.powerUp.HealthPack;
import com.mygdx.game.powerUp.powerUp;

import static com.badlogic.gdx.math.MathUtils.random;


public abstract class Monster extends Character {

    protected int taillex;
    protected int tailley;
    public int xp;

    public int dropChance;

    public Monster(int x, int y, int xspeed, int yspeed, int life, Texture texture, int xp, int cooldown, double DegatCAC, MyGdxGame gdx,int dc){
        super(x, y, xspeed, yspeed, life,texture,cooldown,DegatCAC,gdx);
        this.xp = xp;
        this.taillex = texture.getWidth();
        this.tailley = texture.getHeight();
        this.existe=true;
        this.dropChance = dc;

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
        updateM();
        update();
    }

    public abstract Bullet[] tirer();

    public boolean drop(){
        int Dc = random.nextInt(0,100);
        return Dc <= this.dropChance;
    }

    public void randomPowerUp(){
        HealthPack h = new HealthPack(this.x,this.y,this.gdx);
        this.gdx.pU.add(h);
        System.out.println(h.gdx.hero.getLevel());
    }


}







