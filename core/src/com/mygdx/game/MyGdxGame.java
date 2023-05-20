package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.bullet.Ally.BulletHero;
import com.mygdx.game.bullet.boss.BulletBoss1;
import com.mygdx.game.characters.hero.Hero;
import com.mygdx.game.characters.monster.MediumMonster;
import com.mygdx.game.characters.monster.Monster;
import com.mygdx.game.characters.monster.MonstreJaponais;
import com.mygdx.game.characters.monster.SmallMonster;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.characters.monster.boss.Boss1;
import com.mygdx.game.powerUp.powerUp;


import java.util.LinkedHashSet;

import static com.badlogic.gdx.math.MathUtils.random;

public class MyGdxGame<DoubleProperty> extends ApplicationAdapter {


	//renderer des barres de vies etc
	public ShapeRenderer shapeLife;
	public ShapeRenderer shapeShield;
	public ShapeRenderer shapeNoLife;
	public ShapeRenderer shapeExp;
	public ShapeRenderer shapeNoExp;

	public Hero hero;
	public Texture heroimg;



	protected Texture background;
	public SpriteBatch batch;


	//controle le nombre de monstre pour les vagues
	public int nbmonsterlast;
	public int nbmonster;

	public int nbvague;
	//musique
	public Music menuMusic;
	public Music Honteux;

	// Menu Pause
	int state;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;


	//liste des balles , ennemi, buffs etc

	public LinkedHashSet<BulletHero> bullet = new LinkedHashSet<>();

	public LinkedHashSet<Bullet> bulletEN = new LinkedHashSet<>();
	public LinkedHashSet<Monster> m = new LinkedHashSet<>();

	public LinkedHashSet<powerUp> pU = new LinkedHashSet<powerUp>();

	public LinkedHashSet<powerUp> pUInUse = new LinkedHashSet<powerUp>();

	public Texture monsterimg;

	public Texture bulletimg;


	//pour dessiner
	public BitmapFont Lvl;
	public BitmapFont Lvl2;
	public BitmapFont score;
	public BitmapFont Vague;
	public Drawinggame dg;

	//cooldown du menu pause et score

	int cooldown;

	int scorecalc;


	@Override
	public void create() {
		bulletimg = new Texture("laserGreen.png");
		heroimg = new Texture("player.png");
		background = new Texture(Gdx.files.internal("starry-night-sky.jpg"));

		nbmonster = 5;
		nbmonsterlast = nbmonster;
		nbvague = 1;
		scorecalc = 0;

		// generation de la premiere vague

		for (int i = 0; i < nbmonster; i++) {
			m.add(new SmallMonster(Gdx.graphics.getWidth() - ((i + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() * 0.3),this));
		}
		
		hero = new Hero(250, 250, 10, 10, 20, heroimg, 10,this);



		//musique

		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Shreksophone.mp3"));
		Honteux = Gdx.audio.newMusic(Gdx.files.internal("Honteux.mp3"));
		menuMusic.setLooping(true);
		//menuMusic.play();

		//pour dessiner

		dg = new Drawinggame(this);
		shapeNoLife = new ShapeRenderer();
		shapeLife = new ShapeRenderer();
		shapeNoExp = new ShapeRenderer();
		shapeExp = new ShapeRenderer();
		shapeShield = new ShapeRenderer();
		batch = new SpriteBatch();

		//et le texte

		Lvl = new BitmapFont();
		Lvl.getData().setScale(2.5f);
		Lvl2 = new BitmapFont();
		Lvl2.getData().setScale(2.5f);
		score = new BitmapFont();
		score.getData().setScale(2.5f);
		Vague = new BitmapFont();
		Vague.getData().setScale(4f);
		Lvl2.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
		score.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
		Vague.setColor(128 / 255f, 166/ 255f, 191/ 255f,1);
		// Gestion des different status

		cooldown = 50;
		state = GAME_RUNNING;




	}


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



	public void CollisionAll(){
		for (Bullet bullH : bullet) {
			if (bullH.getY() >= Gdx.graphics.getHeight()) {
				bullH.existe = false;
			} else {
				collisionEnnemi(bullH);
			}
		}


		for (Bullet me : bulletEN) {
			if (me.getY() <= -40) {
				me.existe = false;
			} else {
				collisionAllie(me);

			}

		}
	}

	public void collisionEnnemi(Bullet bullH) {
		for (Monster mon : m) {
			if ((bullH.getY() >= mon.getY()) && (bullH.getY() - mon.getTailley() <= mon.getY())) {
				if ((bullH.getX() >= mon.getX()) && (bullH.getX() - mon.getTaillex() - 2 <= mon.getX())) {
					bullH.existe = false;
					System.out.println(mon.getLife() + "      " + mon.existe + "         " + bullH.getDegat()) ;
					mon.toucher(bullH.getDegat());
					scorecalc += bullH.getDegat();
					mon.mort();
					System.out.println(mon.getLife() + " aaaaa     " + mon.existe + "       " + this.hero.bonus_damage);
				}
			}

		}
	}

	public void collisionAllie(Bullet bullM) {
		if ((bullM.getY() >= hero.getY()) && (bullM.getY() - hero.getTailley() <= hero.getY())|| (hero.getY() >= bullM.getY() && hero.getY() <= (bullM.getY() + bullM.getTexture().getHeight()) )) {
			if (((bullM.getX() >= hero.getX()) && (bullM.getX() - hero.getTaillex() <= hero.getX())) || (hero.getX() >= bullM.getX() && hero.getX() <= (bullM.getX() + bullM.getTexture().getWidth()) )) {
				bullM.existe = false;
				hero.toucher(bullM.getDegat());
				hero.mort();
				//Honteux.play();
			}
		}
		for(Monster mon: m) {

			if ((mon.getY() >= hero.getY()) && (mon.getY() - hero.getTailley() <= hero.getY())|| ((hero.getY() >= mon.getY()) && hero.getY() <= (mon.getY() + mon.getTexture().getHeight()) )) {
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

	}




	public void Respawn(){
		if(nbmonster == 0) {
			nbmonster = (int) Math.round(nbmonsterlast * 1.2);
			int nbmonstertemp = (int) Math.round(nbmonsterlast * 1.2);
			nbmonsterlast = nbmonster;


			while(nbmonstertemp!=0){
				int rand = random.nextInt(0,100);
				if(rand <=0){
					m.add(new SmallMonster(Gdx.graphics.getWidth() - ((nbmonster-nbmonstertemp + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), Gdx.graphics.getHeight()-100, this));
				}
				else if (rand <=1) {
					m.add(new MediumMonster(Gdx.graphics.getWidth() - ((nbmonster-nbmonstertemp + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), Gdx.graphics.getHeight()-100, this));
				}
				else if (rand <= 100) {
					m.add(new MonstreJaponais((Gdx.graphics.getWidth() - ((nbmonster-nbmonstertemp + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1)))), Gdx.graphics.getHeight()-100, this));
				}
				nbmonstertemp--;
			}


			nbvague++;
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
		powerUp[] powUps = pU.toArray(new powerUp[0]);
		for (powerUp pu : powUps) {
			if (!pu.existe) {
				pUInUse.add(pu);
				pU.remove(pu);
			}
		}
		powerUp[] powerUpsInuse = pUInUse.toArray(new powerUp[0]);
		for (powerUp pu : powerUpsInuse) {
			if(pu.timer <= 0){

				pu.undo();
				pUInUse.remove(pu);
			}
			else{
				pu.timer--;
			}
		}
		Monster[] monstre = m.toArray(new Monster[0]);
		for(Monster mon : monstre) {
			if (!mon.existe) {

				if(mon.drop()){
					mon.randomPowerUp();
				}
				hero.addExp(mon.xp);
				m.remove(mon);

				this.nbmonster = this.nbmonster - 1;

			}
		}

	}

	public void usePowerUp() {
		for (powerUp p : pU) {
			if ((p.getY() >= hero.getY()) && (p.getY() - hero.getTailley() <= hero.getY()) || (hero.getY() >= p.getY() && hero.getY() <= (p.getY() + p.getTexture().getHeight()))) {
				if ((p.getX() >= hero.getX()) && (p.getX() - hero.getTaillex() <= hero.getX()) || (hero.getX() >= p.getX() && hero.getX() <= (p.getX() + p.getTexture().getWidth()))) {

					p.use();
				}
			}
		}
	}

	public void GameUpdate(){
		shoot();

		for (Bullet bullH : bullet) {
			bullH.updateBullet();
		}
		for (Bullet bullM : bulletEN) {
			bullM.updateBullet();
		}
		for (Monster mon : m) {
			mon.updateall();
		}

		usePowerUp();
		hero.update();

	}


	public void GameState(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(this.state == GAME_RUNNING){
			Respawn();
			delete();
			GameUpdate();
			CollisionAll();


			dg.DrawALL();
		}
		else if(this.state == GAME_PAUSED){
			dg.DrawALL();
			dg.PausedMod();


		}
	}




	@Override
	public void render() {
		Status();
		GameState();
	}



}
