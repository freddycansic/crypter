package com.crypter.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.crypter.game.entities.Entity;

public class Hitbox {

	private Rectangle rect;
	public static final float HITBOX_WIDTH = 12; // size in pixels to add around the entity 
	
	public Hitbox() {
		
	}
	
	public Hitbox(Entity entity) {
		this.rect = new Rectangle(
				entity.getX(),
				entity.getY(),
				entity.getWidth() + HITBOX_WIDTH * 2,
				entity.getHeight() + HITBOX_WIDTH * 2
		);
	}
	
	public Hitbox(float x, float y, float width, float height) {
		this.rect = new Rectangle(
				x, 
				y, 
				width + HITBOX_WIDTH * 2, 
				height + HITBOX_WIDTH * 2
		);
	}

	public Hitbox(Rectangle rect) {
		this.rect = rect;
	}
	
	// pass in entity to get pos of hitbox
	public Hitbox(Entity entity, AtlasRegion region) {
		this.rect = new Rectangle(
				entity.getX(),
				entity.getY(),
				region.getRegionWidth() + HITBOX_WIDTH * 2, 
				region.getRegionHeight() + HITBOX_WIDTH * 2
		);
	}
	
	public Hitbox(Entity entity, Texture texture) {
		this.rect = new Rectangle(
				entity.getX(),
				entity.getY(),
				texture.getWidth() + HITBOX_WIDTH * 2,
				texture.getHeight() + HITBOX_WIDTH * 2
		);
	}
	
	public boolean overlaps(Hitbox other) {
		return this.getRect().overlaps(other.getRect());
	}
	
	public boolean overlaps(Rectangle other) {
		return this.getRect().overlaps(other);
	}
	
	public void setPos(Vector2 pos) {
		this.rect.x = pos.x;
		this.rect.y = pos.y;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public void setX(float x) {
		this.rect.x = x;
	}
	
	public void setY(float y) {
		this.rect.y = y;
	}
	
	public float getX() {
		return rect.getX();
	}
	
	public float getY() {
		return rect.getY();
	}
	
	public float getWidth() {
		return rect.getWidth();
	}
	
	public float getHeight() {
		return rect.getHeight();
	}

}
