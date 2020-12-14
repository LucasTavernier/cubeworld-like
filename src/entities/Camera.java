/*
 * Date : 31-01-2020 00:52:28
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

/**
 * @author Lucas Tavernier
 */

public class Camera {

	private final float CONST_DISTANCE_FROM_PLAYER = 25;
	private float distanceFromPlayer = 25;
	private float angleAroundThePlayer = 0;
	private float angleSaved = 0;
	
	private final float MOUSE_SPEED = 1;

	private Vector3f position = new Vector3f(0, 0, 0);
	private float pitch = 15; //rotation around x axis
	private float yaw;   //rotation around y axis
	private float roll;  //rotation around z axis

	private Player player;

	public Camera(Player player) {
		this.player = player;
	}

	public void move() {
		calculateZoom();
		calculatePitch();
		calculateAngleAroundPlayer();

		float horizontalDistance = calculateHorizontalDistance();
		float verticalDistance = calculateVerticalDistance();
		calculateCameraPosition(horizontalDistance, verticalDistance);
	}

	private float calculateHorizontalDistance() {
		return (float) (distanceFromPlayer * Math.cos(Math.toRadians(pitch)));
	}

	private float calculateVerticalDistance() {
		return (float) (distanceFromPlayer * Math.sin(Math.toRadians(pitch)));
	}

	private void calculateCameraPosition(float horizontalDistance, float verticalDistance) {
		position.y = player.getPosition().y + verticalDistance+2.5f;

		float theta = player.getRotY() + angleAroundThePlayer;
		float offsetX = (float) (horizontalDistance * Math.sin(Math.toRadians(theta)));
		float offsetZ = (float) (horizontalDistance * Math.cos(Math.toRadians(theta)));

		position.x = player.getPosition().x - offsetX;
		position.z = player.getPosition().z - offsetZ;

		this.yaw = 180 - theta;
	}

	/**
	 * @return the position
	 * @see Vector3f
	 */
	public Vector3f getPosition() {
		return position;
	}


	/**
	 * @return the pitch
	 * @see float
	 */
	public float getPitch() {
		return pitch;
	}


	/**
	 * @return the yaw
	 * @see float
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * @return the roll
	 * @see float
	 */
	public float getRoll() {
		return roll;
	}

	private void calculateZoom() {
		float zoomLevel = Mouse.getDWheel()*0.05f;
		distanceFromPlayer -= zoomLevel;
		if(distanceFromPlayer <= 10){
			distanceFromPlayer = 10;
		}
		if(distanceFromPlayer > 55){
			distanceFromPlayer = 55;
		}
	}

	private void calculatePitch() {
		if(Mouse.isButtonDown(1)) {
			float pitchChange = Mouse.getDY() * 0.1f;
			pitch -= pitchChange;
			if(pitch <= 5) {
				this.pitch = 5;
			}

			if(pitch > 90) {
				pitch = 90;
			}
		}
	}

	private void calculateAngleAroundPlayer() {
		if(Mouse.isButtonDown(0)) {
			float angleChange = Mouse.getDX() * 0.3f;
			angleAroundThePlayer -= angleChange;
			if(angleAroundThePlayer >= 180){
				angleAroundThePlayer = 180;
			}
			if(angleAroundThePlayer <= -180){
				angleAroundThePlayer = -180;
			}
		}
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_C) {
					angleSaved = angleAroundThePlayer;
					angleAroundThePlayer = 180;
				}
			}
			else {
				if (Keyboard.getEventKey() == Keyboard.KEY_C) {
					angleAroundThePlayer = angleSaved;
				}
			}
		}
	}
}
