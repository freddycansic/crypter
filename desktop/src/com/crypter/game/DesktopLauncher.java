package com.crypter.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("CRYPTER");

		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
//		config.setWindowedMode(1280, 720);
		config.setResizable(false);
		
		config.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate); 

//		config.setBackBufferConfig(0, 0, 0, 0, 0, 0, 10);
//		config.samples = 3; // anti aliasing
//		config.forceExit = false;
		
//		config.addIcon("icons/icon_128.png", FileType.Internal);
//		config.addIcon("icons/icon_32.png", FileType.Internal);
//		config.addIcon("icons/icon_16.png", FileType.Internal);
		
		new Lwjgl3Application(new Main(), config);
	}
}
