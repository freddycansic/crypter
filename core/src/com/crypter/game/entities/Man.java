package com.crypter.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.crypter.game.Main;
import com.crypter.game.game.Hitbox;
import com.crypter.game.scenes.FightScene;
import com.crypter.game.util.Resources;
import com.crypter.game.util.Window;

public class Man extends Entity {

	private Texture texture;
	
	public Man(float x, float y) {
		super(x, y);
		
		texture = new Texture(Gdx.files.internal("entities/man/textures/man.png"));
		
		setHitbox(new Hitbox(this, texture));
		setTexture(texture);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(texture, getX(), getY());
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	
	}

	@Override
	public void interact(Player player) {
		Main.setScene(new FightScene(Window.VIEWPORT, Resources.player, Resources.man));
	}

	
}
