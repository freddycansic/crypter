package com.crypter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.ScreenUtils;
import com.crypter.game.scenes.Level1;
import com.crypter.game.scenes.Scene;
import com.crypter.game.util.Resources;

public class Main extends Game {
	
	private static Scene currentScene;
	private Resources rs;
	
	@Override
	public void create () {
		rs = new Resources();
		
		Main.setScene(new Level1());
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		currentScene.act();
		currentScene.render();
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) Gdx.app.exit();
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
