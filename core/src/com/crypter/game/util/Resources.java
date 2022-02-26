package com.crypter.game.util;

import java.util.Random;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Resources {

	public static Random r;
	public static Camera camera;
	public static SpriteBatch batch;
	
	public Resources() {
		r = new Random();
		camera = new OrthographicCamera();
		batch = new SpriteBatch();
	}
	
	
	public void dispose() {
		batch.dispose();
	}
}
