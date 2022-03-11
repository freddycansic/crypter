package com.crypter.game.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

public abstract class UIComponent extends Widget {

	public UIComponent() {
		
	}
	
	public abstract Actor getActor();

	
}
