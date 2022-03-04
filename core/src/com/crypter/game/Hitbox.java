package com.crypter.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.crypter.game.entities.Entity;

public class Hitbox {

	private Rectangle rect;
	private float x, y, width, height;
	
	public Hitbox() {
		
	}
	
	public Hitbox(Entity entity) {
		this.x = entity.getX();
		this.y = entity.getY();
		this.width = entity.getWidth() + 30;
		this.height = entity.getHeight() + 30;
		
		this.rect = new Rectangle(x, y, width, height);
	}
	
	public Hitbox(float x, float y, float width, float height) {
		this.rect = new Rectangle(x, y, width, height);
		this.x = rect.getX();
		this.y = rect.getY();
		this.width = rect.getWidth() + 30;
		this.height = rect.getHeight() + 30;
	}

	public Hitbox(Entity entity, AtlasRegion region) {
		this.x = entity.getX();
		this.y = entity.getY();
		this.width = region.getRegionWidth() + 30;
		this.height = region.getRegionHeight() + 30;
		
		this.rect = new Rectangle(x, y, width, height);
	}
	
	public boolean overlaps(Hitbox other) {
		System.out.println(other.getRect().toString());
		return this.getRect().overlaps(other.getRect());
	}
	
	public Rectangle getRect() {
		return rect;
	}

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
