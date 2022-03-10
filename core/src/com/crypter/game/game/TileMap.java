package com.crypter.game.game;

import java.util.ArrayList;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * Wrapper class for tiledmap
 * @author freddy
 *
 */
public final class TileMap {

	private TiledMap map;
	private TiledMapRenderer mapRenderer;
	private Array<RectangleMapObject> objectRects;
	private ArrayList<Rectangle> collidableRects = new ArrayList<Rectangle>();
	
	public TileMap(String path) {
		map = new TmxMapLoader().load(path);
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		try {
			objectRects = map.getLayers().get("object").getObjects().getByType(RectangleMapObject.class);
			
			for (RectangleMapObject objectRect : objectRects) {
				collidableRects.add(objectRect.getRectangle());
			}			
			
		} catch (Exception e) {}
		
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
	
	/**
	 * Get collidable rectangles form the object layer in the the TiledMap
	 * @return the collidable rectangles
	 */
	public ArrayList<Rectangle> getCollidableRects() {
		return collidableRects;
	}
	
}
