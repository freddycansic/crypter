package com.crypter.game.util;

import java.util.Random;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Resources {

	public static Random r;
	public static ShapeRenderer sr;
	public static TileMap tilemap1;
	
	public Resources() {
		r = new Random();
		sr = new ShapeRenderer();	
		tilemap1 = new TileMap("tilemaps/tilemap.tmx");
	}
	
	
	public void dispose() {
		sr.dispose();
		tilemap1.dispose();
	}
}
