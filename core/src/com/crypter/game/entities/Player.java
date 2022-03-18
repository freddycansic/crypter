package com.crypter.game.entities;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.crypter.game.Main;
import com.crypter.game.game.Attack;
import com.crypter.game.game.Hitbox;
import com.crypter.game.util.Window;

public class Player extends Entity {

	private enum Direction {
		LEFT, RIGHT, UP, DOWN
	}

	private float elapsedTime;
	private float moveSpeed = 400;
	private Array<Attack> attacks;
	
	private TextureAtlas walkCycleAtlas;
	private Direction lastDirection = Direction.DOWN;
	private AtlasRegion frame;
	private Vector2 movement = new Vector2(0, 0);
	
	private HashMap<Direction, Animation<AtlasRegion>> walkAnimation;
	
	public Player() {
		super(Window.WIDTH/2, Window.HEIGHT/2 + 20);

		walkCycleAtlas = new TextureAtlas(Gdx.files.internal("entities/player/animations/walk/walkSpriteSheet.atlas"));
	    
		walkAnimation = new HashMap<Direction, Animation<AtlasRegion>>();
		
		walkAnimation.put(Direction.LEFT, new Animation<AtlasRegion>(0.1f,
	    		walkCycleAtlas.findRegion("leftIdle"),
	    		walkCycleAtlas.findRegion("leftWalkRight"),
	    		walkCycleAtlas.findRegion("leftWalkLeft")
	    ));
		
		walkAnimation.put(Direction.RIGHT, new Animation<AtlasRegion>(0.1f,
	    		walkCycleAtlas.findRegion("rightIdle"),
	    		walkCycleAtlas.findRegion("rightWalkRight"),
	    		walkCycleAtlas.findRegion("rightWalkLeft")
	    ));
		
		walkAnimation.put(Direction.UP, new Animation<AtlasRegion>(0.1f,
	    		walkCycleAtlas.findRegion("upIdle"),
	    		walkCycleAtlas.findRegion("upWalkRight"),
	    		walkCycleAtlas.findRegion("upWalkLeft")
	    ));
		
		walkAnimation.put(Direction.DOWN, new Animation<AtlasRegion>(0.1f,
	    		walkCycleAtlas.findRegion("downIdle"),
	    		walkCycleAtlas.findRegion("downWalkRight"),
	    		walkCycleAtlas.findRegion("downWalkLeft")
	    ));
	    
		frame = walkAnimation.get(Direction.DOWN).getKeyFrames()[0];
		
		attacks = new Array<Attack>();
		attacks.add(
			new Attack("punch"),
			new Attack("kick"),
			new Attack("leaping pentastrike"),
			new Attack("cough")
		);

		setHitbox(new Hitbox(this, walkAnimation.get(Direction.DOWN).getKeyFrames()[0]));
		
		this.setPosition(Window.WIDTH - this.getHitbox().getWidth() / 2,
				Window.HEIGHT - this.getHitbox().getHeight() / 2);
		// log function = y = 50log(-x+1000)-50
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
			
		batch.draw(frame, this.getX(), this.getY());
		this.setPos(this.getX() + movement.x, this.getY() + movement.y);
		
	}

	@Override
	public void update(float delta) {		
		elapsedTime += delta;
		movement.x = 0;
		movement.y = 0;

		// entity collision
		for (Entity entity : Main.getCurrentScene().getEntities()) {
			if (entity == this) continue; // don't check against itself TODO could get weird
			
			if (this.getHitbox().overlaps(entity.getHitbox())) {
				entity.interact(this);				
				return;
			}
		}
		
		// W
		if (Gdx.input.isKeyPressed(Keys.W)) {
			if (movementWillCauseCollision(0, moveSpeed * delta)) {
				frame = walkAnimation.get(Direction.UP).getKeyFrames()[0];
			} else {
				frame = walkAnimation.get(Direction.UP).getKeyFrame(elapsedTime, true);
				movement.y += moveSpeed * delta;
			}
			
			lastDirection = Direction.UP;
		}
		
		// A
		if (Gdx.input.isKeyPressed(Keys.A)) {
			if (movementWillCauseCollision(-moveSpeed * delta, 0)) {
				frame = walkAnimation.get(Direction.LEFT).getKeyFrames()[0];
				
			} else {
				frame = walkAnimation.get(Direction.LEFT).getKeyFrame(elapsedTime, true);
				movement.x -= moveSpeed * delta;
			}
			
			lastDirection = Direction.LEFT;
		}
		
		// S
		if (Gdx.input.isKeyPressed(Keys.S)) {
			if (movementWillCauseCollision(0, -moveSpeed * delta)) {
				frame = walkAnimation.get(Direction.DOWN).getKeyFrames()[0];
			} else {
				frame = walkAnimation.get(Direction.DOWN).getKeyFrame(elapsedTime, true);
				movement.y -= moveSpeed * delta;
			}
			
			lastDirection = Direction.DOWN;
		}
		
		// D
		if (Gdx.input.isKeyPressed(Keys.D)) {
			if (movementWillCauseCollision(moveSpeed * delta, 0)) {
				frame = walkAnimation.get(Direction.RIGHT).getKeyFrames()[0];
			} else {
				frame = walkAnimation.get(Direction.RIGHT).getKeyFrame(elapsedTime, true);
				movement.x += moveSpeed * delta;
			}
			
			lastDirection = Direction.RIGHT;
		}
		
		// if forward and backward or left and right are being pressed
		if (Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.S)) {
			frame = walkAnimation.get(Direction.DOWN).getKeyFrames()[0];
			movement.x = 0;
			movement.y = 0;
		}

		// if no keys are being pressed
		if (!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.S) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.W)) {
			frame = walkAnimation.get(lastDirection).getKeyFrames()[0];
		}

		
		// move hitbox
		super.update(delta);
	}

	private boolean movementWillCauseCollision(float xMovement, float yMovement) {
		Rectangle newRectPos = new Rectangle(this.getX() + xMovement, this.getY() + yMovement, this.getHitbox().getWidth(), this.getHitbox().getHeight());
		for (Rectangle collidableRect : Main.getCurrentScene().getTileMap().getCollidableRects()) {
			if (newRectPos.overlaps(collidableRect)) {
				return true;
			}
		}
		
		return false;
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
	
	public Array<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(Array<Attack> attacks) {
		this.attacks = attacks;
	}
}
