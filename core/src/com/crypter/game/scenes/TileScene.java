package com.crypter.game.scenes;

import java.util.ArrayList;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Entity;

public abstract class TileScene extends Scene {

	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public TileScene(Viewport viewport) {
		super(viewport);
	}

	
	
}
