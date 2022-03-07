package com.crypter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.crypter.game.entities.Entity;
import com.crypter.game.scenes.Level1;
import com.crypter.game.scenes.Scene;
import com.crypter.game.util.Resources;
import com.crypter.game.util.Window;

public class Main extends Game {
	
	private static Scene currentScene;
	private Resources rs;
	
	@Override
	public void create () {
		rs = new Resources();
		
		Main.setScene(new Level1(new FitViewport(Window.WIDTH, Window.HEIGHT)));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		
		// update
		currentScene.act(); // call act on each actor
		currentScene.update(); // call update on the scene
		currentScene.getViewport().apply();
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) Gdx.app.exit();

		// render
		currentScene.render();
		for (Entity entity : currentScene.getEntities()) {
			entity.drawHitbox();
		}
	}
	
	@Override
	public void dispose () {
		rs.dispose();
	}

	public static void setScene(Scene scene) {
		Main.currentScene = scene;
		Gdx.input.setInputProcessor(scene);
	}
	
	public static Scene getCurrentScene() {
		return currentScene;
	}
}
