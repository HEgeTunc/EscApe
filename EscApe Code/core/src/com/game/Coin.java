package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Class for coins in a single player game
 * @author Hasan Ege Tunç
 *
 */
public class Coin extends GameObject {
    /**
     * Constructs a coin object
     * @param text corresponds to the image of coin object
     * @param world corresponds to world, in which coin is created.
     * @param x corresponds to x-coordinate of bottom-left position of the coin on the screen
     * @param y corresponds to y-coordinate of bottom-left position of the coin on the screen
     */
    public Coin (Texture text, World world, int x, int y) {
        super(text, world);
        this.setPosition(x,y);
        this.createCircularBody(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2,
                getHeight()/2, GameScreen.PPM, BodyDef.BodyType.KinematicBody, true, GameScreen.COIN, "Coin");
    }

    /**
     * Draws a coin object.
     * @param batch to draw coins
     */
    public void drawCoin(SpriteBatch batch) {
        batch.draw(this,this.getX() - this.getWidth()/2, this.getY() - this.getHeight()/2);
    }

}
