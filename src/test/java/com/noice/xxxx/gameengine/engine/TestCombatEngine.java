package com.noice.xxxx.gameengine.engine;

import java.util.List;

import org.springframework.stereotype.Service;

import com.noice.xxxx.gameengine.Engine.ICombatEngine;
import com.noice.xxxx.gameengine.POJO.Case;
import com.noice.xxxx.gameengine.POJO.Unite;

@Service
public class TestCombatEngine implements ICombatEngine{
	boolean alwaysEquality=true;

	@Override
	public Unite resolveCombat(List<Unite> belligerents, Case champsDeBataille) {
		if(alwaysEquality) {
			return null;
		}else {
			Unite best=null;
			for (Unite unite : belligerents) {
				if(best==null) {
					best=unite;
				}else {
					if(best.getDegatsMax()<unite.getDegatsMax()) {
						best=unite;
					}
				}
			}
			return best;
		}
	}

}
