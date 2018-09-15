package com.noice.xxxx.gameengine.Engine.standard;

import java.util.List;

import org.springframework.stereotype.Service;

import com.noice.xxxx.gameengine.Engine.ICombatEngine;
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
		return null;
	}

	
}
