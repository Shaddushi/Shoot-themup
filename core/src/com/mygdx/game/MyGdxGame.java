package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.characters.hero.Hero;

public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shape;

	Hero hero;
	@Override
	public void create () {
		shape = new ShapeRenderer();
		hero = new Hero(50,50,20,10,10);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		hero.x += 5;
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.circle(hero.x, hero.y, 50);
		shape.end();
	}

}