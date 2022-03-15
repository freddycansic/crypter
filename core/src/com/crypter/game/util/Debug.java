package com.crypter.game.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.badlogic.gdx.Gdx;

public class Debug {

	public static final int LEVEL = 1;

	private Debug() {	
	}

	public static void log(String tag, String message) {

		switch (LEVEL) {

		case 0:
			return;

		case 1:
			Gdx.app.log(tag, message);
			break;

		case 2:
			Gdx.app.log(tag + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()), message);
			break;

		}

	}

	public static void log(String tag, int message) {

		switch (LEVEL) {

		case 0:
			return;

		case 1:
			Gdx.app.log(tag, Integer.toString(message));
			break;

		case 2:
			Gdx.app.log(tag + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()), Integer.toString(message));
			break;

		}

	}

	public static void log(Object obj, String message) {
		switch (LEVEL) {

		case 0:
			return;

		case 1:
			Gdx.app.log(obj.getClass().getSimpleName(), message);
			break;

		case 2:
			Gdx.app.log(obj.getClass().getSimpleName() + " " + new SimpleDateFormat("HH:mm:ss").format(new Date()), message);
			break;

		}
	}

}
