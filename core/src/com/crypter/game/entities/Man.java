package com.crypter.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.crypter.game.Hitbox;

public class Man extends Entity {

	private Texture texture;
	
	public Man(float x, float y) {
		super(x, y);
		
		texture = new Texture(Gdx.files.internal("entities/man/textures/man.png"));
		
		setHitbox(new Hitbox(this, texture));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(texture, getX(), getY());
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	
		getHitbox().setPos(getVec2Pos());
	}

	@Override
	public void interact(Player player) {
		System.out.println("Touching!");
		
	}

}
