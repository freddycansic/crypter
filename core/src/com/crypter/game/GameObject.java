package com.crypter.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {

	protected float x, y, width, height;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public GameObject(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public abstract void draw(Batch batch, float parentAlpha);

	@Override
	public void act(float delta) {
		update(delta);
	}
	// i dont like the method name "act"
	public abstract void update(float delta);
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
}
