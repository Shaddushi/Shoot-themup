package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MainMenu {

    MyGdxGame gdx;

    protected Texture background;
    public ShapeRenderer backAll ;
    public ShapeRenderer buttonStart ;
    public ShapeRenderer buttonExit ;

    public SpriteBatch batch;

    public BitmapFont title ;
    public BitmapFont Start ;
    public BitmapFont Exit ;

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
        title.getData().setScale(2.5f);
        Start = new BitmapFont();
        Start.getData().setScale(2.5f);
        Exit = new BitmapFont();
        Exit.getData().setScale(2.5f);
        Start.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
        Exit.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
    }

    public void menuDraw() {
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();

        backAll.begin(ShapeType.Filled);
        backAll.setColor(0/255f, 89/255f, 179/255f,1);
        backAll.rect(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() + 100, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() + 100
                , Gdx.graphics.getWidth() - 200, Gdx.graphics.getHeight() - 200);
        backAll.end();

        buttonStart.begin(ShapeType.Filled);
        buttonStart.setColor(0/255f, 200/255f, 179/255f,1);
        buttonStart.rect((float) Gdx.graphics.getWidth()/2 - 100,500,200,100);
        buttonStart.end();

        buttonExit.begin(ShapeType.Filled);
        buttonExit.setColor(0/255f, 200/255f, 179/255f,1);
        buttonExit.rect((float) Gdx.graphics.getWidth()/2 - 100,200,200,100);
        buttonExit.end();
    }

    public void actionStart() {
        float x = (float)Gdx.graphics.getWidth() / 2 - 100 ;
        //le bouton change de couleur si la sourit est au-dessus.
        if(Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 400 && Gdx.input.getY() < 500) {
            buttonStart.begin(ShapeType.Filled);
            buttonStart.setColor(255/255f, 100/255f, 100/255f, 1);
            buttonStart.rect(x, 500, 200, 100);
            buttonStart.end();
        } else {
            buttonStart.begin(ShapeType.Filled);
            buttonStart.setColor(0/255f, 200/255f, 179/255f, 1);
            buttonStart.rect(x, 500, 200, 100);
            buttonStart.end();
        }
        //s'il y a un click dans la zone du rectangle alors on commence un jeu.
        if(Gdx.input.isTouched() && Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 400 && Gdx.input.getY() < 500) {
            gdx.state = 1 ; //GAME_RUNNING
        }
    }

    public void actionExit() {
        float x = (float)Gdx.graphics.getWidth() / 2 - 100 ;
        //le bouton change de couleur si la sourit est au-dessus.
        if(Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 700 && Gdx.input.getY() < 800) {
            buttonExit.begin(ShapeType.Filled);
            buttonExit.setColor(255/255f, 100/255f, 100/255f,1);
            buttonExit.rect((float) Gdx.graphics.getWidth()/2 - 100,200,200,100);
            buttonExit.end();
        } else {
            buttonExit.begin(ShapeType.Filled);
            buttonExit.setColor(0/255f, 200/255f, 179/255f,1);
            buttonExit.rect((float) Gdx.graphics.getWidth()/2 - 100,200,200,100);
            buttonExit.end();
        }
        //s'il y a un click dans la zone du rectangle alors on ferme le jeu
        if(Gdx.input.isTouched() && Gdx.input.getX() > x && Gdx.input.getX() < x + 200 && Gdx.input.getY() > 700 && Gdx.input.getY() < 800) Gdx.app.exit();
    }

    public void actionAll() {
        actionStart();
        actionExit();
    }
}
