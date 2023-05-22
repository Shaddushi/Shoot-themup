package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

import static com.badlogic.gdx.math.MathUtils.random;


public class MyGdxGame<DoubleProperty> extends ApplicationAdapter {


	//nombre montrant la vague en cours dans le menu pause

	public int nbvague;


	//musique
	public Music menuMusic;
	public Music Honteux;

	// different status
	int state;

	static int GAME_NOTRUNNING = 0;
	static final int GAME_RUNNING = 1;

	static final int GAME_PAUSED = 2;

	int cooldown;


	//pour le visuel
	public MainMenu mainMenu;
	public Drawinggame dg;

	public Playinggame pg;


	@Override
	public void create() {

		//valeur de base pour les vagues, le score etc

		nbvague = 1;


		//musique


		if(random.nextInt(0,20) == 19){
			menuMusic = Gdx.audio.newMusic(Gdx.files.internal("mystery.mp3"));
		}
		else {
			menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Shreksophone.mp3"));
		}
		menuMusic.setLooping(true);
		menuMusic.play();

		//pour dessiner
		mainMenu = new MainMenu(this);
		dg = new Drawinggame(this);
		pg = new Playinggame(this);



		// generation de la premiere vague

		pg.Respawn();

		// Gestion des different status

		state = GAME_NOTRUNNING ;
		cooldown = 20;
	}


	//s'occupe du status du jeu (en pause, en cours de jeu, menu)

	public void Status(){
		cooldown--;
		if(this.state == GAME_RUNNING && cooldown <= 0 && Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			this.state= GAME_PAUSED;
			cooldown = 25;
		}
		else if(this.state == GAME_PAUSED && cooldown <=0&& Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			this.state = GAME_RUNNING;
			cooldown = 25;
		}
		if(this.state == GAME_RUNNING && pg.hero.getLife() <= 0){
			this.pg = new Playinggame(this);
			this.state = GAME_NOTRUNNING ;}
	}

	//differente choses qu'il fait selon le status du jeu

	public void GameState(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(this.state == GAME_NOTRUNNING) {
			mainMenu.menuDraw();
			mainMenu.actionAll();
		}
		else if(this.state == GAME_RUNNING){
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
