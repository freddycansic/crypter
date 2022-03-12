package com.crypter.game.game;

public class Attack {

	private String name;
	
	public Attack(String name) {
		this.name = name.toLowerCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
}
