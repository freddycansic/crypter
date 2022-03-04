package com.crypter.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.crypter.game.Hitbox;
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

		setHitbox(new Hitbox(this, lastDirection.getKeyFrames()[0]));
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
			
//			this.drawHitbox();
			batch.draw(lastDirection.getKeyFrames()[0], x, y);
			return; // exit as to not draw moving animation
		}
//		this.drawHitbox();
		batch.draw(lastDirection.getKeyFrame(elapsedTime, true), x, y);

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
	}

	@Override
	public void interact(Player player) {
		// will never be called
		System.err.println("Player interact method called...");
		System.exit(-1);
	}
	
}
