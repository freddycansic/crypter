package com.crypter.game.scenes;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Entity;
import com.crypter.game.entities.Player;
import com.crypter.game.ui.Action;
import com.crypter.game.ui.Button;
import com.crypter.game.util.Resources;
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
	
		this.addUIComponent(new Button(Resources.skin, "Help", Window.WIDTH/2, Window.HEIGHT/2, 100, 50, new Action() {

			@Override
			public void action() {
				System.out.println("Hello");
			}
		
		}));
		
		MoveToAction action = Actions.action(MoveToAction.class);
		action.setPosition(Window.WIDTH/2, Window.HEIGHT/2);
		action.setDuration(3.0f);
		player.addAction(action); // TODO read about actions
		// TODO read about tables
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
