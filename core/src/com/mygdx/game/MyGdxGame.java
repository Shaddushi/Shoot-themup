package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
<<<<<<< HEAD
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
=======
>>>>>>> 16bffcf92a7752ef5687778771a0c808d311c567
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.characters.hero.Hero;

public class MyGdxGame extends ApplicationAdapter {
<<<<<<< HEAD

	public ShapeRenderer shape;
	public Hero hero;
	public Texture heroimg;
	public SpriteBatch batch;
	
	@Override
	public void create () {

		batch = new SpriteBatch();
		heroimg = new Texture("player.png");
		hero = new Hero(250, 250, 20, 100, 15, heroimg);
	}


	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		hero.draw(batch);
		batch.end();

=======
	ShapeRenderer shape;

	Hero hero;
	@Override
	public void create () {
		hero = new Hero(50,50,20,10);
		shape = new ShapeRenderer();

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (hero.x < Gdx.graphics.getWidth()){
			System.out.println(hero.speed);
			hero.x =hero.x + hero.speed;
		}
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.circle(hero.x, hero.y, 30);
		shape.end();
>>>>>>> 16bffcf92a7752ef5687778771a0c808d311c567
	}

}