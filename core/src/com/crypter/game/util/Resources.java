package com.crypter.game.util;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.crypter.game.entities.Man;
import com.crypter.game.entities.Player;
import com.crypter.game.game.TileMap;

public class Resources {

	public static Random r;
	public static ShapeRenderer sr;
	public static TileMap tilemap;
	public static Player player;
	public static Man man;
	public static Skin skin;
	
	public Resources() {
		r = new Random();
		sr = new ShapeRenderer();	
		skin = new Skin(Gdx.files.internal("skins/crypter/uiskin.json"));
		tilemap = new TileMap("tilemaps/tilemap.tmx");

		player = new Player();
		man = new Man(3*Window.WIDTH/4, 3*Window.HEIGHT/4);

	}
	
	public void dispose() {
		sr.dispose();
		tilemap.dispose();
		skin.dispose();
	}
}
