/*
 * Date : 23-01-2020 19:18:55
 * Copyright : lucas.tavernierpro@outlook.fr
 */

package engineTester;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Player;
import models.RawModel;
import models.TexturedModel;
import objConverter.ModelData;
import objConverter.OBJFileLoader;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;

/**
 * @author Lucas Tavernier
 */

public class MainGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		List<Entity> entities = new ArrayList<Entity>();
		Keyboard.enableRepeatEvents(true);


		/********TERRAIN TEXTURE PACK*******/
		TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grassTexture2"));
		TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("dirtTexture"));
		TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("grassFlowerTexture"));
		TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("pathTexture"));

		TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
		TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendmap2"));
		/***********************************/

		ModelData boxData = OBJFileLoader.loadOBJ("box");
		RawModel boxRawModel = loader.loadToVAO(boxData.getVertices(), boxData.getTextureCoords(),
				boxData.getIndices(), boxData.getNormals());
		TexturedModel boxModel = new TexturedModel(boxRawModel, new ModelTexture(loader.loadTexture("boxTexture")));

		ModelData treeData = OBJFileLoader.loadOBJ("tree");
		RawModel treeRawModel = loader.loadToVAO(treeData.getVertices(), treeData.getTextureCoords(),
				treeData.getIndices(), treeData.getNormals());
		TexturedModel treeModel = new TexturedModel(treeRawModel, new ModelTexture(loader.loadTexture("treeTexture")));


		ModelData grassData= OBJFileLoader.loadOBJ("grassModel");
		RawModel grassRawModel = loader.loadToVAO(grassData.getVertices(), grassData.getTextureCoords(),
				grassData.getIndices(), grassData.getNormals());
		TexturedModel grassModel = new TexturedModel(grassRawModel,new ModelTexture(loader.loadTexture("grassModelTexture")));
		grassModel.getTexture().setHasTransparency(true);
		grassModel.getTexture().setUseFakeLighting(true);
		TexturedModel flowerModel = new TexturedModel(grassRawModel,new ModelTexture(loader.loadTexture("flowerTexture")));
		flowerModel.getTexture().setHasTransparency(true);
		flowerModel.getTexture().setUseFakeLighting(true);


		ModelData fernData= OBJFileLoader.loadOBJ("fern");
		RawModel fernRawModel = loader.loadToVAO(fernData.getVertices(), fernData.getTextureCoords(),
				fernData.getIndices(), fernData.getNormals());
		TexturedModel fernModel = new TexturedModel(fernRawModel,new ModelTexture(loader.loadTexture("fernTexture")));
		fernModel.getTexture().setHasTransparency(true);


		ModelData lowPolyTreeData= OBJFileLoader.loadOBJ("lowPolyTree");
		RawModel lowPolyTreeRawModel = loader.loadToVAO(lowPolyTreeData.getVertices(), lowPolyTreeData.getTextureCoords(),
				lowPolyTreeData.getIndices(), lowPolyTreeData.getNormals());
		TexturedModel lowPolyTreeModel = new TexturedModel(lowPolyTreeRawModel,new ModelTexture(loader.loadTexture("lowPolyTreeTexture")));


		ModelData playerData = OBJFileLoader.loadOBJ("player");
		RawModel playerRawModel = loader.loadToVAO(playerData.getVertices(), playerData.getTextureCoords(),
				playerData.getIndices(), playerData.getNormals());
		TexturedModel playerModel = new TexturedModel(playerRawModel, new ModelTexture(loader.loadTexture("playerTexture")));

		Random random = new Random();
		Light light = new Light(new Vector3f(-20000,20000,-20000),new Vector3f(1,1,1));

		List<Terrain> terrains = new ArrayList<Terrain>();
		Terrain terrain1 = new Terrain(0,0,loader,texturePack,blendMap, "heightmap");
		terrains.add(terrain1);

		Player player = new Player(playerModel, new Vector3f(0, 0, 0), 0, 0, 0, 0.4f);
		entities.add(player);

		for(Terrain terrain : terrains) {
			for(int i=0;i<100;i++){
				if(i%1 == 0) {
					float x = random.nextFloat() * (Terrain.getSize()) + terrain.getX();
					float z = random.nextFloat() * (Terrain.getSize()) + terrain.getZ();
					float y = terrain.getHeightOfTheTerrain(x,z);
					entities.add(new Entity(fernModel,new Vector3f(x,y,z),0,random.nextFloat()*360,0,(0.3f*random.nextFloat())+0.2f));
				}
				if(i%5 == 0) {
					float x = random.nextFloat() * (Terrain.getSize()) + terrain.getX();
					float z = random.nextFloat() * (Terrain.getSize()) + terrain.getZ();
					float y = terrain.getHeightOfTheTerrain(x,z);
					entities.add(new Entity(treeModel,new Vector3f(x,y,z), 0, random.nextFloat()*360, 0, (4f*random.nextFloat())+2f));

					x = random.nextFloat() * (Terrain.getSize()) + terrain.getX();
					z = random.nextFloat() * (Terrain.getSize()) + terrain.getZ();
					y = terrain.getHeightOfTheTerrain(x, z);
					entities.add(new Entity(lowPolyTreeModel,new Vector3f(x,y,z),0,random.nextFloat()*360,0,(0.4f*random.nextFloat())+0.4f ));
				}
			}
		}

		Camera camera = new Camera(player);   
		MasterRenderer renderer = new MasterRenderer();

		while(!Display.isCloseRequested()) {
			camera.move();
			player.move(terrain1);
			for(Terrain terrain : terrains) {
				renderer.processTerrain(terrain);
			}
			for(Entity entity : entities) {
				renderer.processEntity(entity);
			}
			renderer.render(light, camera);

			DisplayManager.updateDisplay();
		}
		renderer.cleanUP();
		loader.cleanUP();
		DisplayManager.closeDisplay();
	}
}
