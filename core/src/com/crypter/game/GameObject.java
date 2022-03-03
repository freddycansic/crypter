package com.crypter.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {

	protected float x, y, width, height;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
//	public GameObject(float x, float y, float width, float height, Action action) {
//		this.x = x;
//		this.y = y;
//		this.width = width;
//		this.height = height;
//	
//		this.addAction(action);
//		setBounds(x, y, width, height); // create bounding box
//		this.setTouchable(true);
//	}
	
	@Override
	public abstract void draw(Batch batch, float parentAlpha);

	@Override
	public abstract void act(float delta);

//	public void setTouchable(boolean touchable) {
//		if (touchable) 
//			this.setTouchable(Touchable.enabled);
//		else
//			this.setTouchable(Touchable.disabled);
//	}
}
