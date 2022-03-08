package com.crypter.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.crypter.game.Hitbox;
import com.crypter.game.Main;
import com.crypter.game.WalkAnimation;
import com.crypter.game.util.Resources;
import com.crypter.game.util.Window;

public class Player extends Entity {

	private WalkAnimation walkAnimation;
	private float elapsedTime;
	private float moveSpeed = 4;
	private Animation<AtlasRegion> lastDirection;
	private boolean colliding = false;
	
	public Player() {
		super(Window.WIDTH/2, Window.HEIGHT/2);
		
		walkAnimation = new WalkAnimation(Gdx.files.internal("entities/player/animations/walk/walkSpriteSheet.atlas"), 0.1f);
		lastDirection = walkAnimation.getDown();

		setHitbox(new Hitbox(this, lastDirection.getKeyFrames()[0]));
		
		// log function = y = 50log(-x+1000)-50
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		// if no buttons are being pressed then render the last facing direction's idle position
		if (!Gdx.input.isKeyPressed(Keys.W) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.S) && !Gdx.input.isKeyPressed(Keys.D)) {
			
			batch.draw(lastDirection.getKeyFrames()[0], this.getX(), this.getY());
			return; // exit as to not draw moving animation
		}
		
		batch.draw(lastDirection.getKeyFrame(elapsedTime, true), this.getX(), this.getY());
		colliding = false;
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		
		elapsedTime += delta;
		
		for (Entity entity : Main.getCurrentScene().getEntities()) {
			if (entity == this) continue; // dont check against itself TODO could get weird
			
			if (this.getHitbox().overlaps(entity.getHitbox())) 
				entity.interact(this);
		}
		
		// handle input
		if (Gdx.input.isKeyPressed(Keys.W)) {
			lastDirection = walkAnimation.getUp();
			this.setY(this.getY() + moveSpeed);
		}

		if (Gdx.input.isKeyPressed(Keys.A) && !colliding) {
			lastDirection = walkAnimation.getLeft();
			this.setX(this.getX() - moveSpeed);
		}

		if (Gdx.input.isKeyPressed(Keys.S) && !colliding) {
			lastDirection = walkAnimation.getDown();
			this.setY(this.getY() - moveSpeed);
		}

		if (Gdx.input.isKeyPressed(Keys.D) && !colliding) {
			lastDirection = walkAnimation.getRight();
			this.setX(this.getX() + moveSpeed);
		}
		
		// handle collision with tilemaps
		for (Rectangle rect : Main.getCurrentScene().getTileMap().getCollidableRects()) {
			
			if (new Rectangle(this.getHitbox().getX() + moveSpeed, this.getHitbox().getY(), this.getHitbox().getWidth(), this.getHitbox().getHeight()).overlaps(rect)) {
				this.setX(this.getX() - moveSpeed);
			}
			
			if (new Rectangle(this.getHitbox().getX() - moveSpeed, this.getHitbox().getY(), this.getHitbox().getWidth(), this.getHitbox().getHeight()).overlaps(rect)) {
				this.setX(this.getX() + moveSpeed);
			}
			
			if (new Rectangle(this.getHitbox().getX(), this.getHitbox().getY() + moveSpeed, this.getHitbox().getWidth(), this.getHitbox().getHeight()).overlaps(rect)) {
				this.setY(this.getY() - moveSpeed);
			}
			
			if (new Rectangle(this.getHitbox().getX(), this.getHitbox().getY() - moveSpeed, this.getHitbox().getWidth(), this.getHitbox().getHeight()).overlaps(rect)) {
				this.setY(this.getY() + moveSpeed);
			}
		}
		
	}

	@Override
	public void interact(Player player) {
		// will never be called
		System.err.println("Player interact method called...");
		System.exit(-1);
	}

	@Override
	public String toString() {
		return getVec2Pos().toString();
	}
	
}
