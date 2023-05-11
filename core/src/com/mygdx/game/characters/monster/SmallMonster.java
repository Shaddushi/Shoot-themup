package com.mygdx.game.characters.monster;

import com.badlogic.gdx.graphics.Texture;

public class SmallMonster extends Monster{
    private final Texture  smallMonsterimg = new Texture("dreadnaught.png");
    public SmallMonster(int x, int y, Texture smallMonsterimg){
        super(x,y,3, 1, smallMonsterimg, 2 );

    }
}
