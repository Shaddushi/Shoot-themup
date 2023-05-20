package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletEnnemi;
import com.mygdx.game.bullet.boss.BulletBoss1;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.powerUp.powerUp;

import java.util.Iterator;


public class Drawinggame {
    MyGdxGame gdx;

    public Drawinggame(MyGdxGame gdx){
        this.gdx = gdx;
    }

    public void GameDraw() {
        gdx.batch.begin();
        gdx.batch.draw(gdx.background, 0, 0);


        gdx.hero.draw(gdx.batch);
        for (Iterator it = gdx.bullet.iterator(); it.hasNext();) {
            Bullet bullH = (Bullet) it.next();
            bullH.draw(gdx.batch);
        }
        for (Iterator it = gdx.bulletEN.iterator(); it.hasNext();) {
            Bullet bullM = (Bullet) it.next();
            bullM.draw(gdx.batch);
        }
        for (Iterator it = gdx.m.iterator(); it.hasNext();) {
            Monster mon  = (Monster) it.next();
            mon.draw(gdx.batch);
        }
        for (Iterator it = gdx.pU.iterator(); it.hasNext();) {

            powerUp up  = (powerUp) it.next();
            up.draw(gdx.batch);
        }
        int i = 1;
        for (Iterator it = gdx.pUInUse.iterator(); it.hasNext();) {
            powerUp up  = (powerUp) it.next();
            gdx.batch.draw(up.getTexture(),100*i,100);
            i++;
        }
        gdx.Lvl.draw(gdx.batch, "LVL : " + gdx.hero.getLevel(),
                (int)((Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3.2) -50)),
                140);
        gdx.batch.end();
    }
    public void ExpBar(){
        gdx.shapeNoExp = new ShapeRenderer();
        gdx.shapeExp = new ShapeRenderer();
        gdx.shapeNoExp.begin(ShapeRenderer.ShapeType.Filled);
        gdx.shapeExp.begin(ShapeRenderer.ShapeType.Filled);
        gdx.shapeExp.setColor(61/255f, 197/255f, 242/255f,1);
        gdx.shapeNoExp.setColor(0/255f, 255/255f, 205/255f,1);

        gdx.shapeNoExp.rect((int)(
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/5) -50)), 70 +(int)(Gdx.graphics.getHeight()/20)
                , (float)(Gdx.graphics.getWidth()/5), (int)(Gdx.graphics.getHeight()/50)
        );



        gdx.shapeExp.rect((int) (
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 5) - 50))
                , 70 +(int)(Gdx.graphics.getHeight()/20)
                , (int) Math.round(((float) (Gdx.graphics.getWidth() / 5) * ((float) gdx.hero.getExp() / (float) gdx.hero.getMaxExp())))
                , (int) (Gdx.graphics.getHeight() / 50)
        );




        gdx.shapeNoExp.end();
        gdx.shapeExp.end();
    }
    public void HealthBar(){
        gdx.shapeNoLife = new ShapeRenderer();
        gdx.shapeLife = new ShapeRenderer();
        gdx.shapeShield = new ShapeRenderer();
        gdx.shapeNoLife.begin(ShapeRenderer.ShapeType.Filled);
        gdx.shapeLife.begin(ShapeRenderer.ShapeType.Filled);
        gdx.shapeShield.begin(ShapeRenderer.ShapeType.Filled);
        gdx.shapeLife.setColor(0, 255, 0,1);
        gdx.shapeNoLife.setColor(255, 0, 0,1);
        gdx.shapeShield.setColor(0,0,255,1);
        gdx.shapeNoLife.rect((int)(
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
                , (float)(Gdx.graphics.getWidth()/3), (int)(Gdx.graphics.getHeight()/20)
        );

        if(gdx.hero.getLife()<=0){
            gdx.shapeLife.rect((int)(
                            (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
                    , 0, (int)(Gdx.graphics.getHeight()/20)
            );
        }
        else {
            gdx.shapeLife.rect((int) (
                            (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
                    , 50
                    , (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) gdx.hero.getLife() / (float) gdx.hero.getMaxlife())))
                    , (int) (Gdx.graphics.getHeight() / 20)
            );
        }
        gdx.shapeShield.rect((int) (
                        (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
                , 50
                , (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) gdx.hero.shield / (float) gdx.hero.getMaxlife())))
                , (int) (Gdx.graphics.getHeight() / 20)
        );

        gdx.shapeNoLife.end();
        gdx.shapeLife.end();
        gdx.shapeShield.end();
    }

    public void PausedMod() {


        ShapeRenderer shapeBack = new ShapeRenderer();
        shapeBack.begin(ShapeRenderer.ShapeType.Filled);
        shapeBack.setColor(180 / 255f, 183 / 255f, 174 / 255f, 1);

        shapeBack.rect(
                (Gdx.graphics.getWidth()/ 3), (int) (Gdx.graphics.getHeight() / 4)
                , (float) (Gdx.graphics.getWidth() / 3), (int) (Gdx.graphics.getHeight() / 1.5)
        );
        shapeBack.end();

        gdx.batch.begin();

        gdx.Lvl2.draw(gdx.batch, "Level : " + gdx.hero.getLevel(),
                (int)(Gdx.graphics.getWidth() / 2.5),
                (int)(Gdx.graphics.getHeight() /3.5));
        gdx.Vague.draw(gdx.batch, "Vague : " + gdx.nbvague,
                (int)(Gdx.graphics.getWidth() / 4.5),
                (int)(Gdx.graphics.getHeight() /1.1));
        gdx.score.draw(gdx.batch, "Level : " + gdx.hero.getLevel(),
                (int)(Gdx.graphics.getWidth() / 2.5),
                (int)(Gdx.graphics.getHeight() /4.5));
        gdx.batch.end();


    }

    public void DrawALL(){
        GameDraw();
        HealthBar();
        ExpBar();
    }



}
