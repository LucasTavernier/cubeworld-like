/*
 * Date : 04-02-2020 23:32:50
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package entities;

import org.lwjgl.util.vector.Vector3f;

/**
 * @author Lucas Tavernier
 */

public class Light {

	private Vector3f position;
	private Vector3f colour;
	
	/**
	 * @param position
	 * @param colour
	 */
	public Light(Vector3f position, Vector3f colour) {
		super();
		this.position = position;
		this.colour = colour;
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
	 * @return the colour
	 * @see Vector3f
	 */
	public Vector3f getColour() {
		return colour;
	}

	
	/**
	 * @param colour the colour to set
	 * @see Vector3f
	 */
	public void setColour(Vector3f colour) {
		this.colour = colour;
	}
	
	
	
}
