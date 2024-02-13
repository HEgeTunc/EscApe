package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Class for obstacles
 * @author Hasan Ege Tunç
 * @date 24/12/2021
 */
public class Obstacle extends GameObject {
    /**
     * Creates an obstacle
     * @param text corresponds to the image of the obstacle
     * @param world corresponds to the world in which obstacle is created
     */
    Obstacle(Texture text, World world) {
        super(text, world);
    }
}
