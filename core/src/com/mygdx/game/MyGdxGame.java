package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

	public ShapeRenderer shapeLife;
	public ShapeRenderer shapeShield;
	public ShapeRenderer shapeNoLife;
	public ShapeRenderer shapeExp;
	public ShapeRenderer shapeNoExp;

	public Hero hero;
	public Texture heroimg;

	public Texture monsterimg;

	public Texture bulletimg;

	protected Texture background;
	public SpriteBatch batch;

	public int nbmonsterlast;
	public int nbmonster;

	public Music menuMusic;

	public Music Honteux;
	public LinkedHashSet<BulletHero> bullet = new LinkedHashSet<>();

	public LinkedHashSet<Bullet> bulletEN = new LinkedHashSet<>();
	public LinkedHashSet<Monster> m = new LinkedHashSet<>();

	public LinkedHashSet<powerUp> pU = new LinkedHashSet<powerUp>();

	public LinkedHashSet<powerUp> pUInUse = new LinkedHashSet<powerUp>();
	@Override
	public void create() {
		bulletimg = new Texture("laserGreen.png");
		nbmonster = 5;
		nbmonsterlast = nbmonster;
		for (int i = 0; i < nbmonster; i++) {
			m.add(new SmallMonster(Gdx.graphics.getWidth() - ((i + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() * 0.3),this));
		}


		//m.add(new MediumMonster(700,850,this));
		//m.add(new MonstreJaponais(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), this));
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("Shreksophone.mp3"));
		Honteux = Gdx.audio.newMusic(Gdx.files.internal("Honteux.mp3"));
		menuMusic.setLooping(true);
		//menuMusic.play();
		shapeNoLife = new ShapeRenderer();
		shapeLife = new ShapeRenderer();
		shapeNoExp = new ShapeRenderer();
		shapeExp = new ShapeRenderer();
		shapeShield = new ShapeRenderer();
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
					System.out.println(mon.getLife() + "      " + mon.existe + "         " + bullH.getDegat()) ;
					mon.toucher(bullH.getDegat());
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


	public void Respawn(){
		if(nbmonster == 1) {
			nbmonster = (int) Math.round(nbmonsterlast * 1.2);
			nbmonsterlast = nbmonster;
			for (int i = 0; i < (3 * nbmonster) / 4; i++) {
				m.add(new SmallMonster(Gdx.graphics.getWidth() - ((i + 1) * (Gdx.graphics.getWidth() / (nbmonster + 1))), Gdx.graphics.getHeight()-100, this));
			}
			for (int j = 0; j < nbmonster / 4; j++) {
				m.add(new MediumMonster((Gdx.graphics.getWidth() / 10) * random.nextInt(0, 10), Gdx.graphics.getHeight()-100, this));
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
		for(powerUp up: pU){
			up.draw(batch);
		}
		int i = 1;
		for(powerUp up: pUInUse){
			batch.draw(up.getTexture(),100*i,100);
			i++;
		}

		batch.end();

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

	public void ExpBar(){
		shapeNoExp = new ShapeRenderer();
		shapeExp = new ShapeRenderer();
		shapeNoExp.begin(ShapeRenderer.ShapeType.Filled);
		shapeExp.begin(ShapeRenderer.ShapeType.Filled);
		shapeExp.setColor(61/255f, 197/255f, 242/255f,1);
		shapeNoExp.setColor(0/255f, 255/255f, 205/255f,1);

		shapeNoExp.rect((int)(
						(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/5) -50)), 70 +(int)(Gdx.graphics.getHeight()/20)
				, (float)(Gdx.graphics.getWidth()/5), (int)(Gdx.graphics.getHeight()/50)
		);



			shapeExp.rect((int) (
							(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 5) - 50))
					, 70 +(int)(Gdx.graphics.getHeight()/20)
					, (int) Math.round(((float) (Gdx.graphics.getWidth() / 5) * ((float) hero.getExp() / (float) hero.getMaxExp())))
					, (int) (Gdx.graphics.getHeight() / 50)
			);



		shapeNoExp.end();
		shapeExp.end();
	}
	public void HealthBar(){
		shapeNoLife = new ShapeRenderer();
		shapeLife = new ShapeRenderer();
		shapeShield = new ShapeRenderer();
		shapeNoLife.begin(ShapeRenderer.ShapeType.Filled);
		shapeLife.begin(ShapeRenderer.ShapeType.Filled);
		shapeShield.begin(ShapeRenderer.ShapeType.Filled);
		shapeLife.setColor(0, 255, 0,1);
		shapeNoLife.setColor(255, 0, 0,1);
		shapeShield.setColor(0,0,255,1);
		shapeNoLife.rect((int)(
						(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth()/3) -50)), 50
				, (float)(Gdx.graphics.getWidth()/3), (int)(Gdx.graphics.getHeight()/20)
		);

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
		shapeShield.rect((int) (
						(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 3) - 50))
				, 50
				, (int) Math.round(((float) (Gdx.graphics.getWidth() / 3) * ((float) hero.shield / (float) hero.getMaxlife())))
				, (int) (Gdx.graphics.getHeight() / 20)
		);

		shapeNoLife.end();
		shapeLife.end();
		shapeShield.end();
	}




	@Override
	public void render() {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Respawn();
		usePowerUp();
		hero.update();
		shoot();
		CollisionAll();
		delete();
		dessine();
		HealthBar();
		ExpBar();


	}



}
