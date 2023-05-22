package com.mygdx.game.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.MyGdxGame;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MainMenu {

    MyGdxGame gdx;

    protected Texture background;
    public ShapeRenderer backAll ;
    public ShapeRenderer buttonStart ;
    public ShapeRenderer buttonExit ;

    public SpriteBatch batch;

    public BitmapFont title ;
    public BitmapFont titleStart;
    public BitmapFont titleExit;

    public MainMenu(MyGdxGame gdx) {
        //initialise les shaperenderer
        background = new Texture("starry-night-sky.jpg");
        backAll = new ShapeRenderer();
        buttonStart = new ShapeRenderer();
        buttonExit = new ShapeRenderer();
        batch = new SpriteBatch();
        this.gdx = gdx;

        //et le texte
        title = new BitmapFont() ;
        title.getData().setScale(4f);
        titleStart = new BitmapFont();
        titleStart.getData().setScale(4f);
        titleExit = new BitmapFont();
        titleExit.getData().setScale(4f);
    }

    public void menuDraw() {
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        backAll.begin(ShapeType.Filled);
        backAll.setColor(104/255f, 107/255f, 112/255f,1);
        backAll.rect(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() + 100, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() + 100
                , Gdx.graphics.getWidth() - 200, Gdx.graphics.getHeight() - 200);
        backAll.end();

        batch.begin();
        title.draw(batch, "this.SetLooping(true);",
                (int)(Gdx.graphics.getWidth() / 3),
                (int)(Gdx.graphics.getHeight() /1.25));
        batch.end();
    }

    public void actionStart() {
        float x = (float)Gdx.graphics.getWidth() / 2 - 100 ;

        //le bouton est affiche et change de couleur si la sourit est au-dessus.
        if(Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 400 && Gdx.input.getY() < 500) {
            buttonStart.begin(ShapeType.Filled);
            buttonStart.setColor(171/255f, 171/255f, 171/255f, 1);
            buttonStart.rect(x, 500, 200, 100);
            buttonStart.end();
        } else {
            buttonStart.begin(ShapeType.Filled);
            buttonStart.setColor(139/255f, 143/255f, 150/255f, 1);
            buttonStart.rect(x, 500, 200, 100);
            buttonStart.end();
        }

        //s'il y a un click dans la zone du rectangle alors on commence un jeu.
        if(Gdx.input.justTouched() && Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 400 && Gdx.input.getY() < 500) {
            gdx.state = 1 ; //GAME_RUNNING
        }

        batch.begin();
        titleStart.draw(batch, "START",
                (int)(Gdx.graphics.getWidth() / 2.3f),
                (int)(Gdx.graphics.getHeight() / 1.73f));
        batch.end();
    }

    public void actionExit() {
        float x = (float)Gdx.graphics.getWidth() / 2 - 100 ;

        //le bouton est affiche et change de couleur si la sourit est au-dessus.
        if(Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 700 && Gdx.input.getY() < 800) {
            buttonExit.begin(ShapeType.Filled);
            buttonExit.setColor(171/255f, 171/255f, 171/255f, 1);
            buttonExit.rect((float) Gdx.graphics.getWidth()/2 - 100,200,200,100);
            buttonExit.end();
        } else {
            buttonExit.begin(ShapeType.Filled);
            buttonExit.setColor(139/255f, 143/255f, 150/255f, 1);
            buttonExit.rect((float) Gdx.graphics.getWidth()/2 - 100,200,200,100);
            buttonExit.end();
        }

        //s'il y a un click dans la zone du rectangle alors on ferme le jeu
        if(Gdx.input.justTouched() && Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 700 &&
                Gdx.input.getY() < 800) Gdx.app.exit();

        batch.begin();
        titleExit.draw(batch, "EXIT",
                (int)(Gdx.graphics.getWidth() / 2.175f),
                (int)(Gdx.graphics.getHeight() / 3.65f));
        batch.end();
    }

    public void actionAll() {
        actionStart();
        actionExit();
    }
}
