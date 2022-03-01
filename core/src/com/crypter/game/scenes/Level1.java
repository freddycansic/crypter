package com.crypter.game.scenes;

import com.crypter.game.entities.Player;
import com.crypter.game.util.Window;

public class Level1 extends Scene {

	private Player player;
	
	public Level1() {
		player = new Player(Window.WIDTH/2, Window.HEIGHT/2);
		
		this.addActor(player);
	}
	
	@Override
	public void render() {
		this.draw();
	}

}
