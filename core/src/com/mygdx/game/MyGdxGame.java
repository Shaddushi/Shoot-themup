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
import com.mygdx.game.characters.monster.SmallMonster;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletEnnemi;
import com.mygdx.game.weapon.BulletHero;

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

	LinkedHashSet<BulletHero> bullet=new LinkedHashSet();

	LinkedHashSet<BulletEnnemi> bulletEN=new LinkedHashSet();
	public SmallMonster[] m = new SmallMonster[5];

	@Override
	public void create () {
		bulletimg = new Texture("laserGreen.png");
		for(int i =0;i<m.length;i++){
			System.out.println(i);
			m[i] = new SmallMonster(Gdx.graphics.getWidth()-((i+1)*(Gdx.graphics.getWidth()/(m.length+1))),(int)(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()*0.3));
		}
		batch = new SpriteBatch();
		heroimg = new Texture("player.png");
		background = new Texture(Gdx.files.internal("starry-night-sky.jpg"));
		hero = new Hero(250, 250, 20, 20,100 ,heroimg,10);
	}


	public void collisionEnnemi(Bullet ma){
		for(int r = 0;r<m.length;r++){
			if((ma.getY() >= m[r].getY()) && (ma.getY()-m[r].getTailley() <= m[r].getY())){
				if((ma.getX() >= m[r].getX()) && (ma.getX()-m[r].getTaillex()-2 <= m[r].getX())) {
					ma.existe = false;
				}
			}
		}
	}

	public void collisionAllie(Bullet me){
		if((me.getY() <= hero.getY()) && (me.getY()+hero.getTailley() >= hero.getY())){
			if((me.getX() <= hero.getX()) && (me.getX()+hero.getTaillex() >= hero.getX())) {
				me.existe = false;
			}
		}
	}

	public void bougetonboule(){
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
			if(hero.getcooldown() <= 0) {
				bullet.add((BulletHero) hero.tirer());
				hero.setCooldownreset();
			}
			hero.cooldownDown();
		}
	}

	public void shoot(){
		for(Monster mon : m){
			if(mon.getcooldown()<=0){
				bulletEN.add((BulletEnnemi) mon.tirer());
				mon.setCooldownreset();
			}
			mon.cooldownDown();
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		bougetonboule();
		batch.begin();
		batch.draw(background,0,0);

		for (Bullet ma : bullet) {
			if(ma.getY() >= Gdx.graphics.getHeight()){
				ma.existe = false;
			}
			else{
				collisionEnnemi(ma);

			}

		}
		shoot();
		for (BulletEnnemi me : bulletEN) {
			if(me.getY() <= 0){
				me.existe = false;
			}
			else{
				collisionAllie(me);
				

			}

		}


		BulletHero[] bull = bullet.toArray(new BulletHero[0]);
		for(BulletHero ma : bull){
			if(!ma.existe){
				bullet.remove(ma);
			}
		}
		for (BulletHero ma : bullet) {
			ma.draw(batch);
			ma.haut();
		}
		for(BulletEnnemi me : bulletEN){
			me.draw(batch);
			me.bas();
		}




		hero.draw(batch);
		for(int j = 0;j<m.length;j++){
			m[j].draw(batch);
			m[j].update();
		}
		batch.end();

	}
}