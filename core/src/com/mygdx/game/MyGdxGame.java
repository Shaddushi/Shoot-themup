package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.Monster;

public class MyGdxGame extends ApplicationAdapter {

	public ShapeRenderer shape;
	public Hero hero;
	public Texture heroimg;

	public Texture monsterimg;
	public SpriteBatch batch;

	public Monster[] m = new Monster[4];
	@Override
	public void create () {
		monsterimg = new Texture("player.png");
		for(int i =0;i<4;i++){

			m[i] = new Monster(40*i,40,20,10,10,monsterimg);
		}
		batch = new SpriteBatch();
		heroimg = new Texture("player.png");
		hero = new Hero(250, 250, 20, 100, 15, heroimg);
	}


	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			hero.gauche();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			hero.droite();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			hero.haut();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			hero.bas();
		}
		batch.begin();
		hero.draw(batch);
		for(int i = 0;i<4;i++){
			m[i].draw(batch);
		}
		batch.end();

	}

}