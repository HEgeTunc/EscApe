package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Creates character and includes methods to move and animate character; in addition, creates body for character to
 * interact with other game objects.
 * @author Hasan Ege Tunç & Deniz Tuna Onguner
 * @version 1.0
 * @date 24/12/2021
 */
public class Character extends GameObject {
    //variables
    public Animation animatedCharacter;
    private boolean ableToJump = true;
    boolean isRotated = false;
    private Vector2 movementVector;

    /**
     * Constructs a character object
     * @param text corresponds to the image of character object
     * @param world corresponds to world, in which character is created.
     * @param x corresponds to x-coordinate of bottom-left position of the character on the screen
     * @param y corresponds to y-coordinate of bottom-left position of the character on the screen
     */
    public Character(Texture text, World world , int x, int y) {
        super(text, world);
        this.setPosition(x,y);
        this.createBoxBody(this.getX() + this.getWidth()/2, this.getY() + this.getHeight(),getWidth()/2,
                getHeight()/2, GameScreen.PPM, BodyDef.BodyType.DynamicBody, GameScreen.CHARACTER, "Character");
        this.animatedCharacter = new Animation();
    }

    /**
     * Moves character by setting its velocity vector.
     */
    public void moveCharacter() {
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if(!Profile.getWing().isActive()){
                Profile.getWing().activate();
            } //if wing power-up is activated
        }

        if (0 < this.getX() && this.getX() < 800 ) {
            setMovementVector(new Vector2(1.1F, 0));
        }
        else {
            setMovementVector(new Vector2(0.5f,0f));
        }//sets the velocity so that character does not go off the screen.
        update(getMovementVector(), GameScreen.PPM);

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && ableToJump) {
            setMovementVector(new Vector2(0.5F, 70F));
            update(movementVector, GameScreen.PPM);
            setAbleToJump(Profile.getWing().isActive());
        }
        slideCharacter();
        if (getIsRotated() && !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rotateCharacter(0);
        }
    }

    /**
     * Draws the character on the specified location
     * @param batch to draw the character
     */
    public void drawCharacter(SpriteBatch batch) {
        batch.draw(this, getX() - getWidth()/2, getY() - getHeight()/2);
    }

    /**
     * Overrides the createBoxBody(...) in game object to detect collisions.
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
     * Animates character while it is moving, by using animation class
     */
    public void animate() {
        if (!Gdx.input.isKeyPressed(Input.Keys.DOWN)) super.setTexture(animatedCharacter.getFrame());
        else super.setTexture(animatedCharacter.getSlidingFrame());
        this.setRegionWidth(animatedCharacter.getFrame().getWidth());
        this.setRegionHeight(animatedCharacter.getFrame().getHeight());
    }

    /**
     * Sets ableToJump property of character.
     * @param ableToJump is to be set as new jump ability
     */
    public void setAbleToJump(boolean ableToJump) {
        this.ableToJump = ableToJump;
    }

    public void slideCharacter() {
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rotateCharacter(Math.PI/2);
            this.setTexture(new Texture("Gifs/img_1.png"));
            isRotated = true;
        }
    }

    /**
     * Rotates character by specific angle passed as parameter.
     * @param angle corresponds to angle in terms of radians to rotate character.
     * This method is for sliding under obstacles.
     */
    public void rotateCharacter(double angle) {
        this.getBody().setTransform(this.getX() / GameScreen.PPM, this.getY()/ GameScreen.PPM, (float)angle);
        this.setPosition(getBody().getPosition().x * GameScreen.PPM, getBody().getPosition().y * GameScreen.PPM);
    }

    /**
     * This method returns whether character is rotated or not
     * @return isRotated
     */
    public boolean getIsRotated() {
        return isRotated;
    }

    /**
     * This method returns the movement vector of character
     * @return movementVector
     */
    public Vector2 getMovementVector() {
        return movementVector;
    }

    /**
     * Sets movement vector of the character
     * @param movementVector is a new movement vector of character.
     */
    public void setMovementVector(Vector2 movementVector) {
        this.movementVector = movementVector;
    }
}// end class
