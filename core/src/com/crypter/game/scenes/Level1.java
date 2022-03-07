package com.crypter.game.scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Man;
import com.crypter.game.entities.Player;
import com.crypter.game.util.Resources;
import com.crypter.game.util.Window;

public class Level1 extends Scene {

	private Player player;
	private Man man;
	private OrthographicCamera camera = (OrthographicCamera) this.getViewport().getCamera();
	
	private TiledMap map;
	private TiledMapRenderer mapRenderer;

	MapLayer objectLayer;
	Array<RectangleMapObject> objectRects;
	
	public Level1(Viewport viewport) {
		super(viewport);
		
		map = new TmxMapLoader().load("tilemaps/tilemap.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		
		player = new Player();
		man = new Man(3*Window.WIDTH/4, 3*Window.HEIGHT/4);
		
		this.addEntities(man, player);
		
		objectLayer = map.getLayers().get(2);
		objectRects = objectLayer.getObjects().getByType(RectangleMapObject.class);
		
	}
	
	@Override
	public void update() {
		camera.position.set(player.getX(), player.getY(), camera.position.z);

	}

	@Override
	public void render() {
		// render tilemap
		mapRenderer.setView(camera);
		mapRenderer.render();
		
		super.render();

		Resources.sr.begin(ShapeType.Line);
		for (RectangleMapObject rectObj : objectRects) {
			Rectangle objectRect = rectObj.getRectangle();
			
			if (player.getHitbox().getRect().overlaps(objectRect)) {
				System.out.println("Overlapping");
			}
			
			System.out.println("Player:\t(" + player.getHitbox().getX() + ", " + player.getHitbox().getY() + ")\t" + player.getHitbox().getWidth() + " " + player.getHitbox().getHeight());
			System.out.println("Rect:\t(" + objectRect.x + ", " + objectRect.y + ")\t" + objectRect.width + " " + objectRect.height);
			System.out.println();
			
			Resources.sr.rect(objectRect.x, objectRect.y, objectRect.width, objectRect.height);
		}
		Resources.sr.end();
		
		

	}

}
