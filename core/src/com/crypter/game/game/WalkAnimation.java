package com.crypter.game.game;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class WalkAnimation {

	private TextureAtlas walkCycleAtlas;
	private Animation<AtlasRegion> leftAnimation, rightAnimation, upAnimation, downAnimation;
	
	public WalkAnimation(FileHandle textureLocation, float frameTime) {
		walkCycleAtlas = new TextureAtlas(textureLocation);
		
	    leftAnimation = new Animation<AtlasRegion>(frameTime,
	    		walkCycleAtlas.findRegion("leftIdle"),
	    		walkCycleAtlas.findRegion("leftWalkRight"),
	    		walkCycleAtlas.findRegion("leftWalkLeft")
	    );

	    rightAnimation = new Animation<AtlasRegion>(frameTime,
	    		walkCycleAtlas.findRegion("rightIdle"),
	    		walkCycleAtlas.findRegion("rightWalkRight"),
	    		walkCycleAtlas.findRegion("rightWalkLeft")
	    );
	    
	    upAnimation = new Animation<AtlasRegion>(frameTime,
	    		walkCycleAtlas.findRegion("upIdle"),
	    		walkCycleAtlas.findRegion("upWalkRight"),
	    		walkCycleAtlas.findRegion("upWalkLeft")
	    );
	    
	    downAnimation = new Animation<AtlasRegion>(frameTime,
	    		walkCycleAtlas.findRegion("downIdle"),
	    		walkCycleAtlas.findRegion("downWalkRight"),
	    		walkCycleAtlas.findRegion("downWalkLeft")
	    );
	    
	    for(AtlasRegion region : leftAnimation.getKeyFrames()) {
	    	if (region == null) System.err.println("gg");
	    }
	}
	
//	public AtlasRegion getLeftIdle() {
//		return leftAnimation.getKeyFrames()[0];
//	}
//	
//	public AtlasRegion getRightIdle() {
//		return rightAnimation.getKeyFrames()[0];
//	}
//	
//	public AtlasRegion getUpIdle() {
//		return upAnimation.getKeyFrames()[0];
//	}
//	
//	public AtlasRegion getDownIdle() {
//		return downAnimation.getKeyFrames()[0];
//	}
	
	public Animation<AtlasRegion> getLeft() {
		return leftAnimation;
	}
	
	public Animation<AtlasRegion> getRight() {
		return rightAnimation;
	}
	
	public Animation<AtlasRegion> getUp() {
		return upAnimation;
	}
	
	public Animation<AtlasRegion> getDown() {
		return downAnimation;
	}
}
