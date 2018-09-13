package POJO;
import java.util.List;

import Engine.GameEngine;

/**
 * represente une partie
 * @author alban
 *
 */
public class Game {
	private GameEngine gameEngine;
	private List <Unite> listeUnites;
	private List <Joueur> listeJoueurs;
	private List <Case> listeCases;
	
	public void resolveTurn()
	{
		gameEngine.resolveTurn(this);
	}
	public GameEngine getGameEngine() {
		return gameEngine;
	}
	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}
	public List<Unite> getListeUnites() {
		return listeUnites;
	}
	public void setListeUnites(List<Unite> listeUnites) {
		this.listeUnites = listeUnites;
	}
	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}
	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	public List<Case> getListeCases() {
		return listeCases;
	}
	public void setListeCases(List<Case> listeCases) {
		this.listeCases = listeCases;
	}
	
}
