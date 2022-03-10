package com.crypter.game.scenes;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Entity;
import com.crypter.game.entities.Player;
import com.crypter.game.util.Window;

public class FightScene extends Scene {

	private Player player;
	private Entity enemy;
	
	private Batch batch = getBatch();
	
	public FightScene(Viewport viewport, Player player, Entity enemy) {
		super(viewport);
		
		this.player = player;
		this.enemy = enemy;
		
		this.player.setPos(Window.WIDTH/4 - this.player.getHitbox().getWidth(), Window.HEIGHT / 4);
		this.enemy.setPos(3*Window.WIDTH/4, 3*Window.HEIGHT/4 - this.enemy.getHitbox().getHeight() / 2);
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		super.render();
				
		batch.begin();
		
		batch.draw(player.getWalkAnimation().getDown().getKeyFrames()[0], player.getX(), player.getY());
		batch.draw(enemy.getTexture(), enemy.getX(), enemy.getY());
		
		batch.end();
	}
	
	

}
