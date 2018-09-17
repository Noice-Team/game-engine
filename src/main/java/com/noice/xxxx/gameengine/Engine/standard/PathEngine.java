package com.noice.xxxx.gameengine.Engine.standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.noice.xxxx.gameengine.Engine.ICombatEngine;
import com.noice.xxxx.gameengine.Engine.IPathEngine;
import com.noice.xxxx.gameengine.POJO.Case;
import com.noice.xxxx.gameengine.POJO.Game;
import com.noice.xxxx.gameengine.POJO.Unite;

@Service
public class PathEngine implements IPathEngine {

	public boolean makeOneStep(Game game) {
		boolean allMoveAreDone = false;
		allMoveAreDone = true;
		HashMap<Case, List<Unite>> agregateurDeConflit = new HashMap<Case, List<Unite>>();
		for (Unite unite : game.getUnites()) {
			Case emplacementVirtuel = unite.getEmplacement();
			if (unite.getChemin() != null && unite.getChemin().size() > 0) {
				if (unite.canWalkIn(unite.getChemin().get(0))) {
					emplacementVirtuel = unite.getChemin().get(0);
					unite.getChemin().remove(0);
					if (unite.getChemin().size() > 0) {
						allMoveAreDone = false;
					}
				} else {
					// ne peux pas marcher la
					unite.setChemin(null);
				}
			} else {
				// pas de mouvement
			}
			putIn(agregateurDeConflit, emplacementVirtuel, unite);
		}
		// Resolution des conflits
		HashMap<Case, List<Unite>> positionFinal = ResolveConflict(agregateurDeConflit, game);

		// Mise a jour des positions
		Set<Case> cles = positionFinal.keySet();
		Iterator<Case> it = cles.iterator();
		while (it.hasNext()) {
			Case cle = it.next();
			List<Unite> unite = positionFinal.get(cle);
			unite.get(0).setEmplacement(cle);
		}

		return allMoveAreDone;

	}

	private HashMap<Case, List<Unite>> ResolveConflict(HashMap<Case, List<Unite>> agregateurDeConflit, Game game) {
		HashMap<Case, List<Unite>> agregateurDeConflit2 = new HashMap<Case, List<Unite>>();
		Set<Case> cles = agregateurDeConflit.keySet();
		Iterator<Case> it = cles.iterator();
		boolean noConflict = true;
		while (it.hasNext()) {
			Case cle = it.next();
			List<Unite> listeUniteSurLaMemeCase = agregateurDeConflit.get(cle);
			if (listeUniteSurLaMemeCase != null && listeUniteSurLaMemeCase.size() > 0) {
				if (listeUniteSurLaMemeCase.size() > 1) {
					noConflict = false;
					Unite Winner = game.getGameEngine().getICombatEngine().resolveCombat(listeUniteSurLaMemeCase, cle);
					for (Unite unit : listeUniteSurLaMemeCase) {
						if (unit == Winner) {
							putIn(agregateurDeConflit2, cle, unit);
						} else {
							if (Winner == null) {
								unit.setChemin(null);
								putIn(agregateurDeConflit2, unit.getEmplacement(), unit);
							} else {
								// tout les autres sont morts :
								game.getUnites().remove(unit);
							}
						}
					}
				} else {
					putIn(agregateurDeConflit2, cle, listeUniteSurLaMemeCase.get(0));
				}
			}
		}
		if (noConflict) {
			return agregateurDeConflit;
		} else {
			return ResolveConflict(agregateurDeConflit2, game);
		}
	}

	private void putIn(HashMap<Case, List<Unite>> agregateurDeConflit, Case emplacementVirtuel, Unite unite) {
		if (agregateurDeConflit.get(emplacementVirtuel) == null) {
			agregateurDeConflit.put(emplacementVirtuel, new ArrayList<Unite>());
		}
		agregateurDeConflit.get(emplacementVirtuel).add(unite);
	}

}
