package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletEnnemi;
import com.mygdx.game.bullet.boss.BulletBoss1;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.powerUp.powerUp;

import java.util.Iterator;


public class Drawinggame {
    MyGdxGame gdx;

    //renderer des barres de vies etc
    public ShapeRenderer shapeLife;
    public ShapeRenderer shapeShield;
    public ShapeRenderer shapeNoLife;
    public ShapeRenderer shapeExp;
    public ShapeRenderer shapeNoExp;

    protected Texture background;
    public SpriteBatch batch;

    //pour dessiner
    public BitmapFont Lvl;
    public BitmapFont Lvl2;
    public BitmapFont score;
    public BitmapFont Vague;



    public Drawinggame(MyGdxGame gdx){

        //initialise les shaperenderer

        background = new Texture(Gdx.files.internal("starry-night-sky.jpg"));
        shapeNoLife = new ShapeRenderer();
        shapeLife = new ShapeRenderer();
        shapeNoExp = new ShapeRenderer();
        shapeExp = new ShapeRenderer();
        shapeShield = new ShapeRenderer();
        batch = new SpriteBatch();
        this.gdx = gdx;


        //et le texte

        Lvl = new BitmapFont();
        Lvl.getData().setScale(2.5f);
        Lvl2 = new BitmapFont();
        Lvl2.getData().setScale(2.5f);
        score = new BitmapFont();
        score.getData().setScale(2.5f);
        Vague = new BitmapFont();
        Vague.getData().setScale(4f);
        Lvl2.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
        score.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
        Vague.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
    }

    //dessine le jeu

    public void GameDraw() {
        batch.begin();
        batch.draw(background, 0, 0);


        gdx.hero.draw(batch);
        for (Iterator it = gdx.bullet.iterator(); it.hasNext();) {
            Bullet bullH = (Bullet) it.next();
            bullH.draw(batch);
        }
        for (Iterator it = gdx.bulletEN.iterator(); it.hasNext();) {
            Bullet bullM = (Bullet) it.next();
            bullM.draw(batch);
        }
        for (Iterator it = gdx.m.iterator(); it.hasNext();) {
            Monster mon  = (Monster) it.next();
            mon.draw(batch);
        }
        for (Iterator it = gdx.pU.iterator(); it.hasNext();) {

            powerUp up  = (powerUp) it.next();
            up.draw(batch);
        }
        int i = 1;
        for (Iterator it = gdx.pUInUse.iterator(); it.hasNext();) {
            powerUp up  = (powerUp) it.next();
            batch.draw(up.getTexture(),100*i,100);
            i++;
        }
        Lvl.draw(batch, "LVL : " + gdx.hero.getLevel(),
                (int)((Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3.2) -50)),
                140);
        batch.end();
    }

    //dessine la barre d'exp

    public void ExpBar(){
        shapeNoExp = new ShapeRenderer();
        shapeExp = new ShapeRenderer();
        shapeNoExp.begin(ShapeRenderer.ShapeType.Filled);
        shapeExp.begin(ShapeRenderer.ShapeType.Filled);
        shapeExp.setColor(61/255f, 197/255f, 242/255f,1);
        shapeNoExp.setColor(0/255f, 255/255f, 205/255f,1);

        shapeNoExp.rect((int)(
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/5) -50)), 70 +(int)(Gdx.graphics.getHeight()/20)
                , (float)(Gdx.graphics.getWidth()/5), (int)(Gdx.graphics.getHeight()/50)
        );



        shapeExp.rect((int) (
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 5) - 50))
                , 70 +(int)(Gdx.graphics.getHeight()/20)
                , (int) Math.round(((float) (Gdx.graphics.getWidth() / 5) * ((float) gdx.hero.getExp() / (float) gdx.hero.getMaxExp())))
                , (int) (Gdx.graphics.getHeight() / 50)
        );




        shapeNoExp.end();
        shapeExp.end();
    }

    //dessine la barre de vie et de shield
    public void HealthBar(){
        shapeNoLife = new ShapeRenderer();
        shapeLife = new ShapeRenderer();
        shapeShield = new ShapeRenderer();
        shapeNoLife.begin(ShapeRenderer.ShapeType.Filled);
        shapeLife.begin(ShapeRenderer.ShapeType.Filled);
        shapeShield.begin(ShapeRenderer.ShapeType.Filled);
        shapeLife.setColor(0, 255, 0,1);
        shapeNoLife.setColor(255, 0, 0,1);
        shapeShield.setColor(0,0,255,1);
        shapeNoLife.rect((int)(
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
                , (float)(Gdx.graphics.getWidth()/3), (int)(Gdx.graphics.getHeight()/20)
        );

        if(gdx.hero.getLife()<=0){
            shapeLife.rect((int)(
                            (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
                    , 0, (int)(Gdx.graphics.getHeight()/20)
            );
        }
        else {
            shapeLife.rect((int) (
                            (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
                    , 50
                    , (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) gdx.hero.getLife() / (float) gdx.hero.getMaxlife())))
                    , (int) (Gdx.graphics.getHeight() / 20)
            );
        }
        shapeShield.rect((int) (
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
                , 50
                , (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) gdx.hero.shield / (float) gdx.hero.getMaxlife())))
                , (int) (Gdx.graphics.getHeight() / 20)
        );

        shapeNoLife.end();
        shapeLife.end();
        shapeShield.end();
    }

    //dessine le menu de pause

    public void PausedMod() {


        ShapeRenderer shapeBack = new ShapeRenderer();
        shapeBack.begin(ShapeRenderer.ShapeType.Filled);
        shapeBack.setColor(52 / 255f, 67 / 255f, 77 / 255f, 1);

        shapeBack.rect(
                (Gdx.graphics.getWidth()/ 3), (int) (Gdx.graphics.getHeight() / 4)
                , (float) (Gdx.graphics.getWidth() / 3), (int) (Gdx.graphics.getHeight() / 1.5)
        );
        shapeBack.end();

        batch.begin();
        Vague.draw(batch, "Vague : " + gdx.nbvague,
                (int)(Gdx.graphics.getWidth() / 2.4),
                (int)(Gdx.graphics.getHeight() /1.18));
        score.draw(batch, "score : " + gdx.scorecalc,
                (int)(Gdx.graphics.getWidth() / 2.5),
                (int)(Gdx.graphics.getHeight() /1.45));
        Lvl2.draw(batch, "Level : " + gdx.hero.getLevel(),
                (int)(Gdx.graphics.getWidth() / 2.5),
                (int)(Gdx.graphics.getHeight() /1.35));

        batch.end();


    }

    //dessine le jeu , la barre d'exp et la barre de vie
    public void DrawALL(){
        GameDraw();
        HealthBar();
        ExpBar();
    }



}
