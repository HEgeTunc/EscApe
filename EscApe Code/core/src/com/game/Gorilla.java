package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
/**
 * Class for gorilla
 * @authors Hasan Ege Tunç & Deniz Tuna Onguner
 * @date 24/12/2021
 * @version 1.0
 *
 */
public class Gorilla extends GameObject {

    public Animation animatedCharacter;
    /**
     * Constructs a gorilla object
     * @param text corresponds to the image of gorilla object
     * @param world corresponds to world, in which gorilla is created.
     * @param x corresponds to x-coordinate of bottom-left position of the gorilla on the screen
     * @param y corresponds to y-coordinate of bottom-left position of the gorilla on the screen
     */
    public Gorilla(Texture text, World world , int x, int y) {
        super(text, world);
        this.setPosition(x,y);
        this.createBoxBody(this.getX() + this.getWidth()/2, this.getY() + this.getHeight(),getWidth()/2,
                getHeight()/2, GameScreen.PPM, BodyDef.BodyType.DynamicBody, GameScreen.CHARACTER, "Gorilla");
        this.animatedCharacter = new Animation();
    }

    /**
     * Draws gorilla
     * @param batch to draw gorilla
     */
    public void drawGorilla(SpriteBatch batch) {
        batch.draw(this, getX() - getWidth()/2, getY() - getHeight()/2);
    }

    /**
     * Overrides the method in super class to add functionality to detect collisions.
     * @param bodyDefX corresponds to x-coordinates of the body definition, which will be created.
     * @param bodyDefY corresponds to y-coordinates of the body definition, which will be created.
     * @param halfWidth corresponds to half of the width of game object's texture.
     * @param halfHeight corresponds to half of the height of game object's texture.
     * @param ppm corresponds to preferred pixels-per-meter ratio.
     * @param type determines whether body will be kynematic, static or dynamic.
     * @param category determines the game object's type.
     * @param userData corresponds to the user data of game object to detect collisions.
     */
    public void createBoxBody(float bodyDefX, float bodyDefY, float halfWidth, float halfHeight, int ppm, BodyDef.BodyType type, short category, String userData) {
        super.createBoxBody(bodyDefX, bodyDefY, halfWidth, halfHeight, ppm, type, category, userData);
        this.getFixDef().filter.maskBits = GameScreen.GROUND | GameScreen.COIN | GameScreen.COLUMN | GameScreen.LOW_CEILING;
    }

    /**
     * Animates gorilla
     */
    public void animate() {
        super.setTexture(animatedCharacter.getGorillaFrame());
        this.setRegionWidth(animatedCharacter.getGorillaFrame().getWidth());
        this.setRegionHeight(animatedCharacter.getGorillaFrame().getHeight());
    }

    /**
     * Relocates gorilla such that it will start the game in a correct position.
     * @param ground is the ground according to which gorilla is located.
     */
    public void relocateGorilla(Ground ground) {
        setPosition(ground.getWidth() + ground.getX(),
                ground.getY() + ground.getHeight() + this.getHeight() / 2);
        getBody().setTransform(this.getX() / GameScreen.PPM, this.getY() / GameScreen.PPM, 0);
    }

    /**
     * Enables gorilla to imitate character
     * @param ch represents character to be imitated.
     */
    public void imitate(Character ch) {
        if (!Profile.getWing().isActive() && !Profile.getShield().isActive()) {
            update(new Vector2( 0.75f * ch.getMovementVector().x, ch.getMovementVector().y), GameScreen.PPM);
        }
        else {
            update(new Vector2(0.75f * ch.getMovementVector().x, 0), GameScreen.PPM);
            setPosition(this.getWidth(), this.getY());
            getBody().setTransform(this.getX() / GameScreen.PPM, this.getY() / GameScreen.PPM, 0);
        }
        if (this.getX() < -this.getWidth()) {
            setPosition(this.getX() + this.getWidth(), this.getY());
            getBody().setTransform(this.getX() / GameScreen.PPM, this.getY() / GameScreen.PPM, 0);
        }
    }
}
