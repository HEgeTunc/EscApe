package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

/**
 * This class creates complex ground, meaning the cluster of grounds that are consecutively ordered without spaces.
 * @author Hasan Ege Tunç
 * @date 24/12/2021
 */

public class ComplexGround {
    //variables
    private int width;
    public ArrayList<Ground> grounds;

    /**
     * Creates complex ground
     * @param x is the x-coordinate of the bottom-left corner of the first ground.
     * @param world is the world in which complex ground is created
     * @param length is the length of the complex ground on x-axis.
     */
    public ComplexGround (int x, World world, int length) {
        this.grounds = new ArrayList<>();
        int height;
        //z is the random number to determine the height of the complex ground
        int z = (int) (Math.random() * 3 );
        for (int i=0; i < length ; i++) {
            if (z == 0 ) height = 0;
            else if (z == 1) height = -1 * Ground.HEIGHT_DIFFERENCE;
            else height = -2 * Ground.HEIGHT_DIFFERENCE;
            Ground ground =new Ground (new Texture("House.jpeg"), world, x, height - i );
            x = x + (int) ground.getWidth();
            width = width + (int) ground.getWidth();
            grounds.add(ground);
        }
    }

    /**
     * Draws complex ground.
     * @param batch to draw complex ground.
     */
    public void drawComplexGround (SpriteBatch batch) {
        for (Ground ground : grounds) {
            batch.draw(ground,ground.getX() - ground.getWidth()/2,
                    ground.getY() - ground.getHeight()/2);

        }
    }

    /**
     * Moves complex grounds
     */
    public void moveComplexGround () {
        for (Ground ground : grounds) {
            ground.moveGround();
        }
    }

    /**
     * Adds complex grounds to the end of the screen that goes off from screen.
     * @param x to the x-coordinates of the place on which complex ground to be moved.
     */
    public void moveToTheEnd (float x) {
        for (Ground ground : grounds) {
            ground.getBody().setTransform(x / GameScreen.PPM, ground.getY() / GameScreen.PPM, 0);
            ground.setPosition(ground.getBody().getPosition().x * GameScreen.PPM,
                    ground.getBody().getPosition().y * GameScreen.PPM);
            x = x + ground.getWidth();
        }
    }

    /**
     * Returns the width of the complex ground
     * @return width
     */
    public int getWidth() {
        return width;
    }
}
