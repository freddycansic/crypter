package com.crypter.game.scenes;

import com.crypter.game.entities.Man;
import com.crypter.game.entities.Player;
import com.crypter.game.util.Window;

public class Level1 extends Scene {

	private Player player;
	private Man man;
	
	public Level1() {
		player = new Player();
		man = new Man(3*Window.WIDTH/4, 3*Window.HEIGHT/4);
		
		this.addEntities(man, player);
	}
	
	@Override
	public void render() {
		this.draw();
	}

}
