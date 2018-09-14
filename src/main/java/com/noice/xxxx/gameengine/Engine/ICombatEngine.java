package com.noice.xxxx.gameengine.Engine;

import java.util.List;

import com.noice.xxxx.gameengine.POJO.Unite;

public interface ICombatEngine {
	
	/**
	 * retourne l'unite victorieuse, si il y en a une.
	 * sinon retourne null.
	 * @param belligerents
	 * @return
	 */
	public Unite resolveCombat(List<Unite>belligerents) ;
}
