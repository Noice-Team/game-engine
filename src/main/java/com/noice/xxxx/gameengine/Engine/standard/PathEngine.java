package com.noice.xxxx.gameengine.Engine.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.noice.xxxx.gameengine.Engine.IPathEngine;
import com.noice.xxxx.gameengine.POJO.Case;
import com.noice.xxxx.gameengine.POJO.Game;
import com.noice.xxxx.gameengine.POJO.Unite;

@Service
public class PathEngine implements IPathEngine{
	
	
	public Game processRound(Game game) {
		boolean allMoveAreDone = false;

		while (!allMoveAreDone) {
			
			// PHASE DE MOUVEMENT
			allMoveAreDone=true;
			HashMap<Case,List<Unite>> agregateurDeConflit = new HashMap<Case,List<Unite>>();
			for (Unite unite : game.getUnites()) {
				Case emplacementVirtuel = unite.getEmplacement();
				if (unite.getChemin() != null && unite.getChemin().size() > 0) {
					if (unite.canWalkIn(unite.getChemin().get(0))) {
						emplacementVirtuel = unite.getChemin().get(0);
						unite.getChemin().remove(0);
						if(unite.getChemin().size()>0) {
							allMoveAreDone=false;
						}
					} else {
						// ne peux pas marcher la
						unite.setChemin(null);
					}
				} else {
					// pas de mouvement
				}
				if(agregateurDeConflit.get(emplacementVirtuel)==null) {
					agregateurDeConflit.put(emplacementVirtuel, new ArrayList<Unite>());
				}
				agregateurDeConflit.get(emplacementVirtuel).add(unite);
			}
			
			
			// PHASE DE CAC
			Set<Case> cles = agregateurDeConflit.keySet();
			Iterator<Case> it = cles.iterator();
			while (it.hasNext()){
				Case cle = it.next();
				List<Unite> listeUniteSurLaMemeCase = agregateurDeConflit.get(cle);
				if(listeUniteSurLaMemeCase!=null && listeUniteSurLaMemeCase.size()>0) {
					// conflit !!
					// check si appartiennent pas aux m�me joueur, sinon combat !
				}
			}
			
			//PHASE DE TIR

		}

		return game;

	}

}
