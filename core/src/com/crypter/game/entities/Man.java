package com.crypter.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.crypter.game.Hitbox;
import com.crypter.game.util.Resources;

public class Man extends Entity {

	int width = 50, height = 50;
	
	public Man(float x, float y) {
		super(x, y);
		
		setHitbox(new Hitbox(this));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {

	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		// draw man
		Resources.sr.begin(ShapeType.Filled);
		Resources.sr.setColor(Color.BLACK);
		Resources.sr.rect(x, y, width, height);
		Resources.sr.end();
	}

	@Override
	public void interact(Player player) {
		System.out.println("Touching!");
		
	}

}
