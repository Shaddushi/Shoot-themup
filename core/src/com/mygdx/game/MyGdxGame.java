package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.characters.monster.SmallMonster;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletEnnemi;
import com.mygdx.game.weapon.BulletHero;

import java.util.LinkedHashSet;

public class MyGdxGame<DoubleProperty> extends ApplicationAdapter {

	public ShapeRenderer shape;
	public Hero hero;
	public Texture heroimg;

	public Texture monsterimg;

	public Texture bulletimg;

	protected Texture background;
	public SpriteBatch batch;

	public int nbmonster = 8;
	LinkedHashSet<BulletHero> bullet = new LinkedHashSet();

	LinkedHashSet<BulletEnnemi> bulletEN = new LinkedHashSet();
	LinkedHashSet<Monster> m = new LinkedHashSet();

	@Override
	public void create() {
		bulletimg = new Texture("laserGreen.png");

		for (int i = 0; i < nbmonster; i++) {
			System.out.println(i);
			m.add(new SmallMonster(Gdx.graphics.getWidth() - ((i + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() * 0.3)));
		}
		shape = new ShapeRenderer();
		batch = new SpriteBatch();
		heroimg = new Texture("player.png");
		background = new Texture(Gdx.files.internal("starry-night-sky.jpg"));
		hero = new Hero(250, 250, 20, 20, 100, heroimg, 10);
	}


	public void collisionEnnemi(Bullet ma) {
		for (Monster mon : m) {
			if ((ma.getY() >= mon.getY()) && (ma.getY() - mon.getTailley() <= mon.getY())) {
				if ((ma.getX() >= mon.getX()) && (ma.getX() - mon.getTaillex() - 2 <= mon.getX())) {
					ma.existe = false;
					mon.toucher(ma.getDegat());
					mon.mort();
				}
			}
		}
	}

	public void collisionAllie(Bullet me) {
		if ((me.getY() >= hero.getY()) && (me.getY() - hero.getTailley() <= hero.getY())) {
			if ((me.getX() >= hero.getX()) && (me.getX() - hero.getTaillex() <= hero.getX())) {
				me.existe = false;
				hero.toucher(me.getDegat());
				hero.mort();
			}
		}
	}

	public void move(){

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


	}


	public void shoot(){
		for(Monster mon : m){
			if(mon.getcooldown()<=0){
				bulletEN.add(mon.tirer());
				mon.setCooldownreset();
			}
			mon.cooldownDown();

		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			if(hero.getcooldown() <= 0) {
				bullet.add((BulletHero) hero.tirer());
				hero.setCooldownreset();
			}
			hero.cooldownDown();

		}
	}

	public void CollisionAll(){
		for (Bullet ma : bullet) {
			if (ma.getY() >= Gdx.graphics.getHeight()) {
				ma.existe = false;
			} else {
				collisionEnnemi(ma);
			}
		}
		shoot();

		for (BulletEnnemi me : bulletEN) {
			if (me.getY() <= 0) {
				me.existe = false;
			} else {
				collisionAllie(me);


			}

		}
	}


	public void delete() {
		BulletHero[] bull = bullet.toArray(new BulletHero[0]);
		for (BulletHero ma : bull) {
			if (!ma.existe) {
				bullet.remove(ma);
			}
		}
		BulletEnnemi[] bullEN = bulletEN.toArray(new BulletEnnemi[0]);
		for (BulletEnnemi me : bullEN) {
			if (!me.existe) {
				bulletEN.remove(me);
			}
		}
		Monster[] monstre = m.toArray(new Monster[0]);
		for(Monster mon : monstre) {
			if (!mon.existe) {
				m.remove(mon);
			}
		}
		for (BulletHero ma : bullet) {
			ma.draw(batch);
			ma.haut();
		}
		for (BulletEnnemi me : bulletEN) {
			me.draw(batch);
			me.bas();
		}
		for (Monster mon : m) {
			mon.draw(batch);
			mon.updateall();
		}

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		hero.move();
		batch.begin();
		batch.draw(background, 0, 0);
		CollisionAll();
		delete();
		hero.draw(batch);

		batch.end();
		shape = new ShapeRenderer();
		shape.begin(ShapeRenderer.ShapeType.Line);
		shape.setColor(255, 1, 0, 1);
		shape.rect(200, 200, 200, 200);
		shape.end();

	}
}
