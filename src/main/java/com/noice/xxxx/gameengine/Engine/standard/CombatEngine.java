package com.noice.xxxx.gameengine.Engine.standard;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.noice.xxxx.gameengine.Engine.ICombatEngine;
import com.noice.xxxx.gameengine.POJO.Joueur;
import com.noice.xxxx.gameengine.POJO.Case;
import com.noice.xxxx.gameengine.POJO.Unite;

@Service
public class CombatEngine implements ICombatEngine{

	@Override
	public Unite resolveCombat(List<Unite> belligerents, Case champsDeBataille) {
		// TODO Auto-generated method stub
		/*	 * retourne l'unite victorieuse, si il y en a une.
	 * sinon retourne null
	 * */
		for (Unite unite : belligerents) {
			List<Unite> unitesOpposantes = calculerListOpposants(belligerents, unite);
			int nbOpposants = unitesOpposantes.size();
			for (Unite uniteOpposante : unitesOpposantes) {
				int degats = calculerDegats(unite, uniteOpposante);
				degats = degats / nbOpposants;
				uniteOpposante.setNombrePVRestant(uniteOpposante.getNombrePVRestant() - degats);
			}
		}

		return null;
	}

	private List<Unite> calculerListOpposants(List<Unite> belligerents, Unite unite) {
		List<Unite> unitesOpposantes = new ArrayList<Unite>();
		
		for (Unite uniteOpposante : belligerents) {
			if (uniteOpposante.getNombrePVRestant()>=0 && !uniteOpposante.getJoueur().equals(unite.getJoueur())) {
				if(aPortee(unite, uniteOpposante)) {
					unitesOpposantes.add(unite);
				}
			}
		}
		
		return unitesOpposantes;
	}
	
	private boolean aPortee(Unite uniteAttaquante, Unite uniteOpposante) {
		int distance = 0; //TODO Calcul distance
		if (distance <= uniteAttaquante.getPortee()) {
			return true;
		}
		return false;
	}
	
	private int calculerDegats(Unite uniteAttaquante, Unite uniteOpposante) {
		double chanceToucher = uniteAttaquante.getPrecision() * uniteOpposante.getEsquive() / 100;
		if (chanceToucher >= Math.random()*100) {
			Random r = new Random();
			int degats = uniteAttaquante.getDegatsMin() + r.nextInt(uniteAttaquante.getDegatsMax() - uniteAttaquante.getDegatsMin());
			degats = degats * uniteOpposante.getArmure()/100;
			return degats;
		}
		return 0;
	}
}
