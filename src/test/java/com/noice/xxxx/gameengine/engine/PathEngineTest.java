package com.noice.xxxx.gameengine.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.noice.xxxx.gameengine.XTest;
import com.noice.xxxx.gameengine.Engine.standard.GameEngine;
import com.noice.xxxx.gameengine.Engine.standard.PathEngine;
import com.noice.xxxx.gameengine.POJO.Case;
import com.noice.xxxx.gameengine.POJO.Game;
import com.noice.xxxx.gameengine.POJO.Joueur;
import com.noice.xxxx.gameengine.POJO.Unite;

public class PathEngineTest extends XTest{

	@Test
	void mouvementSimple() {
		Game partie = initialiseSimpleGame();
		
		Unite unite = new Unite();
		unite.setEmplacement(new Case(0,0));
		List <Case> chemin = new ArrayList<Case>();
		chemin.add(new Case(0,1));
		unite.setChemin(chemin);
		partie.getUnites().add(unite);
		
		PathEngine pathEngine = new PathEngine();
		while (!pathEngine.makeOneStep(partie)){}
		assert(unite.getEmplacement().equals(new Case(0,1)));
	}
	

	@Test
	void queuleuleu() {
		Game partie = initialiseSimpleGame();
		
		Unite a = new Unite();
		a.setEmplacement(new Case(0,0));
		a.setChemin(new ArrayList<Case>());
		a.getChemin().add(new Case(0,1));
		partie.getUnites().add(a);
		
		Unite b = new Unite();
		b.setEmplacement(new Case(0,1));
		b.setChemin(new ArrayList<Case>());
		b.getChemin().add(new Case(0,2));
		partie.getUnites().add(b);
		
		Unite c = new Unite();
		c.setEmplacement(new Case(0,2));
		c.setChemin(new ArrayList<Case>());
		c.getChemin().add(new Case(0,3));
		partie.getUnites().add(c);
		
		PathEngine pathEngine = new PathEngine();
		while (!pathEngine.makeOneStep(partie)){}
		assert(a.getEmplacement().equals(new Case(0,1)));
		assert(b.getEmplacement().equals(new Case(0,2)));
		assert(c.getEmplacement().equals(new Case(0,3)));
	}

	@Test
	void queuleuleuConflictDraw() {
		Game partie = initialiseSimpleGame();
		
		Unite a = new Unite();
		a.setEmplacement(new Case(0,0));
		a.setChemin(new ArrayList<Case>());
		a.getChemin().add(new Case(0,1));
		partie.getUnites().add(a);
		
		Unite b = new Unite();
		b.setEmplacement(new Case(0,1));
		b.setChemin(new ArrayList<Case>());
		b.getChemin().add(new Case(0,2));
		partie.getUnites().add(b);
		
		Unite c = new Unite();
		c.setEmplacement(new Case(0,2));
		c.setChemin(new ArrayList<Case>());
		c.getChemin().add(new Case(0,3));
		partie.getUnites().add(c);
		
		Unite d = new Unite();
		d.setEmplacement(new Case(0,4));
		d.setChemin(new ArrayList<Case>());
		d.getChemin().add(new Case(0,3));
		partie.getUnites().add(d);
		
		PathEngine pathEngine = new PathEngine();
		while (!pathEngine.makeOneStep(partie)){}
		assert(a.getEmplacement().equals(new Case(0,0)));
		assert(b.getEmplacement().equals(new Case(0,1)));
		assert(c.getEmplacement().equals(new Case(0,2)));
		assert(d.getEmplacement().equals(new Case(0,4)));
	}
	
	@Test
	void queuleuleuConflictWinner() {
		Game partie = initialiseSimpleGame();
		((TestCombatEngine)partie.getGameEngine().getICombatEngine()).alwaysEquality=false;
		
		Unite a = new Unite();
		a.setEmplacement(new Case(0,0));
		a.setChemin(new ArrayList<Case>());
		a.getChemin().add(new Case(0,1));
		partie.getUnites().add(a);
		
		Unite b = new Unite();
		b.setEmplacement(new Case(0,1));
		b.setChemin(new ArrayList<Case>());
		b.getChemin().add(new Case(0,2));
		partie.getUnites().add(b);
		
		Unite c = new Unite();
		c.setDegatsMax(10);
		c.setEmplacement(new Case(0,2));
		c.setChemin(new ArrayList<Case>());
		c.getChemin().add(new Case(0,3));
		partie.getUnites().add(c);
		
		Unite d = new Unite();
		d.setEmplacement(new Case(0,4));
		d.setChemin(new ArrayList<Case>());
		d.getChemin().add(new Case(0,3));
		partie.getUnites().add(d);
		
		PathEngine pathEngine = new PathEngine();
		while (!pathEngine.makeOneStep(partie)){}
		assert(a.getEmplacement().equals(new Case(0,1)));
		assert(b.getEmplacement().equals(new Case(0,2)));
		assert(c.getEmplacement().equals(new Case(0,3)));
		assert(!partie.getUnites().contains(d));
	}
	
	@Test
	void queuleuleuConflictWinnerAndLongMouve() {
		Game partie = initialiseSimpleGame();
		((TestCombatEngine)partie.getGameEngine().getICombatEngine()).alwaysEquality=false;
		
		Unite a = new Unite();
		a.setEmplacement(new Case(0,0));
		a.setChemin(new ArrayList<Case>());
		a.getChemin().add(new Case(0,1));
		a.getChemin().add(new Case(0,2));
		a.getChemin().add(new Case(0,3));
		partie.getUnites().add(a);
		
		Unite b = new Unite();
		b.setEmplacement(new Case(0,1));
		b.setChemin(new ArrayList<Case>());
		b.getChemin().add(new Case(0,2));
		b.getChemin().add(new Case(0,3));
		b.getChemin().add(new Case(0,4));
		partie.getUnites().add(b);
		
		Unite c = new Unite();
		c.setDegatsMax(10);
		c.setEmplacement(new Case(0,2));
		c.setChemin(new ArrayList<Case>());
		c.getChemin().add(new Case(0,3));
		c.getChemin().add(new Case(0,4));
		c.getChemin().add(new Case(0,5));
		partie.getUnites().add(c);
		
		Unite d = new Unite();
		d.setEmplacement(new Case(0,4));
		d.setChemin(new ArrayList<Case>());
		d.getChemin().add(new Case(0,3));
		d.getChemin().add(new Case(0,4));
		d.getChemin().add(new Case(0,5));
		partie.getUnites().add(d);
		
		PathEngine pathEngine = new PathEngine();
		while (!pathEngine.makeOneStep(partie)){}
		assert(a.getEmplacement().equals(new Case(0,3)));
		assert(b.getEmplacement().equals(new Case(0,4)));
		assert(c.getEmplacement().equals(new Case(0,5)));
		assert(!partie.getUnites().contains(d));
	}
	
	private Game initialiseSimpleGame() {
		List <Case> map = new ArrayList<Case>();
		for(int x=0;x<50;x++) {
			for(int y=0;y<50;y++) {
				map.add(new Case(x,y));
			}
		}
		
		List <Joueur> players = new ArrayList<Joueur>();
		players.add(new Joueur());
		players.add(new Joueur());
		
		Game partie = Game.builder()
				.unites(new HashSet<Unite>())
				.cases(map)
				.joueurs(players)
			.build();
		GameEngine gameEnine = new GameEngine();
		gameEnine.setCombatEngine(new TestCombatEngine());
		gameEnine.setPathEngine(new PathEngine());
		partie.setGameEngine(gameEnine);
		
		return partie;
	}
}