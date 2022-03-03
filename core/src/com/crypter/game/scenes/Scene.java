package com.crypter.game.scenes;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.crypter.game.entities.Entity;

public abstract class Scene extends Stage {

	private ArrayList<Entity> entities;
	
	public Scene() {
		
	}
	
	public abstract void render();
	
//	public void addUIComponent(UIComponent component) {
//		this.addActor(component.getActor());
//	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
}
