package com.mygdx.game.characters.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.weapon.Bullet;
import com.mygdx.game.weapon.BulletEnnemi;

import java.util.Random;

public class MediumMonster extends Monster {

    private int x;
    private int y;
    public Random random = new Random();
    private int rand;

    public MediumMonster(int x, int y){
    super(x,y,20, -3, 1, new Texture("mediumMonster.png"), 2 , 10);
    this.rand = random.nextInt(10);
    }

    public void update(){
        this.x += xspeed;
        this.y += yspeed;
        if (this.x <= 0){
            this.x = 0;
        }
        if(this.x >= Gdx.graphics.getWidth() - this.getTaillex()){
            this.x = Gdx.graphics.getWidth() - this.getTaillex();
        }
        if(this.y <= 500){
            this.yspeed = 0;
        }
        if(rand <= 0){
            this.x = -this.x;
            rand = random.nextInt(10);
        }
        else{
            rand--;
        }
    }

    public Bullet tirer() {
        Bullet BE =new BulletEnnemi(this.x,this.y);
        System.out.println(this.x+ "   " +this.y);
        return BE;

    }


}
