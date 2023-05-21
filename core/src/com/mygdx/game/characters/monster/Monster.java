package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.characters.Character;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.powerUp.*;

import java.util.Iterator;

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


    //Update le monstre sur ces mouvements , cooldown etc


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


    //fait tirer le monstre

    public abstract Bullet[] tirer();


    // *pourcentage* pour savoir si le monstre drop un power up ou non

    public boolean drop(){
        int Dc = random.nextInt(0,100);
        return Dc <= this.dropChance;
    }


    //randomize le power up que le monstre drop

    public void randomPowerUp() {
        int nb = random.nextInt(0, 5);
        if (nb == 0) {
            HealthPack h = new HealthPack(this.x, this.y, this.gdx);
            this.gdx.pg.pU.add(h);
        }
        else if(nb == 1){
            damagepack d = new damagepack(this.x,this.y,this.gdx);
            this.gdx.pg.pU.add(d);
        }
        else if(nb == 2){
            doubleexp e = new doubleexp(this.x,this.y,this.gdx);
            this.gdx.pg.pU.add(e);
        }
        else if(nb == 3){
            shieldBuff s = new shieldBuff(this.x,this.y,this.gdx);
            this.gdx.pg.pU.add(s);
        }
        else if(nb == 4){
            overload o = new overload(this.x,this.y,this.gdx);
            this.gdx.pg.pU.add(o);
        }
    }

    //Check la collision du monstre par rapport a bullH

    public void collisionEnnemi(Bullet bullH) {
        if ((bullH.getY() >= this.getY()) && (bullH.getY() - this.getTailley() <= this.getY())) {
            if ((bullH.getX() >= this.getX()) && (bullH.getX() - this.getTaillex() - 2 <= this.getX())) {
                bullH.existe = false;
                this.toucher(bullH.getDegat());
                gdx.pg.scorecalc += bullH.getDegat();
                this.mort();
            }
        }

}


}







