package com.crypter.game.scenes;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Entity;

public abstract class Scene extends Stage {

	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Scene(Viewport viewport) {
		super(viewport);
	}
	
	public Scene() {
		
	}
	
	public abstract void update();
	
	public void render() {
		this.draw();
	}
	
	// cool
	public void add(Actor... actors) {
		for (Actor actor : actors) {
			super.addActor(actor);
		}
	}	
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void addEntities(Entity... entities) {
		
		for (Entity entity : entities)
			this.entities.add(entity);
			
		add(entities);
	}
}