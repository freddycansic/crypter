package com.crypter.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.crypter.game.util.Resources;

public class Player extends Entity {

	private Texture texture;
	
	public Player(float x, float y, Texture texture) {
		super(x, y, texture.getWidth(), texture.getHeight());
		this.texture = texture;
		this.setTouchable(true);
		
		this.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttons) {
				System.out.println("Hello world");
				return true;
			}
		});
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		Resources.batch.begin();
		Resources.batch.draw(texture, x, y);
		Resources.batch.end();
	}

	@Override
	public void act(float delta) {
		
	}

	
	
}
