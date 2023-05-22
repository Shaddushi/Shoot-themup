package com.mygdx.game.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.MyGdxGame;

import java.awt.event.MouseEvent;

public class DeathMenu {

    MyGdxGame gdx;

    public BitmapFont deathTitle ;
    public BitmapFont mainMenu ;

    public ShapeRenderer buttonMainMenu;

    public SpriteBatch batch;

    public DeathMenu(MyGdxGame gdx) {
        buttonMainMenu = new ShapeRenderer() ;
        batch = new SpriteBatch() ;
        this.gdx = gdx ;

        deathTitle = new BitmapFont() ;
        deathTitle.getData().setScale(10f) ;
        mainMenu = new BitmapFont() ;
        mainMenu.getData().setScale(4f) ;
    }

    public void deathMenuDraw() {
        batch.begin();
        deathTitle.draw(batch, "GAME OVER",
                (int)(Gdx.graphics.getWidth() / 5f),
                (int)(Gdx.graphics.getHeight() /1.25));

        mainMenu.draw(batch, "Main Menu",
                (int)(Gdx.graphics.getWidth() / 2.5f),
                (int)(Gdx.graphics.getHeight() /4.25));
        batch.end();
    }

    public void actionMainmenu() {
        float x = (float)Gdx.graphics.getWidth() / 2.5f, y = (float)(Gdx.graphics.getHeight() /4.25);
        int width = 275, height = 50 ;

        if(Gdx.input.getX() > x && Gdx.input.getX() < x + width && Gdx.input.getY() > Gdx.graphics.getHeight() - y &&
                Gdx.input.getY() < (Gdx.graphics.getHeight() - y) + height) {
            mainMenu.setColor(Color.DARK_GRAY);
        } else {
            mainMenu.setColor(Color.WHITE);
        }

        if(Gdx.input.justTouched() && Gdx.input.getX() > x && Gdx.input.getX() < x + width &&
                Gdx.input.getY() > Gdx.graphics.getHeight() - y && Gdx.input.getY() < (Gdx.graphics.getHeight() - y) + height) {
            gdx.state = 0 ; //GAME_NOTRUNNING
        }
    }

    public void actionAll() {
        actionMainmenu() ;
    }

}
