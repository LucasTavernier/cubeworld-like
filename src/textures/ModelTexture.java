/*
 * Date : 27-01-2020 18:05:05
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package textures;

/**
 * @author Lucas Tavernier
 */

public class ModelTexture {

	private int textureID;
	private float shineDamper = 1;
	private float reflectivity = 0;
	
	private boolean hasTransparency = false;
	private boolean useFakeLighting = false;
	
	public ModelTexture(int id) {
		this.textureID = id;
	}
	
	/**
	 * @return the useFakeLighting
	 * @see boolean
	 */
	public boolean isUseFakeLighting() {
		return useFakeLighting;
	}



	
	/**
	 * @param useFakeLighting the useFakeLighting to set
	 * @see boolean
	 */
	public void setUseFakeLighting(boolean useFakeLighting) {
		this.useFakeLighting = useFakeLighting;
	}



	/**
	 * @return the hasTransparency
	 * @see boolean
	 */
	public boolean isHasTransparency() {
		return hasTransparency;
	}
	
	/**
	 * @param hasTransparency the hasTransparency to set
	 * @see boolean
	 */
	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}


	/**
	 * @return the textureID
	 * @see int
	 */
	public int getTextureID() {
		return textureID;
	}


	public float getShineDamper() {
		return shineDamper;
	}


	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}


	public float getReflectivity() {
		return reflectivity;
	}


	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}
	
}
