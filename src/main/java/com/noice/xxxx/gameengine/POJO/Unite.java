package com.noice.xxxx.gameengine.POJO;

import java.util.List;
/**
 * represente une unit�
 * @author alban
 *
 */
public class Unite {
	private Joueur joueur;
	private Case emplacement;
	private List<Case> chemin;
	
	private int precision;
	private int esquive;
	private int nombreMaxPV;
	private int nombrePVRestant;
	private int armure;
	private int degatsMin;
	private int degatsMax;
	private int portee;
	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Case getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}
	public List<Case> getChemin() {
		return chemin;
	}
	public void setChemin(List<Case> chemin) {
		this.chemin = chemin;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getEsquive() {
		return esquive;
	}
	public void setEsquive(int esquive) {
		this.esquive = esquive;
	}
	public int getNombreMaxPV() {
		return nombreMaxPV;
	}
	public void setNombreMaxPV(int nombreMaxPV) {
		this.nombreMaxPV = nombreMaxPV;
	}
	public int getNombrePVRestant() {
		return nombrePVRestant;
	}
	public void setNombrePVRestant(int nombrePVRestant) {
		this.nombrePVRestant = nombrePVRestant;
	}
	public int getArmure() {
		return armure;
	}
	public void setArmure(int armure) {
		this.armure = armure;
	}
	public int getDegatsMin() {
		return degatsMin;
	}
	public void setDegatsMin(int degatsMin) {
		this.degatsMin = degatsMin;
	}
	public int getDegatsMax() {
		return degatsMax;
	}
	public void setDegatsMax(int degatsMax) {
		this.degatsMax = degatsMax;
	}

	public int getPortee() {
		return portee;
	}
	public void setPortee(int portee) {
		this.portee = portee;
	}
	public boolean canWalkIn(Case case1) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
