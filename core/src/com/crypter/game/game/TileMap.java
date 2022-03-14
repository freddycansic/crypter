package com.crypter.game.game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

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
	
	public TileMap(String path) {
		map = new TmxMapLoader().load(path);
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		collisionLayer = (TiledMapTileLayer) map.getLayers().get("collision");
		
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
	
}
