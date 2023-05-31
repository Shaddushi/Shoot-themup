package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.powerUp.PowerUp;

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
    protected Texture background2 ;
    float yMax, yCoordBg1, yCoordBg2;
    final int BACKGROUND_MOVE_SPEED = 100;
    public SpriteBatch batch;

    //pour dessiner
    public BitmapFont Lvl;
    public BitmapFont Lvl2;
    public BitmapFont score;
    public BitmapFont Vague;

    public BitmapFont DamageBoost;

    public BitmapFont Stat;
    
    public Drawinggame(MyGdxGame gdx){

        //initialise les shaperenderer

        background = new Texture(Gdx.files.internal("starry-night-sky.jpg"));
        background2 = new Texture(Gdx.files.internal("starry-night-sky.jpg")); // identical
        yMax = 1280;
        yCoordBg1 = yMax*(-1); yCoordBg2 = 0;
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
        DamageBoost = new BitmapFont();
        DamageBoost.getData().setScale(2f);
        DamageBoost.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
        Stat = new BitmapFont();
        Stat.getData().setScale(2.5f);
        Stat.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);

    }

    //dessine le jeu

    public void GameDraw() {

        yCoordBg1 += BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
        yCoordBg2 = yCoordBg1 + yMax;
        if (yCoordBg1 >= 0) {
            yCoordBg1 = yMax*(-1); yCoordBg2 = 0;
        }
        batch.begin();
        batch.draw(background, 0, yCoordBg1);
        batch.draw(background2, 0, yCoordBg2);


        gdx.pg.hero.draw(batch);
        if(gdx.pg.nbBoss >0){
            gdx.pg.boss1.draw(batch);
        }
        for (Iterator it = gdx.pg.bullet.iterator(); it.hasNext();) {
            Bullet bullH = (Bullet) it.next();
            bullH.draw(batch);
        }
        for (Iterator it = gdx.pg.bulletEN.iterator(); it.hasNext();) {
            Bullet bullM = (Bullet) it.next();
            bullM.draw(batch);
        }
        for (Iterator it = gdx.pg.m.iterator(); it.hasNext();) {
            Monster mon  = (Monster) it.next();
            mon.draw(batch);
        }
        for (Iterator it = gdx.pg.pU.iterator(); it.hasNext();) {

            PowerUp up  = (PowerUp) it.next();
            up.draw(batch);
        }
        int i = 1;
        for (Iterator it = gdx.pg.pUInUse.iterator(); it.hasNext();) {
            PowerUp up  = (PowerUp) it.next();
            batch.draw(up.getTexture(),100*i,100);
            i++;
        }
        Lvl.draw(batch, "LVL : " + gdx.pg.hero.getLevel(),
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
                , (int) Math.round(((float) (Gdx.graphics.getWidth() / 5) * ((float) gdx.pg.hero.getExp() / (float) gdx.pg.hero.getMaxExp())))
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

        if(gdx.pg.hero.getLife()<=0){
            shapeLife.rect((int)(
                            (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
                    , 0, (int)(Gdx.graphics.getHeight()/20)
            );
        }
        else {
            shapeLife.rect((int) (
                            (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
                    , 50
                    , (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) gdx.pg.hero.getLife() / (float) gdx.pg.hero.getMaxlife())))
                    , (int) (Gdx.graphics.getHeight() / 20)
            );
        }
        shapeShield.rect((int) (
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
                , 50
                , (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) gdx.pg.hero.shield / (float) gdx.pg.hero.getMaxlife())))
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
        score.draw(batch, "score : " + gdx.pg.scorecalc,
                (int)(Gdx.graphics.getWidth() / 2.5),
                (int)(Gdx.graphics.getHeight() /1.45));
        Lvl2.draw(batch, "Level : " + gdx.pg.hero.getLevel(),
                (int)(Gdx.graphics.getWidth() / 2.5),
                (int)(Gdx.graphics.getHeight() /1.35));
        Stat.draw(batch, "Stats du héro :",
                (int)(Gdx.graphics.getWidth() / 2.5) + 50,
                (int)(Gdx.graphics.getHeight() /1.60));
        DamageBoost.draw(batch, "Damage boost x" + Math.round(gdx.pg.hero.bonus_damage),
                (int)(Gdx.graphics.getWidth() / 2.5),
                (int)(Gdx.graphics.getHeight() /1.75));
        batch.end();


    }

    //dessine le jeu , la barre d'exp et la barre de vie
    public void DrawALL(){
        GameDraw();
        HealthBar();
        ExpBar();
    }



}
