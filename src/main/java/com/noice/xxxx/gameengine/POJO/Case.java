package com.noice.xxxx.gameengine.POJO;

import java.awt.Point;
import java.util.Objects;

import lombok.Data;

@Data
public class Case {
	private Point coordonnees;
	public Case (int x, int y) {
		coordonnees = new Point(x,y);
	}
	
	@Override
	public boolean equals(Object objet) {
		if(objet instanceof Case) {
			return (this.coordonnees.x==((Case)objet).getCoordonnees().getX()
					&& this.coordonnees.y==((Case)objet).getCoordonnees().getY());			
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(coordonnees.x, coordonnees.y);
	}
}
