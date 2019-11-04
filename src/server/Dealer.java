package server;

import java.util.ArrayList;
import java.util.List;

/**
 * Internal logic of black jack dealer. Interfaces with player
 * @author elvinlimpin
 *
 */


public class Dealer {
	private List<Turn> turns;
	private List<ActionBuffer> actions;
	
	public enum Action {
		DOUBLE,
		HIT,
		STAY,
	}

	public Dealer() {
		
	}
	
	// step 1
	public Turn deal() {
		Turn turn = new Turn();
		this.actions = new ArrayList<ActionBuffer>();
		
		return turn;
	}
	
	// step 2 for each player that calls this
	public ActionBuffer handleAction(String username, Action action) {
		// what should this actually do? Change their hand right?
		
		if(Action.DOUBLE.equals(action)) {
			ActionBuffer pr = new ActionBuffer(username, action);
			actions.add(pr);
			return pr;
			
		} else if(Action.HIT.equals(action)) {
			ActionBuffer pr = new ActionBuffer(username, action);
			actions.add(pr);
			return pr;
			
		} else {
			ActionBuffer pr = new ActionBuffer(username, action);
			actions.add(pr);
			return pr;
			
		}
	}
	
	// step 3
	public Turn computeResults(int turnIndex) {
		Turn turn = turns.get(turnIndex);
		List<Hand> hands = new ArrayList<Hand>();
		List<Integer> balances = new ArrayList<Integer>();
		
		for(ActionBuffer action: actions) {
			// logic
			hands.add(new Hand("")); // fix this
			balances.add(0); // fix this
			
			
		} for(int i = 0; i < actions.size(); i++) {
			turn.addResult(actions.get(i), hands.get(i), (int) balances.get(i));	
		}
		
		turn.setComplete(true);
		this.turns.set(turnIndex, turn);
		
		this.actions = null;
		return turn;
	}
}