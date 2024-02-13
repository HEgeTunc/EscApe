package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Class for a low ceiling.
 * @author Hasan Ege Tunç
 * @date 24/12/201
 */

public class LowCeiling extends Obstacle {
    /**
     * Constructs a low ceiling object
     * @param text corresponds to the image of low ceiling object
     * @param world corresponds to world, in which low ceiling is created.
     * @param x corresponds to x-coordinate of bottom-left position of the low-ceiling on the screen
     * @param y corresponds to y-coordinate of bottom-left position of the low-ceiling on the screen
     */
    public LowCeiling (Texture text, World world, int x, int y) {
        super(text, world);
        this.setPosition(x,y);
        this.createBoxBody(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2,
                this.getWidth()/2,getHeight()/2, GameScreen.PPM, BodyDef.BodyType.KinematicBody, GameScreen.LOW_CEILING,
                "Low Ceiling");
    }
}
