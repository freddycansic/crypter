package com.crypter.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
	private Image background;
	
	private Batch batch = getBatch();
	private Skin skin = Resources.skin;
	private final Table ui = new Table();
	
	public FightScene(Viewport viewport) {
		super(viewport);
		
		this.player.setPos(Window.WIDTH/4 - this.player.getHitbox().getWidth(), Window.HEIGHT / 4);
		this.enemy.setPos(3*Window.WIDTH/4, 1*Window.HEIGHT/2 - this.enemy.getHitbox().getHeight() / 2);
		
		background = new Image(new Texture(Gdx.files.internal("scenes/fight/background.png")));
		background.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
		
		ui.setSkin(skin);
		ui.setFillParent(true); // set table to window size
		
		showOptions(ui);
		
//		ui.setDebug(true);
		this.add(background, ui);
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
	
	private void showOptions(final Table ui) {
		ui.reset();
		ui.bottom().padBottom(30);
		
		ui.add(new Button("FIGHT", skin, "xl", new Action() {

			@Override
			public void action() {
				showAttacks(ui);
				return;
			}
			
		}).getActor());
		
		ui.add(new Button("TALK", skin, "xl", new Action() {

			@Override
			public void action() {
				
			}
			
		}).getActor());
		
		ui.add(new Button("ITEMS", skin, "xl", new Action() {

			@Override
			public void action() {
				
			}
			
		}).getActor());
		
		ui.add(new Button("RUN", skin, "xl", new Action() {

			@Override
			public void action() {
			  
			}
			
		}).getActor());
	}
	
	private void showAttacks(final Table ui) {
		ui.reset();
		ui.bottom().left().padBottom(30);
		ui.add(new Label("What will you do?", skin, "xl"));
		
		List<String> attacks = new List<String>(skin);
		this.setKeyboardFocus(attacks); // set the actor to receive key events
		attacks.setItems(player.getAttacks());
		ui.add(attacks);
	}
	

}
