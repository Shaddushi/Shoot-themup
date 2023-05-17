package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.weapon.Bullet;

public class MonstreJaponais extends Monster {

    public MonstreJaponais(int x, int y){
        super(x,y,5,3 , 1, new Texture("kamikaze.png"), 2 , 0,5);

    }

    public Bullet[] tirer(){
        return null;
    }

    public void update(int x){
        if(x < this.x){
            this.x += xspeed
        }
    }
}
