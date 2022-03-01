package com.crypter.game.entities;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.crypter.game.WalkAnimation;

public class Player extends Entity {

	private enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	private WalkAnimation walkAnimation;
	private float elapsedTime;
	private float moveSpeed = 3;
	private Direction lastDirection = Direction.DOWN;
	
	public Player(float x, float y) {
		super(x, y, 9, 20);

		walkAnimation = new WalkAnimation(Gdx.files.internal("sprites/player/animations/walk/walkSheet.atlas"), 0.1f);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		
		// handle input
		if (Gdx.input.isKeyPressed(Keys.W)) {
			batch.draw(walkAnimation.getUp().getKeyFrame(elapsedTime, true), x, y);
			lastDirection = Direction.UP;
			this.y += moveSpeed;
		}

		if (Gdx.input.isKeyPressed(Keys.A)) {
			batch.draw(walkAnimation.getLeft().getKeyFrame(elapsedTime, true), x, y);
			lastDirection = Direction.LEFT;
			this.x -= moveSpeed;
		}
				
		if (Gdx.input.isKeyPressed(Keys.S)) {
			batch.draw(walkAnimation.getDown().getKeyFrame(elapsedTime, true), x, y);
			lastDirection = Direction.DOWN;
			this.y -= moveSpeed;
		}
		
		if (Gdx.input.isKeyPressed(Keys.D)) {
			batch.draw(walkAnimation.getRight().getKeyFrame(elapsedTime, true), x, y);
			lastDirection = Direction.RIGHT;
			this.x += moveSpeed;
		}
		
		// ew
		// if no buttons are being pressed then render the last facing direction's idle position
		if (!Gdx.input.isKeyJustPressed(Keys.W) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.S) && !Gdx.input.isKeyPressed(Keys.D)) {
			switch (lastDirection) {
				case UP:
					batch.draw(walkAnimation.getUpIdle(), x, y);
					break;
				case DOWN:
					batch.draw(walkAnimation.getDownIdle(), x, y);
					break;
				case LEFT:
					batch.draw(walkAnimation.getLeftIdle(), x, y);
					break;
				case RIGHT:
					batch.draw(walkAnimation.getRightIdle(), x, y);
					break;
			}
		}
	}

	@Override
	public void act(float delta) {
		
	}
	
}
