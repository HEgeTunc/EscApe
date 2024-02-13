package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Class for ground
 * @author Hasan Ege Tunç
 */
public class Ground extends GameObject {
    public static final int HEIGHT_DIFFERENCE = 20;
    /**
     * Constructs a ground object
     * @param text corresponds to the image of ground object
     * @param world corresponds to world, in which ground is created.
     * @param x corresponds to x-coordinate of bottom-left position of the ground on the screen
     * @param y corresponds to y-coordinate of bottom-left position of the ground on the screen
     */
    public Ground (Texture text, World world, int x, int y) {
        super(text, world);
        this.setPosition(x,y);
        createBoxBody(this.getX() + this.getWidth()/2,this.getY() + this.getHeight()/2, getWidth()/2, getHeight()/2,
                GameScreen.PPM, BodyDef.BodyType.KinematicBody, GameScreen.GROUND, "Ground");
    }

    /**
     * Moves to the ground so that the game proceeds.
     */
    public void moveGround() {
        update(new Vector2(-3,0), GameScreen.PPM);
    }
}
