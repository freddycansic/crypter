package com.crypter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
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
		
		Main.setScene(new Level1(Window.VIEWPORT));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);
		Gdx.gl.glScissor(Window.WIDTH/2-100, Window.HEIGHT/2-100, 200, 200);
		
		
		// update
		currentScene.act(); // call act on each actor
		currentScene.update(); // call update on the scene
		currentScene.getViewport().apply();
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) Gdx.app.exit();

		// render
		currentScene.render();
		
		// draw hitboxes
		Resources.sr.setProjectionMatrix(Main.getCurrentScene().getViewport().getCamera().combined);
		Resources.sr.begin(ShapeType.Line);
		Resources.sr.setColor(Color.RED);

		
		Resources.sr.flush();
		
		Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
		for (Entity entity : currentScene.getEntities()) {
			Resources.sr.rect(entity.getHitbox().getX(), entity.getHitbox().getY(), entity.getHitbox().getWidth(), entity.getHitbox().getHeight());
		}
		
		for (Rectangle rect : Resources.tilemap1.getCollidableRects()) {
			Resources.sr.rect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
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
	}
	
	public static Scene getCurrentScene() {
		return currentScene;
	}
}
