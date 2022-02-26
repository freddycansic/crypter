package com.crypter.game.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.crypter.game.GameObject;

public abstract class Entity extends GameObject {

	protected Action action;
	
	public Entity(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public abstract void draw(Batch batch, float parentAlpha);

	@Override
	public abstract void act(float delta);

	public void addAction(Action action) {
		this.action = action;
		super.addAction(action);
	}
	
	public void addListener(InputListener listener) {
		super.addListener(listener);
	}
}
