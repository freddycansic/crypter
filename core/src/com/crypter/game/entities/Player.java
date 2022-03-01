package com.crypter.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.crypter.game.WalkAnimation;

public class Player extends Entity {

	private WalkAnimation walkAnimation;
	private float elapsedTime;
	private float moveSpeed = 4;
	private Animation<AtlasRegion> lastDirection;
	
	public Player(float x, float y) {
		super(x, y, 9, 20);

		walkAnimation = new WalkAnimation(Gdx.files.internal("sprites/player/animations/walk/walkSpriteSheet.atlas"), 0.1f);
		lastDirection = walkAnimation.getDown();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		// handle input
		if (Gdx.input.isKeyPressed(Keys.W)) {
			lastDirection = walkAnimation.getUp();
			this.y += moveSpeed;
		}

		if (Gdx.input.isKeyPressed(Keys.A)) {
			lastDirection = walkAnimation.getLeft();
			this.x -= moveSpeed;
		}
				
		if (Gdx.input.isKeyPressed(Keys.S)) {
			lastDirection = walkAnimation.getDown();
			this.y -= moveSpeed;
		}
		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			lastDirection = walkAnimation.getRight();
			this.x += moveSpeed;
		}
		
		// if no buttons are being pressed then render the last facing direction's idle position
		if (!Gdx.input.isKeyPressed(Keys.W) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.S) && !Gdx.input.isKeyPressed(Keys.D)) {
			
			batch.draw(lastDirection.getKeyFrames()[0], x, y);
			return; // exit as to not draw moving animation
		}
		
		batch.draw(lastDirection.getKeyFrame(elapsedTime, true), x, y);

	}

	@Override
	public void act(float delta) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		
	}
	
}
