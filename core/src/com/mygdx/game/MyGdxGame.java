package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.weapon.Bullet;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class MyGdxGame extends ApplicationAdapter {

	public ShapeRenderer shape;
	public Hero hero;
	public Texture heroimg;

	public Texture monsterimg;

	public Texture bulletimg;

	protected Texture background;
	public SpriteBatch batch;

	LinkedHashSet<Bullet> bullet=new LinkedHashSet();

	public Monster[] m = new Monster[8];

	@Override
	public void create () {
		monsterimg = new Texture("dreadnaught.png");
		bulletimg = new Texture("laserGreen.png");
		for(int i =0;i<m.length;i++){
			System.out.println(i);
			m[i] = new Monster(Gdx.graphics.getWidth()-((i+1)*(Gdx.graphics.getWidth()/(m.length+1))),(int)(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()*0.3), 20,10,monsterimg,0,52,42);
		}
		batch = new SpriteBatch();
		heroimg = new Texture("player.png");
		background = new Texture(Gdx.files.internal("starry-night-sky.jpg"));
		hero = new Hero(250, 250, 20, 100, heroimg,75,99);
	}


	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			hero.gauche();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			hero.droite();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			hero.haut();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			hero.bas();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			bullet.add(hero.tirer());
			System.out.println(bullet.size());
		}
		batch.begin();
		batch.draw(background,0,0);

		for (Bullet ma : bullet) {
			if(ma.getY() >= Gdx.graphics.getHeight()){
				ma.existe = false;
			}
			else{
				for(int r = 0;r<m.length;r++){
					if((ma.getY() >= m[r].getY()) && (ma.getY()-m[r].hauteur <= m[r].getY())){
						if((ma.getX() >= m[r].getX()) && (ma.getX()-m[r].largeur <= m[r].getX())) {
							ma.existe = false;
						}
					}
				}

			}

		}
		Bullet[] bull = bullet.toArray(new Bullet[0]);
		for(Bullet ma : bull){
			if(!ma.existe){
				bullet.remove(ma);
			}
		}
		for (Bullet ma : bullet) {
			ma.draw(batch);
			ma.haut();
		}




		hero.draw(batch);
		for(int j = 0;j<m.length;j++){
			m[j].draw(batch);
		}
		batch.end();

	}
}