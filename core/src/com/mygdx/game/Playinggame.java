package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.*;
import com.mygdx.game.characters.monster.boss.Boss1;
import com.mygdx.game.characters.monster.boss.Boss2;
import com.mygdx.game.powerUp.PowerUp;


import java.util.LinkedHashSet;

import static com.badlogic.gdx.math.MathUtils.random;

public class Playinggame {


    MyGdxGame gdx;

    //liste des balles, ennemi, buffs etc

    public Hero hero;

    public LinkedHashSet<BulletHero> bullet = new LinkedHashSet<>();

    public LinkedHashSet<Bullet> bulletEN = new LinkedHashSet<>();
    public LinkedHashSet<Monster> m = new LinkedHashSet<>();

    public LinkedHashSet<PowerUp> pU = new LinkedHashSet<PowerUp>();

    public LinkedHashSet<PowerUp> pUInUse = new LinkedHashSet<PowerUp>();

    //Controle le nb de monstres

    public int nbmonsterlast;
    public int nbmonster;
    public int nbBoss;
    public int nbMC;
    public int nbBoss2;
    public Boss1 boss1;
    public Boss2 boss2;
    public MonstreChinois MC;

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

            } else if (bullH.getX() >= Gdx.graphics.getWidth()) {
                bullH.existe = false;
            }else if (bullH.getX() <= 0) {
                bullH.existe = false;
            } else if (bullH.getY() <= 0) {
                bullH.existe = false;
            }else {
                for (Monster mon : m) {
                    mon.collisionEnnemi(bullH);
                }
                if(nbBoss > 0){
                    boss1.collisionEnnemi(bullH);
                }
                if(nbBoss2 > 0){
                    boss2.collisionEnnemi(bullH);
                }
                if(nbMC > 0){
                    MC.collisionEnnemi(bullH);
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
         for(Monster mon : m) {
             if (mon.getcooldown() <= 0) {
                 Bullet[] BullHere = mon.tirer();
                 for (Bullet B : BullHere) {
                     if (B != null) {
                         bulletEN.add(B);
                     }
                     mon.setCooldownreset();
                 }
                 mon.cooldownDown();

             }
         }
        if(this.nbBoss >0) {
            if (boss1.getcooldown() <= 0) {
                Bullet[] bullHere = boss1.tirer();
                for (Bullet B : bullHere)
                    if (B != null) {
                        bulletEN.add(B);
                    }
                boss1.setCooldownreset();
            }
            boss1.cooldownDown();
        }
        if(this.nbBoss2 >0) {
            if (boss2.getcooldown() <= 0) {
                boss2.setXspeed(0);
                Bullet[] bullHere = boss2.tirer();
                for (Bullet B : bullHere)
                    if (B != null) {
                        bulletEN.add(B);
                    }
                boss2.dlaserdown();
                if(boss2.getDlaser() <= 0){
                    boss2.setCooldownreset();
                    boss2.setDlaser();
                    boss2.setXspeed(3);
                }
            }
            if(boss2.getcooldown() >0) {
                boss2.cooldownDown();
            }
        }
        if(this.nbMC > 0){
            if (MC.getcooldown() <= 0) {
                m.add( MC.creer());
                nbmonster++;
                MC.setCooldownreset();
            }
            MC.cooldownDown();
        }
    }


    //Fait réapparaitre les mobs quand ils sont tous morts

    public void Respawn(){
        if(nbmonster == 0 && nbBoss==0) {


            if(gdx.nbvague % 5 == 0){
                boss1 = new Boss1(0, 600, this.gdx);
                nbBoss++;
            }
            if (gdx.nbvague % 10 == 0) {
                boss2 = new Boss2(700, 700, this.gdx);
                nbBoss2++;

            }
            if (gdx.nbvague % 3 == 0) {
                MC = new MonstreChinois(0, 900, this.gdx);
                nbMC++;

            }
            else {
                nbmonster = nbmonsterlast + 2;
                int nbmonstertemp = nbmonsterlast + 2;
                nbmonsterlast = nbmonster;
                while (nbmonstertemp != 0) {
                    int rand = random.nextInt(0, 100);
                    int coordx = Gdx.graphics.getWidth() - ((nbmonster - nbmonstertemp + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1)));
                    int coordy = Gdx.graphics.getHeight() - 100;
                    if (rand <= 80) {
                        m.add(new SmallMonster(coordx,coordy,this.gdx));
                    } else if (rand <= 83) {
                        m.add(new MonstreSnipe(coordx,coordy,this.gdx));
                    } else if (rand <= 90) {
                        m.add(new MediumMonster(coordx,coordy,this.gdx));
                    } else {
                        m.add(new MonstreJaponais(coordx,coordy,this.gdx));

                        Music BANZAI = Gdx.audio.newMusic(Gdx.files.internal("BANZAI.mp3"));
                        BANZAI.play();
                    }


                    nbmonstertemp--;
                }


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
        PowerUp[] powUps = pU.toArray(new PowerUp[0]);
        for (PowerUp pu : powUps) {
            if (!pu.existe) {
                pUInUse.add(pu);
                pU.remove(pu);
            }
        }
        PowerUp[] PowerUpsInuse = pUInUse.toArray(new PowerUp[0]);
        for (PowerUp pu : PowerUpsInuse) {
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
        if(nbBoss > 0){
            if(!boss1.existe){
                if(boss1.drop()){
                    boss1.randomPowerUp();
                }
                this.nbBoss--;

            }
        }
        if(nbBoss2 > 0){
            if(!boss2.existe){
                if(boss2.drop()){
                    boss2.randomPowerUp();
                }
                this.nbBoss2--;
            }
        }

        if(nbMC > 0){
            if(!MC.existe){
                if(MC.drop()){
                    MC.randomPowerUp();
                }
                this.nbMC--;
            }
        }

    }

    // Utilise tout les powerUp dont le hero se tiens au dessus


    public void usePowerUp() {
        for (PowerUp p : pU) {
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
        if(nbBoss > 0){
            boss1.update();
        }
        if(nbBoss2 > 0){
            boss2.update();
        }
        if(nbMC > 0){
            MC.update();
        }

        usePowerUp();
        hero.update();

    }
}
