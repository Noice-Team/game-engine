package com.noice.xxxx.gameengine.engine;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.noice.xxxx.gameengine.Engine.standard.GameEngine;
import com.noice.xxxx.gameengine.POJO.Game;


@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class GameEngineTest {
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
