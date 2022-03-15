package com.crypter.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.crypter.game.Main;
import com.crypter.game.game.Attack;
import com.crypter.game.game.Hitbox;
import com.crypter.game.game.WalkAnimation;
import com.crypter.game.util.Debug;
import com.crypter.game.util.Window;

public class Player extends Entity {

	private WalkAnimation walkAnimation;
	private float elapsedTime;
	private float moveSpeed = 400;
	private Animation<AtlasRegion> lastDirection;
	private Array<Attack> attacks;
	
	public Player() {
		super(Window.WIDTH/2, Window.HEIGHT/2 + 20);

		attacks = new Array<Attack>();
		attacks.add(
			new Attack("punch"),
			new Attack("kick"),
			new Attack("leaping pentastrike"),
			new Attack("cough")
		);
		
		walkAnimation = new WalkAnimation(Gdx.files.internal("entities/player/animations/walk/walkSpriteSheet.atlas"), 0.1f);
		lastDirection = walkAnimation.getDown();

		setHitbox(new Hitbox(this, lastDirection.getKeyFrames()[0]));
		
		this.setPosition(Window.WIDTH - lastDirection.getKeyFrames()[0].getRegionWidth() / 2,
				Window.HEIGHT - lastDirection.getKeyFrames()[0].getRegionHeight() / 2);
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
	}

	@Override
	public void update(float delta) {		
		Debug.log(this, "Updated");
		elapsedTime += delta;
		
		for (Entity entity : Main.getCurrentScene().getEntities()) {
			if (entity == this) continue; // don't check against itself TODO could get weird
			
			if (this.getHitbox().overlaps(entity.getHitbox())) {
				entity.interact(this);				
				return;
			}
		}
		
		handleKeyboardMovement(delta);	
		handleTilemapCollision(delta);

		super.update(delta);
	}

	private void handleTilemapCollision(float delta) {
		
		for (Rectangle rect : Main.getCurrentScene().getTileMap().getCollidableRects()) {
			if (this.getHitbox().overlaps(rect)) {
				Debug.log("Collision", "Player colliding with tile at (" + rect.x + ", " + rect.y + ")");
			}
		}
		
	}

	private void handleKeyboardMovement(float delta) {

		if (Gdx.input.isKeyPressed(Keys.W)) {
			lastDirection = walkAnimation.getUp();
			this.setY(this.getY() + moveSpeed * delta);
		}

		if (Gdx.input.isKeyPressed(Keys.A)) {
			lastDirection = walkAnimation.getLeft();
			this.setX(this.getX() - moveSpeed * delta);
		}

		if (Gdx.input.isKeyPressed(Keys.S)) {
			lastDirection = walkAnimation.getDown();
			this.setY(this.getY() - moveSpeed * delta);
		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			lastDirection = walkAnimation.getRight();
			this.setX(this.getX() + moveSpeed * delta);
		}

	}

	@Override
	public void interact(Player player) {
		// should never be called
		System.err.println("Player interact method called...");
		System.exit(-1);
	}

	@Override
	public String toString() {
		return getVec2Pos().toString();
	}
	
	public WalkAnimation getWalkAnimation() {
		return this.walkAnimation;
	}
	
	public Array<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(Array<Attack> attacks) {
		this.attacks = attacks;
	}
}
