package com.crypter.game.scenes;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Scene extends Stage{

	public Scene() {
	}
	
	public abstract void render();
	
//	public void addUIComponent(UIComponent component) {
//		this.addActor(component.getActor());
//	}
}
