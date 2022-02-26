package com.crypter.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.crypter.game.entities.Player;
import com.crypter.game.util.Window;

public class Level1 extends Scene {

	private Player player;
	
	public Level1() {
		player = new Player(Window.WIDTH/2, Window.HEIGHT/2, new Texture(Gdx.files.internal("badlogic.jpg")));
		
		this.addActor(player);
	}
	
	@Override
	public void render() {
		this.draw();
	}

}
