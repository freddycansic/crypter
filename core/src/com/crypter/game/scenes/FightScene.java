package com.crypter.game.scenes;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crypter.game.entities.Entity;
import com.crypter.game.entities.Player;
import com.crypter.game.ui.Action;
import com.crypter.game.ui.Button;
import com.crypter.game.util.Resources;
import com.crypter.game.util.Window;

public class FightScene extends Scene {

	private Player player = Resources.player;
	private Entity enemy = Resources.man;
	
	private Batch batch = getBatch();
	private Skin skin = Resources.skin;
	
	public FightScene(Viewport viewport) {
		super(viewport);
		
		this.player.setPos(Window.WIDTH/4 - this.player.getHitbox().getWidth(), Window.HEIGHT / 4);
		this.enemy.setPos(3*Window.WIDTH/4, 3*Window.HEIGHT/4 - this.enemy.getHitbox().getHeight() / 2);
		
		
		Table table = new Table();
		table.setSkin(skin);
		table.setFillParent(true); // set table to window size
		table.bottom().padBottom(30);
	
		table.add(new Button("FIGHT", skin, new Action() {

			@Override
			public void action() {
				System.out.println("Hello world");
			}
			
		}).getActor());
		
		table.add(new Button("RUN", skin, new Action() {

			@Override
			public void action() {
				System.out.println("Hello world");
			}
			
		}).getActor());
	
		table.add(new Button("TALK", skin, new Action() {

			@Override
			public void action() {
				System.out.println("Hello world");
			}
			
		}).getActor());
	
		table.add(new Button("ITEMS", skin, new Action() {

			@Override
			public void action() {
				System.out.println("Hello world");
			}
			
		}).getActor());
	
		
//		table.setDebug(true);
		this.add(table);
		// TODO read about actions
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
