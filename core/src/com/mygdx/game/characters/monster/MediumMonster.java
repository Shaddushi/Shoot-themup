package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletEnnemi;

import java.util.Random;

public class MediumMonster extends Monster {

    public Random random = new Random();
    private int rand;

    public MediumMonster(int x, int y){
    super(x,y,5,3 , 1, new Texture("mediumMonster.png"), 2 , 100);
    this.rand = random.nextInt(20);

    }



    public Bullet tirer() {
        Bullet BE =new BulletEnnemi(this.x,this.y);
        System.out.println(this.x+ "   " +this.y);
        return BE;


    }
    public void update(){
        this.x += this.xspeed;
        this.y =this.y - this.yspeed;
        if (this.x <= 0){
            this.x = 0;
        }
        if(this.x >= Gdx.graphics.getWidth() - this.getTaillex()){
            this.x = Gdx.graphics.getWidth() - this.getTaillex();
        }
        if(this.y < (int)(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()*0.6) || y > Gdx.graphics.getHeight() - this.getTailley()){
            yspeed = -yspeed;
        }
        if(rand <= 0){
            this.xspeed = -this.xspeed;
            rand = random.nextInt(10);
        }
        else{
            rand--;
        }
    }


}
