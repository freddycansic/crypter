package com.crypter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.crypter.game.entities.Entity;
import com.crypter.game.scenes.Level1;
import com.crypter.game.scenes.Scene;
import com.crypter.game.util.Debug;
import com.crypter.game.util.Resources;
import com.crypter.game.util.Window;

public class Main extends Game {
	
	private static Scene currentScene;
	private Resources rs;
	
	@Override
	public void create () {
		rs = new Resources();
		
		Main.setScene(new Level1(Window.VIEWPORT));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) Gdx.app.exit();
		
		// update
		currentScene.act(); // call act on each actor
		currentScene.update(); // call update on the scene
		currentScene.getViewport().apply();		

		// draw
		currentScene.render();
		
		Resources.sr.setProjectionMatrix(Main.getCurrentScene().getViewport().getCamera().combined);
		Resources.sr.begin(ShapeType.Line);
		Resources.sr.setColor(Color.RED);
		
		if (Debug.LEVEL > 0) {			
			// draw hitboxes around each entity
			for (Entity entity : currentScene.getEntities()) {
				Resources.sr.rect(entity.getHitbox().getX(), entity.getHitbox().getY(), entity.getHitbox().getWidth(), entity.getHitbox().getHeight());
			}
			
			// draw hitboxes around all solid cells in current tilemap
			for (Rectangle rect : currentScene.getTileMap().getCollidableRects()) {
				Resources.sr.rect(rect.x, rect.y, rect.width, rect.height);
			}
			
		}

		Resources.sr.end();	
	}
	
	@Override
	public void dispose () {
		rs.dispose();
	}

	public static void setScene(Scene scene) {
		Main.currentScene = scene;
		Gdx.input.setInputProcessor(scene);
		
		Debug.log("Scene", "Scene set to " + scene.getClass().getSimpleName());
	}
	
	public static Scene getCurrentScene() {
		return currentScene;
	}
}
