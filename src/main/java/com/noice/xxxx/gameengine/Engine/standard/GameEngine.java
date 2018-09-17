package com.noice.xxxx.gameengine.Engine.standard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noice.xxxx.gameengine.Engine.ICombatEngine;
import com.noice.xxxx.gameengine.Engine.IGameEngine;
import com.noice.xxxx.gameengine.Engine.IPathEngine;
import com.noice.xxxx.gameengine.POJO.Game;

import lombok.Data;

@Service
@Data
public class GameEngine  implements IGameEngine{
	@Autowired
	private ICombatEngine combatEngine;
	@Autowired
	private IPathEngine pathEngine;
	
	public void resolveTurn(Game game) {
		while (!pathEngine.makeOneStep(game))
		{
			// TODO entre chaque mouvement
			// Tir
			// update des case exploré et des case sans fog.
			// autre
		}
	}

	@Override
	public ICombatEngine getICombatEngine() {
		return combatEngine;
	}
	
}
