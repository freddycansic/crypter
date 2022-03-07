package com.crypter.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.crypter.game.GameObject;
import com.crypter.game.Hitbox;
import com.crypter.game.Main;
import com.crypter.game.util.Resources;

public abstract class Entity extends GameObject {

	private Hitbox hitbox;
	
	public Entity(float x, float y) {
		super(x, y);
	}

	@Override
	public abstract void draw(Batch batch, float parentAlpha);

	@Override
	public void update(float delta) {
		hitbox.setX(this.getX() - Hitbox.HITBOX_WIDTH);
		hitbox.setY(this.getY() - Hitbox.HITBOX_WIDTH);
	}

	public abstract void interact(Player player);
	
	public void drawHitbox() {
		Resources.sr.setProjectionMatrix(Main.getCurrentScene().getViewport().getCamera().combined);
		Resources.sr.begin(ShapeType.Line);
		Resources.sr.setColor(Color.RED);
		Resources.sr.rect(hitbox.getX(), hitbox.getY(), hitbox.getWidth(), hitbox.getHeight());
		Resources.sr.end();
	}

	public Vector2 getVec2Pos() {
		return new Vector2(this.getX(), this.getY());
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
}
