package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * This class is the parent class of all objects that is found on the game screen.
 * @authors Hasan Ege Tunç & Kerem Tekik
 * @date 24/12/2021
 * @version 1.0
 */
public class GameObject extends Sprite {
    //Properties
    private float x;
    private float y;
    private final World world;
    private Body body;
    private FixtureDef fixDef;
    private Fixture fix;

    /**
     * Constructs a game object.
     * @param text is the image that represents the object.
     * @param world is the world in which the game object is created
     */
    public GameObject(Texture text, World world) {
        super(text);
        this.world = world;
    }

    /**
     * Sets the texture of game object's position
     * @param x is the new x-coordinate
     * @param y is the new y-coordinate
     */
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //getters for x, y, world and body.
    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }

    public World getWorld() {
        return world;
    }

    public Body getBody() {
        return body;
    }

    /**
     * Creates a circular body of game objects to detect collisions.
     * @param bodyDefX corresponds to x-coordinates of the body definition, which will be created.
     * @param bodyDefY corresponds to y-coordinates of the body definition, which will be created.
     * @param radius corresponds to radius of game object's body.
     * @param ppm corresponds to preferred pixels-per-meter ratio.
     * @param type determines whether body will be kynematic, static or dynamic.
     * @param category determines the game object's type.
     * @param userData corresponds to the user data of game object to detect collisions.
     */
    public void createCircularBody(float bodyDefX, float bodyDefY, float radius, int ppm, BodyDef.BodyType type, boolean isSensor, short category, String userData) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set((bodyDefX)/ ppm, bodyDefY / ppm);

        body = getWorld().createBody(bodyDef);

        CircleShape shape = new CircleShape();
        shape.setRadius( radius / ppm);
        FixtureDef fixDef = new FixtureDef();

        fixDef.shape = shape;
        fixDef.density = 1;
        fixDef.isSensor = isSensor;

        fixDef.filter.categoryBits = category;
        fix = body.createFixture(fixDef);
        fix.setUserData(userData);
        shape.dispose();
    }

    /**
     * Creates a box body of game objects to detect collisions.
     * @param bodyDefX corresponds to x-coordinates of the body definition, which will be created.
     * @param bodyDefY corresponds to y-coordinates of the body definition, which will be created.
     * @param halfWidth corresponds to half of the width of game object's texture.
     * @param halfHeight corresponds to half of the height of game object's texture.
     * @param ppm corresponds to preferred pixels-per-meter ratio.
     * @param type determines whether body will be kynematic, static or dynamic.
     * @param category determines the game object's type.
     * @param userData corresponds to the user data of game object to detect collisions.
     */
    public void createBoxBody (float bodyDefX, float bodyDefY, float halfWidth, float halfHeight, int ppm, BodyDef.BodyType type, short category, String userData) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.position.set(bodyDefX / ppm, bodyDefY / ppm);
        body = getWorld().createBody(bodyDef);
        body.setFixedRotation( true );
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(halfWidth/ppm, halfHeight/ppm);
        fixDef = new FixtureDef();

        fixDef.shape = shape;
        fixDef.density = 1;
        fixDef.filter.categoryBits = category;

        fix = body.createFixture(fixDef);
        fix.setUserData(userData);
        shape.dispose();
    }

    /**
     * Updates the position of character by setting velocity vector to it.
     * @param movementVector is the new movement vector.
     * @param ppm is the pixel-per-meter ratio.
     */
    public void update(Vector2 movementVector, int ppm) {
        this.getBody().setLinearVelocity(movementVector);
        this.setPosition(getBody().getPosition().x * ppm, getBody().getPosition().y * ppm);
    }

    /**
     * draws any game object
     * @param batch to draw.
     */
    public void draw (SpriteBatch batch) {
        batch.draw(this,this.getX() - this.getWidth()/2, this.getY() - this.getHeight()/2);
    }

    /**
     * Moves game objects that goes off from screen to the end of the generated map; thereby map becomes infinite.
     * @param x is the new x-coordinate where the game object is going to be moved.
     */
    public void moveToTheEnd (float x) {
        this.getBody().setTransform(x/ GameScreen.PPM, getY()/ GameScreen.PPM, 0);
        setPosition(getBody().getPosition().x * GameScreen.PPM, getBody().getPosition().y * GameScreen.PPM);
    }

    /**
     * Moves game object to the up, especially for character
     * @param y is the new y-coordinate where the game object is going to be moved.
     */
    public void moveToTheUp ( float y){
        this.getBody().setTransform(getX() / GameScreen.PPM, y / GameScreen.PPM,0);
        setPosition(getBody().getPosition().x * GameScreen.PPM, getBody().getPosition().y * GameScreen.PPM);
    }

    /**
     * Returns fixDef
     * @return fixDef
     */
    public FixtureDef getFixDef() {
        return fixDef;
    }

    /**
     * Returns fixture of the game object's body
     * @return fix
     */
    public Fixture getFix() {
        return fix;
    }

}
