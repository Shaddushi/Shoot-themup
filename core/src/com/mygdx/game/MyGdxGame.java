package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.MediumMonster;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.characters.monster.MonstreJaponais;
import com.mygdx.game.characters.monster.SmallMonster;
import com.mygdx.game.bullet.Bullet;


import java.util.LinkedHashSet;

public class MyGdxGame<DoubleProperty> extends ApplicationAdapter {

	public ShapeRenderer shapeLife;

	public ShapeRenderer shapeNoLife;
	public Hero hero;
	public Texture heroimg;

	public Texture monsterimg;

	public Texture bulletimg;

	protected Texture background;
	public SpriteBatch batch;

	public int nbmonster = 8;

	public Music menuMusic;

	public Music Honteux;
	LinkedHashSet<Bullet> bullet = new LinkedHashSet();

	LinkedHashSet<Bullet> bulletEN = new LinkedHashSet();
	public LinkedHashSet<Monster> m = new LinkedHashSet();


	@Override
	public void create() {
		bulletimg = new Texture("laserGreen.png");

		for (int i = 0; i < nbmonster; i++) {
			System.out.println(i);
			m.add(new SmallMonster(Gdx.graphics.getWidth() - ((i + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() * 0.3),this));
		}

		m.add(new MediumMonster(700,850,this));
		m.add(new MonstreJaponais(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), this));
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Shreksophone.mp3"));
		Honteux = Gdx.audio.newMusic(Gdx.files.internal("Honteux.mp3"));
		menuMusic.setLooping(true);
		//menuMusic.play();
		shapeNoLife = new ShapeRenderer();
		shapeLife = new ShapeRenderer();

		batch = new SpriteBatch();
		heroimg = new Texture("player.png");
		background = new Texture(Gdx.files.internal("starry-night-sky.jpg"));
		hero = new Hero(250, 250, 20, 20, 20, heroimg, 10,this);
	}


	public void collisionEnnemi(Bullet bullH) {
		for (Monster mon : m) {
			if ((bullH.getY() >= mon.getY()) && (bullH.getY() - mon.getTailley() <= mon.getY())) {
				if ((bullH.getX() >= mon.getX()) && (bullH.getX() - mon.getTaillex() - 2 <= mon.getX())) {
					bullH.existe = false;
					mon.toucher(bullH.getDegat());
					mon.mort();
				}
			}
		}
	}

	public void collisionAllie(Bullet bullM) {
		if ((bullM.getY() >= hero.getY()) && (bullM.getY() - hero.getTailley() <= hero.getY())) {
			if (((bullM.getX() >= hero.getX()) && (bullM.getX() - hero.getTaillex() <= hero.getX())) || (hero.getX() >= bullM.getX() && hero.getX() <= (bullM.getX() + bullM.getTexture().getWidth()) )) {
				bullM.existe = false;
				hero.toucher(bullM.getDegat());
				hero.mort();
				//Honteux.play();
			}
		}
		for(Monster mon: m) {
			if ((mon.getY() >= hero.getY()) && (mon.getY() - hero.getTailley() <= hero.getY())) {
				if ((mon.getX() >= hero.getX()) && (mon.getX() - hero.getTaillex() <= hero.getX())|| ((hero.getX() >= mon.getX()) && hero.getX() <= (mon.getX() + mon.getTexture().getWidth()) )){
					hero.toucher(mon.getDegatCAC());
					mon.toucher(hero.getDegatCAC());
					hero.mort();
					mon.mort();
				}
			}
		}
	}



	public void shoot(){
		for(Monster mon : m){
			if(mon.getcooldown()<=0){
				Bullet[] BullHere = mon.tirer();
				for(Bullet B : BullHere)
					if(B != null){
						bulletEN.add(B);
					}

				mon.setCooldownreset();
			}
			mon.cooldownDown();

		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			if(hero.getcooldown() <= 0) {
				bullet.add(hero.tirer());
				hero.setCooldownreset();
			}
			hero.cooldownDown();

		}
	}

	public void CollisionAll(){
		for (Bullet bullH : bullet) {
			if (bullH.getY() >= Gdx.graphics.getHeight()) {
				bullH.existe = false;
			} else {
				collisionEnnemi(bullH);
			}
		}

		shoot();

		for (Bullet me : bulletEN) {
			if (me.getY() <= -40) {
				me.existe = false;
			} else {
				collisionAllie(me);

			}

		}
	}


	public void delete() {
		Bullet[] bullHero = bullet.toArray(new Bullet[0]);
		for (Bullet ma : bullHero) {
			if (!ma.existe) {
				bullet.remove(ma);
			}
		}
		Bullet[] bullEN = bulletEN.toArray(new Bullet[0]);
		for (Bullet me : bullEN) {
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

	}
	public void dessine() {
		batch.begin();
		batch.draw(background, 0, 0);
		hero.draw(batch);

		for (Bullet bullH : bullet) {
			bullH.draw(batch);
			bullH.updateBullet();
		}
		for (Bullet bullM : bulletEN) {
			bullM.draw(batch);
			bullM.updateBullet();
		}
		for (Monster mon : m) {
			mon.draw(batch);
			mon.updateall();
		}

		batch.end();

	}

	public void HealthBar(){
		shapeLife = new ShapeRenderer();
		shapeNoLife = new ShapeRenderer();
		shapeNoLife.begin(ShapeRenderer.ShapeType.Filled);
		shapeLife.begin(ShapeRenderer.ShapeType.Filled);
		shapeLife.setColor(0, 255, 0,1);
		shapeNoLife.setColor(255, 0, 0,1);
		if(hero.getLife()<=0){
			shapeLife.rect((int)(
							(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
					, 0, (int)(Gdx.graphics.getHeight()/20)
			);
		}
		else {
			shapeLife.rect((int) (
							(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
					, 50
					, (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) hero.getLife() / (float) hero.getMaxlife())))
					, (int) (Gdx.graphics.getHeight() / 20)
			);
		}
		shapeNoLife.rect((int)(
						(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
				, (float)(Gdx.graphics.getWidth()/3), (int)(Gdx.graphics.getHeight()/20)
		);
		shapeNoLife.end();
		shapeLife.end();
	}



	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		hero.update();
		CollisionAll();
		//shoot();
		delete();
		dessine();
		HealthBar();


	}



}
