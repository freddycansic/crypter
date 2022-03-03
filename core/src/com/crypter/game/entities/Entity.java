package com.crypter.game.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.crypter.game.GameObject;

public abstract class Entity extends GameObject {

	protected Action action;
	protected Rectangle hitbox;
	
	public Entity(float x, float y) {
		super(x, y);
	}

	@Override
	public abstract void draw(Batch batch, float parentAlpha);

	@Override
	public abstract void act(float delta);

	public abstract void interact(Player player);
	
	public void addAction(Action action) {
		this.action = action;
		super.addAction(action);
	}
	
	public void addListener(InputListener listener) {
		super.addListener(listener);
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	protected void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}
}
