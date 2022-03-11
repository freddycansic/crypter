package com.crypter.game.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Button extends UIComponent {
		
	private TextButton button;
	
	/**
	 * @param scene	Scene to add button to
	 * @param skin	Skin to render button with
	 * @param text	Text to display in button
	 * @param action	Method to perform on button click
	 */
		
	public Button(String text, Skin skin, final Action action) {
		button = new TextButton(text, skin, "default");
		
		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				action.action();
			}
		});
	}
	
	@Override
	public Actor getActor() {
		return button;
	}
	
}
