package com.crypter.game.util;

import java.util.Random;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Resources {

	public static Random r;
	public static Camera camera;
	public static ShapeRenderer sr;
	
	public Resources() {
		r = new Random();
		camera = new OrthographicCamera();
		sr = new ShapeRenderer();
	}
	
	
	public void dispose() {
		sr.dispose();
	}
}
