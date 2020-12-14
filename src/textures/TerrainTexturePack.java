/*
 * Date : 09-02-2020 22:21:22
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package textures;

/**
 * @author Lucas Tavernier
 */

public class TerrainTexturePack {
	
	private TerrainTexture backgroundTexture;
	private TerrainTexture rTexture;
	private TerrainTexture gTexture;
	private TerrainTexture bTexture;
	
	/**
	 * @param backgroundTexture
	 * @param rTexture
	 * @param gTexture
	 * @param bTexture
	 */
	public TerrainTexturePack(TerrainTexture backgroundTexture, TerrainTexture rTexture, TerrainTexture gTexture,
			TerrainTexture bTexture) {
		super();
		this.backgroundTexture = backgroundTexture;
		this.rTexture = rTexture;
		this.gTexture = gTexture;
		this.bTexture = bTexture;
	}

	
	/**
	 * @return the backgroundTexture
	 * @see TerrainTexture
	 */
	public TerrainTexture getBackgroundTexture() {
		return backgroundTexture;
	}

	
	/**
	 * @return the rTexture
	 * @see TerrainTexture
	 */
	public TerrainTexture getRedTexture() {
		return rTexture;
	}

	
	/**
	 * @return the gTexture
	 * @see TerrainTexture
	 */
	public TerrainTexture getGreenTexture() {
		return gTexture;
	}

	
	/**
	 * @return the bTexture
	 * @see TerrainTexture
	 */
	public TerrainTexture getBlueTexture() {
		return bTexture;
	}
	
	
}
