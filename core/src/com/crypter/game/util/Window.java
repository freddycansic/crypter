package com.crypter.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** 
 * Class containing information about the window.
 **/
public final class Window {

	private Window() {
	}
	
	public static final int WIDTH = Gdx.graphics.getWidth();
	public static final int HEIGHT = Gdx.graphics.getHeight();
	public static final FitViewport VIEWPORT = new FitViewport(Window.WIDTH, Window.HEIGHT);
	
}
