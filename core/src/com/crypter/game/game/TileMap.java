package com.crypter.game.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.crypter.game.util.Debug;

/**
 * Wrapper class for tiledmap
 * @author freddy
 *
 */
public final class TileMap {

	/**
	 * Tile size in pixels.
	 */
	public static final int TILE_SIZE = 32;
	
	private TiledMap map;
	private TiledMapRenderer mapRenderer;
	private TiledMapTileLayer collisionLayer;
	private Array<Rectangle> collidableRects = new Array<Rectangle>();
	
	public TileMap() {
		
	}
	
	public TileMap(String path) {
		map = new TmxMapLoader().load(path);
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		collisionLayer = (TiledMapTileLayer) map.getLayers().get("collision");
	
		// get all collidable objects from layer
		for (int x = 0; x < collisionLayer.getWidth(); x++) {
			for (int y = 0; y < collisionLayer.getHeight(); y++) {
				
				try {
					Cell currentCell = collisionLayer.getCell(x, y);
					
					if (currentCell.getTile().getProperties().containsKey("solid")) {
						collidableRects.add(new Rectangle(
								x * TileMap.TILE_SIZE,
								y * TileMap.TILE_SIZE,
								TileMap.TILE_SIZE,
								TileMap.TILE_SIZE
								));
						
						Debug.log("TileMap", "Collidable rect found at (" + x*TileMap.TILE_SIZE + ", " + y*TileMap.TILE_SIZE + ")");
					}
					
				} catch (Exception e) {
					
				}
			}
		}
		
		Debug.log("TileMap", "Number of collidable objects in tilemap = " + collidableRects.size);
		
	}
	
	public void dispose() {
		map.dispose();
	}

	public TiledMap getMap() {
		return map;
	}

	public TiledMapRenderer getMapRenderer() {
		return mapRenderer;
	}
	
	public TiledMapTileLayer getCollisionLayer() {
		return collisionLayer;
	}
	
	public Array<Rectangle> getCollidableRects() {
		return collidableRects;
	}
	
}
