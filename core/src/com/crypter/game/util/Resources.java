package com.crypter.game.util;

import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Resources {

	public static Random r;
	public static ShapeRenderer sr;
	
	public Resources() {
		r = new Random();
		sr = new ShapeRenderer();
		
	}
	
	
	public void dispose() {
		sr.dispose();
	}
}
