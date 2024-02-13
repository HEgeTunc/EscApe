package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Class for column obstacles in a game.
 * @author Hasan Ege Tunç
 */
public class Column extends Obstacle {
    /**
     * Constructs a column object
     * @param text corresponds to the image of column object
     * @param world corresponds to world, in which column is created.
     * @param x corresponds to x-coordinate of bottom-left position of the column on the screen
     * @param y corresponds to y-coordinate of bottom-left position of the column on the screen
     */
    public Column (Texture text, World world, int x, int y) {
        super(text, world);
        this.setPosition(x,y);
        this.createBoxBody(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2,
                this.getWidth()/2,getHeight()/2, GameScreen.PPM, BodyDef.BodyType.KinematicBody,
                GameScreen.COLUMN, "Column");
    }
}
