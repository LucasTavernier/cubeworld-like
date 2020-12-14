/*
 * Date : 31-01-2020 00:20:58
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package entities;

import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;

/**
 * @author Lucas Tavernier
 */

public class Entity {

	private TexturedModel model;
	private Vector3f position;
	private float rotX, rotY, rotZ;
	private float scale;
	
	/**
	 * @param model
	 * @param position
	 * @param rotX
	 * @param rotY
	 * @param rotZ
	 * @param scale
	 */
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super();
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}

	public void increaseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}
	
	/**
	 * @return the model
	 * @see TexturedModel
	 */
	public TexturedModel getModel() {
		return model;
	}

	
	/**
	 * @param model the model to set
	 * @see TexturedModel
	 */
	public void setModel(TexturedModel model) {
		this.model = model;
	}

	
	/**
	 * @return the position
	 * @see Vector3f
	 */
	public Vector3f getPosition() {
		return position;
	}

	
	/**
	 * @param position the position to set
	 * @see Vector3f
	 */
	public void setPosition(Vector3f position) {
		this.position = position;
	}

	
	/**
	 * @return the rotX
	 * @see float
	 */
	public float getRotX() {
		return rotX;
	}

	
	/**
	 * @param rotX the rotX to set
	 * @see float
	 */
	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	
	/**
	 * @return the rotY
	 * @see float
	 */
	public float getRotY() {
		return rotY;
	}

	
	/**
	 * @param rotY the rotY to set
	 * @see float
	 */
	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	
	/**
	 * @return the rotZ
	 * @see float
	 */
	public float getRotZ() {
		return rotZ;
	}

	
	/**
	 * @param rotZ the rotZ to set
	 * @see float
	 */
	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	
	/**
	 * @return the scale
	 * @see float
	 */
	public float getScale() {
		return scale;
	}

	
	/**
	 * @param scale the scale to set
	 * @see float
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}
	
}
