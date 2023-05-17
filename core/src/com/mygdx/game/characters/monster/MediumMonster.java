package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;

public class MediumMonster extends Monster {

    private int x;
    private int y;

    public MediumMonster(int x, int y){
    super(x,y,5, 5, 1, new Texture("dreadnaught.png"), 2 );

    }

    public void update(){}
    public void direction(){}

}
