package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.Enemy.BulletMediumEnnemi;

import java.util.Random;

public class MediumMonster extends Monster {

    public Random random = new Random();
    private int rand;



    public MediumMonster(int x, int y, MyGdxGame gdx){
    super(x,y,5,3 , 10*(Math.round(gdx.nbvague/10)+1), new Texture("mediumMonster.png"), 2*(Math.round(gdx.nbvague/10)+1) , 100,0.02,gdx,23);

    this.rand = random.nextInt(20);

    }



    public Bullet[] tirer() {
        Bullet[] BE = new Bullet[3];
        BE[0] = new BulletMediumEnnemi(this.x,this.y, -3, -10);
        BE[1] = new BulletMediumEnnemi(this.x + (texture.getWidth()/3),this.y, 0, -10);
        BE[2] = new BulletMediumEnnemi(this.x + (texture.getWidth()/2),this.y, 3, -10);
        return BE;


    }
    public void update(){
        this.x += this.xspeed;
        this.y =this.y - this.yspeed;
        if (this.x <= this.getTaillex() - texture.getWidth()/2){
            this.x = Gdx.graphics.getWidth() - this.getTaillex() + texture.getWidth()/2;
        }
        if(this.x >= Gdx.graphics.getWidth() - this.getTaillex() + texture.getWidth()/2 ){
            this.x = this.getTaillex() - texture.getWidth()/2;
        }
        if(this.y < (int)(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()*0.6) || y > Gdx.graphics.getHeight() - this.getTailley()){
            yspeed = -yspeed;
        }
        if(rand <= 0){
            int rd = random.nextInt(2);
            if(rd == 1){
                this.xspeed = -this.xspeed;
            }

            rand = random.nextInt(20,30);
        }
        else{
            rand--;
        }
    }


}
