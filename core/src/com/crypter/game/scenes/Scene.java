package com.crypter.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Scene extends Stage{

	public Scene() {
		Gdx.input.setInputProcessor(this);
	}
	
	public abstract void render();
	
//	public void addUIComponent(UIComponent component) {
//		this.addActor(component.getActor());
//	}
}
