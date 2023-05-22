package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.MediumMonster;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.characters.monster.MonstreJaponais;
import com.mygdx.game.characters.monster.SmallMonster;
import com.mygdx.game.characters.monster.boss.Boss1;
import com.mygdx.game.powerUp.powerUp;

import java.util.LinkedHashSet;

import static com.badlogic.gdx.math.MathUtils.random;

public class Playinggame {


    MyGdxGame gdx;

    //liste des balles, ennemi, buffs etc

    public Hero hero;

    public LinkedHashSet<BulletHero> bullet = new LinkedHashSet<>();

    public LinkedHashSet<Bullet> bulletEN = new LinkedHashSet<>();
    public LinkedHashSet<Monster> m = new LinkedHashSet<>();

    public LinkedHashSet<powerUp> pU = new LinkedHashSet<powerUp>();

    public LinkedHashSet<powerUp> pUInUse = new LinkedHashSet<powerUp>();

    //Controle le nb de monstres

    public int nbmonsterlast;
    public int nbmonster;

    //score

    public int scorecalc;


    public Playinggame(MyGdxGame gdx){
        nbmonster = 0;
        nbmonsterlast = 5;
        this.gdx = gdx;
        hero = new Hero(250, 250, gdx);
        scorecalc = 0;
    }

    //S'occupe de verifier les collisions balles/ennemis , balles/hero , hero/ennemis

    public void CollisionAll() {
        for (Bullet bullH : bullet) {
            if (bullH.getY() >= Gdx.graphics.getHeight()) {
                bullH.existe = false;
            } else {
                for (Monster mon : m) {
                    mon.collisionEnnemi(bullH);
                }
            }
        }

            for (Bullet me : bulletEN) {
                if (me.getY() <= -40) {
                    me.existe = false;
                }
                else {
                    hero.collisionAllie(me);
                }

            }

    }

    //fait tirer tous les monstres de la map

    public void shoot(){
        for(Monster mon : m){
            if(mon.getcooldown()<=0){
                Bullet[] BullHere = mon.tirer();
                for(Bullet B : BullHere)
                    if(B != null){
                        bulletEN.add(B);
                    }

                mon.setCooldownreset();
            }
            mon.cooldownDown();

        }

    }


    //Fait réapparaitre les mobs quand ils sont tous morts

    public void Respawn(){
        if(nbmonster == 0) {
            nbmonster = nbmonsterlast +2;
            int nbmonstertemp = nbmonsterlast + 2;
            nbmonsterlast = nbmonster;


            while(nbmonstertemp!=0){
                int rand = random.nextInt(0,100);
                if(rand <=85){
                    m.add(new SmallMonster(Gdx.graphics.getWidth() - ((nbmonster-nbmonstertemp + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), Gdx.graphics.getHeight()-100, this.gdx));
                }
                else if (rand <=90) {
                    m.add(new MediumMonster(Gdx.graphics.getWidth() - ((nbmonster-nbmonstertemp + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), Gdx.graphics.getHeight()-100, this.gdx));
                }
                else if (rand <= 100) {
                    m.add(new MonstreJaponais((Gdx.graphics.getWidth() - ((nbmonster-nbmonstertemp + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1)))), Gdx.graphics.getHeight()-100, this.gdx));
                }
                //m.add(new Boss1(700, 800, this.gdx));
                nbmonstertemp--;
            }


            gdx.nbvague++;
        }
    }


    //Delete tout les elements qui n'existe plus


    public void delete() {
        Bullet[] bullHero = bullet.toArray(new Bullet[0]);
        for (Bullet ma : bullHero) {
            if (!ma.existe) {
                bullet.remove(ma);
            }
        }
        Bullet[] bullEN = bulletEN.toArray(new Bullet[0]);
        for (Bullet me : bullEN) {
            if (!me.existe) {
                bulletEN.remove(me);
            }
        }
        powerUp[] powUps = pU.toArray(new powerUp[0]);
        for (powerUp pu : powUps) {
            if (!pu.existe) {
                pUInUse.add(pu);
                pU.remove(pu);
            }
        }
        powerUp[] powerUpsInuse = pUInUse.toArray(new powerUp[0]);
        for (powerUp pu : powerUpsInuse) {
            if(pu.timer <= 0){

                pu.undo();
                pUInUse.remove(pu);
            }
            else{
                pu.timer--;
            }
        }
        Monster[] monstre = m.toArray(new Monster[0]);
        for(Monster mon : monstre) {
            if (!mon.existe) {

                if(mon.drop()){
                    mon.randomPowerUp();
                }
                hero.addExp(mon.xp);
                m.remove(mon);

                this.nbmonster = this.nbmonster - 1;

            }
        }

    }

    // Utilise tout les powerUp dont le hero se tiens au dessus


    public void usePowerUp() {
        for (powerUp p : pU) {
            p.Move();
            if ((p.getY() >= hero.getY()) && (p.getY() - hero.getTailley() <= hero.getY()) || (hero.getY() >= p.getY() && hero.getY() <= (p.getY() + p.getTexture().getHeight()))) {
                if ((p.getX() >= hero.getX()) && (p.getX() - hero.getTaillex() <= hero.getX()) || (hero.getX() >= p.getX() && hero.getX() <= (p.getX() + p.getTexture().getWidth()))) {

                    p.use();
                }
            }

        }
    }

    //mets à jour tout les elements

    public void GameUpdate(){
        shoot();

        for (Bullet bullH : bullet) {
            bullH.updateBullet();
        }
        for (Bullet bullM : bulletEN) {
            bullM.updateBullet();
        }
        for (Monster mon : m) {
            mon.updateall();
        }

        usePowerUp();
        hero.update();

    }
}
