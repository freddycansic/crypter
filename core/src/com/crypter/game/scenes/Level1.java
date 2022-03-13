package com.crypter.game.scenes;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Man;
import com.crypter.game.entities.Player;
import com.crypter.game.util.Resources;

public class Level1 extends Scene {

	private Player player = Resources.player;
	private Man man = Resources.man;
	private OrthographicCamera camera = (OrthographicCamera) this.getViewport().getCamera();

	private TiledMap map;
	private TiledMapRenderer mapRenderer;
	private Array<RectangleMapObject> objectRects;
	private ArrayList<Rectangle> collidableRects = new ArrayList<Rectangle>();
	
	
	public Level1(Viewport viewport) {
		super(viewport);		
				
		map = new TmxMapLoader().load("tilemaps/tilemap.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		try {
			objectRects = map.getLayers().get("Object Layer 1").getObjects().getByType(RectangleMapObject.class);
			
			for (RectangleMapObject objectRect : objectRects) {
				collidableRects.add(objectRect.getRectangle());
			}			
			
		} catch (Exception e) {}
		
		
		this.addEntities(man, player);
//		this.setTileMap(Resources.tilemap1);
	}
	
	@Override
	public void update() {
		camera.position.set(player.getX(), player.getY(), camera.position.z);

	}

	@Override
	public void render() {
		// render tilemap
//		this.getTileMap().getMapRenderer().setView(camera);
//		this.getTileMap().getMapRenderer().render();
//		
		mapRenderer.setView(camera);
		mapRenderer.render();
		super.render();

	}

}
