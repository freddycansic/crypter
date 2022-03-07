package com.crypter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.crypter.game.entities.Entity;
import com.crypter.game.entities.Player;

public class Background extends Entity {

	private Texture bg = new Texture(Gdx.files.internal("uvTest.jpg"));
	
	public Background(float x, float y) {
		super(x, y);
		
		setHitbox(new Hitbox(x, y, bg.getWidth(), bg.getHeight()));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(bg, getX(), getY());

	}

	@Override
	public void interact(Player player) {
		
	}

}
