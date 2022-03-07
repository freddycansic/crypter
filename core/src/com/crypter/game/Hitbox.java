package com.crypter.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.crypter.game.entities.Entity;

public class Hitbox {

	private Rectangle rect;
	private float x, y, width, height;
	public static final float HITBOX_WIDTH = 15; // size in pixels to add around the entity 
	
	public Hitbox() {
		
	}
	
	public Hitbox(Entity entity) {
		this.x = entity.getX();
		this.y = entity.getY();
		this.width = entity.getWidth() + HITBOX_WIDTH * 2;
		this.height = entity.getHeight() + HITBOX_WIDTH * 2;
		
		this.rect = new Rectangle(x, y, width, height);
	}
	
	public Hitbox(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width + HITBOX_WIDTH * 2;
		this.height = height + HITBOX_WIDTH * 2;

		this.rect = new Rectangle(x, y, width, height);
	}

	public Hitbox(Rectangle rect) {
		this.x = rect.x;
		this.y = rect.y;
		this.width = rect.width + HITBOX_WIDTH * 2;
		this.height = rect.height + HITBOX_WIDTH * 2;

		this.rect = rect;
	}
	
	// pass in entity to get pos of hitbox
	public Hitbox(Entity entity, AtlasRegion region) {
		this.x = entity.getX();
		this.y = entity.getY();
		this.width = region.getRegionWidth() + HITBOX_WIDTH * 2;
		this.height = region.getRegionHeight() + HITBOX_WIDTH * 2;
		
		this.rect = new Rectangle(x, y, width, height);
	}
	
	public Hitbox(Entity entity, Texture texture) {
		this.x = entity.getX();
		this.y = entity.getY();
		this.width = texture.getWidth() + HITBOX_WIDTH * 2;
		this.height = texture.getHeight() + HITBOX_WIDTH * 2;
		
		this.rect = new Rectangle(x, y, width, height);
	}
	
	public boolean overlaps(Hitbox other) {
		return this.getRect().overlaps(other.getRect());
	}
	
	public boolean overlaps(Rectangle other) {
		return this.getRect().overlaps(other);
	}
	
	public void setPos(Vector2 pos) {
		this.x = pos.x;
		this.y = pos.y;
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
