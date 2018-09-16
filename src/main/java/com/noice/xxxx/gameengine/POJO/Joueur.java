package com.noice.xxxx.gameengine.POJO;

public class Joueur {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean equals(Joueur joueur) {
		return (this.getId() == joueur.getId());
	}
}
