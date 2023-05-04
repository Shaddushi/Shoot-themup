package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.hero.Hero;

public class MyGdxGame extends ApplicationAdapter {

	ShapeRenderer shape;
	Hero hero;
	
	@Override
	public void create () {
		shape = new ShapeRenderer();


	}

	public static Texture backgroundTexture;
	public static Sprite backgroundSprite;
	private SpriteBatch spriteBatch;

	private void loadTextures() {
		backgroundTexture = new Texture("images/starBackground.png");
		backgroundSprite =new Sprite(backgroundTexture);
	}

	public void renderBackground() {
		backgroundSprite.draw(spriteBatch);}

	@Override
	public void render () {
		spriteBatch.begin();
		renderBackground();
		spriteBatch.end();

	}
	

}
