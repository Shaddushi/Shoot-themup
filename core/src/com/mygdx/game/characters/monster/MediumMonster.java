package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletMediumEnnemi;

import java.util.Random;

public class MediumMonster extends Monster {

    public Random random = new Random();
    private int rand;



    public MediumMonster(int x, int y, MyGdxGame gdx){
    super(x,y,5,3 , 1, new Texture("mediumMonster.png"), 2 , 100,2,gdx);

    this.rand = random.nextInt(20);

    }



    public Bullet[] tirer() {
        Bullet[] BE = new Bullet[2];
        BE[0] = new BulletMediumEnnemi(this.x,this.y);
        BE[1] = new BulletMediumEnnemi(this.x + texture.getWidth(),this.y);
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
