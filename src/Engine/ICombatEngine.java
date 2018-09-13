package Engine;

import java.util.List;

import POJO.Unite;

public interface ICombatEngine {
	
	/**
	 * retourne l'unite victorieuse, si il y en a une.
	 * sinon retourne null.
	 * @param belligerents
	 * @return
	 */
	public Unite ResolveCombat(List<Unite>belligerents) ;
}
