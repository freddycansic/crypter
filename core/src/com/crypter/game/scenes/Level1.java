package com.crypter.game.scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Man;
import com.crypter.game.entities.Player;
import com.crypter.game.util.Resources;

public class Level1 extends Scene {

	private Player player = Resources.player;
	private Man man = Resources.man;
	private OrthographicCamera camera = (OrthographicCamera) this.getViewport().getCamera();

	public Level1(Viewport viewport) {
		super(viewport);		
				
		this.addEntities(man, player);
		this.setTileMap(Resources.tilemap1);
	}
	
	@Override
	public void update() {
		camera.position.set(player.getX(), player.getY(), camera.position.z);

	}

	@Override
	public void render() {
		// render tilemap
		this.getTileMap().getMapRenderer().setView(camera);
		this.getTileMap().getMapRenderer().render();
		
		super.render();

	}

}
