import org.junit.jupiter.api.Test;

import Engine.CombatEngine;
import Engine.GameEngine;
import Engine.PathEngine;
import POJO.Game;

class test {

	@Test
	void test() {
		Game partie = new Game();
		GameEngine moteur = new GameEngine();
		moteur.setCombatEngine(new CombatEngine());
		moteur.setPathEngine(new PathEngine());
		partie.setGameEngine(moteur);
		
		//TODO
		
		partie.resolveTurn();
	}

}
