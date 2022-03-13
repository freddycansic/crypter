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
	public static TileMap tilemap1;
	public static Player player;
	public static Man man;
	public static Skin skin;
	
	public Resources() {
		r = new Random();
		sr = new ShapeRenderer();	
		skin = new Skin(Gdx.files.internal("skins/crypter/uiskin.json"));
		
		player = new Player();
		man = new Man(3*Window.WIDTH/4, 3*Window.HEIGHT/4);

	}
	
	public void dispose() {
		sr.dispose();
		tilemap1.dispose();
		skin.dispose();
	}
}
