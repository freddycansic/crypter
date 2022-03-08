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

	public Level1(Viewport viewport) {
		super(viewport);		
		
		player = new Player();
		man = new Man(3*Window.WIDTH/4, 3*Window.HEIGHT/4);
		
		this.addEntities(man, player);
		this.setTileMap(Resources.tilemap1);
	}
	
	@Override
	public void update() {
		camera.position.set(player.getX(), player.getY(), camera.position.z);

	}

	@Override
	public void render() {
		// render tilemap
		this.getTileMap().getMapRenderer().setView(camera);
		this.getTileMap().getMapRenderer().render();
		
		super.render();

	}

}
