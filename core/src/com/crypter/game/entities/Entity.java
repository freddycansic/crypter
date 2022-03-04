package com.crypter.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.crypter.game.GameObject;
import com.crypter.game.Hitbox;
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
		hitbox.setX(x - 15);
		hitbox.setY(y - 15);
	}

	public abstract void interact(Player player);
	
//	public void addAction(Action action) {
//		this.action = action;
//		super.addAction(action);
//	}
	
	public void addListener(InputListener listener) {
		super.addListener(listener);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	public void drawHitbox() {
		Resources.sr.begin(ShapeType.Line);
		Resources.sr.setColor(Color.RED);
		Resources.sr.rect(hitbox.getX(), hitbox.getY(), hitbox.getWidth(), hitbox.getHeight());
		Resources.sr.end();
	}
}
