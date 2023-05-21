package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.MediumMonster;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.characters.monster.MonstreJaponais;
import com.mygdx.game.characters.monster.SmallMonster;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.powerUp.powerUp;


import java.util.LinkedHashSet;

import static com.badlogic.gdx.math.MathUtils.random;

public class MyGdxGame<DoubleProperty> extends ApplicationAdapter {






	//controle le nombre de monstres pour les vagues


	public int nbvague;


	//musique
	public Music menuMusic;
	public Music Honteux;

	// different status
	int state;

	static final int GAME_RUNNING = 1;

	static final int GAME_PAUSED = 2;

	int cooldown;


	//pour le visuel

	public Drawinggame dg;

	public Playinggame pg;





	@Override
	public void create() {

		//valeur de base pour les vagues, le score etc
		nbvague = 1;




		//musique

		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Shreksophone.mp3"));
		Honteux = Gdx.audio.newMusic(Gdx.files.internal("Honteux.mp3"));
		menuMusic.setLooping(true);
		//menuMusic.play();

		//pour dessiner

		dg = new Drawinggame(this);
		pg = new Playinggame(this);



		// generation de la premiere vague

		pg.Respawn();

		// Gestion des different status

		state = GAME_RUNNING;
		cooldown = 50;
	}


	//s'occupe du status du jeu (en pause, en cours de jeu, menu)

	public void Status(){
		cooldown--;
		if(this.state == GAME_RUNNING && cooldown <= 0 && Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			this.state= GAME_PAUSED;
			cooldown = 50;
		}
		else if(this.state == GAME_PAUSED && cooldown <=0&& Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			this.state = GAME_RUNNING;
			cooldown = 50;
		}
	}

	//S'occupe de verifier les collisions balles/ennemis , balles/hero , hero/ennemis



	//differente choses qu'il fait selon le status du jeu

	public void GameState(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(this.state == GAME_RUNNING){
			pg.Respawn();
			pg.delete();
			pg.GameUpdate();
			pg.CollisionAll();


			dg.DrawALL();
		}
		else if(this.state == GAME_PAUSED){
			dg.DrawALL();
			dg.PausedMod();


		}
	}


	//methode Render

	@Override
	public void render() {
		Status();
		GameState();
	}



}
