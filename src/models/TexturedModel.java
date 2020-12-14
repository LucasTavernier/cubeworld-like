/*
 * Date : 27-01-2020 18:06:14
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package models;

import textures.ModelTexture;

/**
 * @author Lucas Tavernier
 */

public class TexturedModel {

	private RawModel rawModel;
	private ModelTexture texture;
	
	
	/**
	 * @param rawModel
	 * @param texture
	 */
	public TexturedModel(RawModel rawModel, ModelTexture texture) {
		super();
		this.rawModel = rawModel;
		this.texture = texture;
	}


	
	/**
	 * @return the rawModel
	 * @see RawModel
	 */
	public RawModel getRawModel() {
		return rawModel;
	}


	
	/**
	 * @return the texture
	 * @see ModelTexture
	 */
	public ModelTexture getTexture() {
		return texture;
	}
	
	
	
}
