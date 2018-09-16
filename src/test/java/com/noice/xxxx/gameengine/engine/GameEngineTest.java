package com.noice.xxxx.gameengine.engine;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.noice.xxxx.gameengine.XTest;
import com.noice.xxxx.gameengine.Engine.standard.GameEngine;
import com.noice.xxxx.gameengine.POJO.Game;

class GameEngineTest extends XTest{
	@Autowired
	GameEngine moteur;
	
	@Test
	void test() {
		Game partie = Game.builder()
			.unites(new ArrayList<>())
			.cases(new ArrayList<>())
			.joueurs(new ArrayList<>())
		.build();	
		//TODO
		
		moteur.resolveTurn(partie);
	}

}
