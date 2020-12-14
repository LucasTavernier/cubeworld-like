/*
 * Date : 23-01-2020 19:52:31
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package models;

/**
 * @author Lucas Tavernier
 */

public class RawModel {

	private int vaoID;
	private int vertexCount;
	
	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}
	
	/**
	 * @return the vaoID
	 * @see int
	 */
	public int getVaoID() {
		return vaoID;
	}

	
	/**
	 * @return the vertexCount
	 * @see int
	 */
	public int getVertexCount() {
		return vertexCount;
	}
	
	
	
}
