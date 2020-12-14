/*
 * Date : 10-02-2020 23:01:29
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;
import renderEngine.DisplayManager;
import terrains.Terrain;

/**
 * @author Lucas Tavernier
 */

public class Player extends Entity {
    
    private static final float RUN_SPEED = 20;
    private static final float TURN_SPEED = 100;
    private static final float GRAVITY = -65;
    private static final float JUMP_POWER = 20;
    
    private static final float TERRAIN_HEIGHT = 0;
    
    private float currentSpeed = 0;
    private float currentTurnSpeed = 0;
    private float upwardsSpeed = 0;
    
    private boolean isInAir = false;
    private int jumpCount = 0;
    
    /**
     * @param model
     * @param position
     * @param rotX
     * @param rotY
     * @param rotZ
     * @param scale
     */
    public Player(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
        super(model, position, rotX, rotY, rotZ, scale);
    }
    
    public void move(Terrain terrain) {
        checkInputs();
        super.increaseRotation(0, currentTurnSpeed * DisplayManager.getFrameTimeSeconds(), 0);
        
        float distance = currentSpeed * DisplayManager.getFrameTimeSeconds();
        float dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
        float dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));
        
        super.increasePosition(dx, 0, dz);
        upwardsSpeed += GRAVITY * DisplayManager.getFrameTimeSeconds();
        super.increasePosition(0, upwardsSpeed * DisplayManager.getFrameTimeSeconds(), 0);
        float terrainHeight = terrain.getHeightOfTheTerrain(super.getPosition().x, super.getPosition().z);
        if (super.getPosition().y < terrainHeight) {
            upwardsSpeed = 0;
            super.getPosition().y = terrainHeight;
            isInAir = false;
            jumpCount = 0;
        }
    }
    
    private void jump() {
        if (!isInAir || jumpCount < 2) {
            System.out.println(jumpCount);
            this.upwardsSpeed = JUMP_POWER;
            isInAir = true;
        }
    }
    
    private void checkInputs() {
        if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
            currentSpeed = RUN_SPEED;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            currentSpeed = -RUN_SPEED;
        } else {
            currentSpeed = 0;
        }
        
        if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
            currentTurnSpeed = TURN_SPEED;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            currentTurnSpeed = -TURN_SPEED;
        } else {
            currentTurnSpeed = 0;
        }
        
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
            jump();
            if (jumpCount < 2) {
                jumpCount++;
            }
        }
    }
}
