package com.crypter.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.crypter.game.Main;
import com.crypter.game.WalkAnimation;
import com.crypter.game.util.Window;

public class Player extends Entity {

	private WalkAnimation walkAnimation;
	private float elapsedTime;
	private float moveSpeed = 4;
	private Animation<AtlasRegion> lastDirection;
	
	public Player() {
		super(Window.WIDTH/2, Window.HEIGHT/2);
		
		walkAnimation = new WalkAnimation(Gdx.files.internal("sprites/player/animations/walk/walkSpriteSheet.atlas"), 0.1f);
		lastDirection = walkAnimation.getDown();

		// set width and height to the dimensions of first frame in walk animation
		setHitbox(new Rectangle(x, y, walkAnimation.getDown().getKeyFrames()[0].getRegionWidth(), walkAnimation.getDown().getKeyFrames()[0].getRegionHeight()));
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
		elapsedTime += delta;
		
		for (Entity entity : Main.getCurrentScene().getEntities()) {
			if (this.hitbox.overlaps(entity.getHitbox()))
				entity.interact(this);
		}
	}

	@Override
	public void interact(Player player) {
		// will never be called
		System.err.println("Player interact method called...");
		System.exit(-1);
	}
	
}
