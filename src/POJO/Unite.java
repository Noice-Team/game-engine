package POJO;
import java.util.List;
/**
 * represente une unité
 * @author alban
 *
 */
public class Unite {
	private Joueur joueur;
	private Case emplacement;
	private List<Case> chemin;
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Case getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(Case emplacement) {
		this.emplacement = emplacement;
	}
	public List<Case> getChemin() {
		return chemin;
	}
	public void setChemin(List<Case> chemin) {
		this.chemin = chemin;
	}
	public boolean canWalkIn(Case case1) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
