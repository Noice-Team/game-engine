package Engine;

import POJO.Game;

public class GameEngine  {
	private ICombatEngine combatEngine;
	private IPathEngine pathEngine;
	
	public void resolveTurn(Game game) {
		pathEngine.ProcessRound(game);
	}
	
	public ICombatEngine getCombatEngine() {
		return combatEngine;
	}
	public void setCombatEngine(ICombatEngine combatEngine) {
		this.combatEngine = combatEngine;
	}
	public IPathEngine getPathEngine() {
		return pathEngine;
	}
	public void setPathEngine(IPathEngine pathEngine) {
		this.pathEngine = pathEngine;
	}
	
	
}
