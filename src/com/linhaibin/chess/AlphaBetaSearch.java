package com.linhaibin.chess;

import java.util.Iterator;
import java.util.List;

public class AlphaBetaSearch {

	public static State doSearch(State state, int depth){
		return minSearch(state, depth, Game.COMP_TURN, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static int changeSide(int side){
		if (side == Game.COMP_TURN) return Game.USER_TURN;
		else return Game.COMP_TURN;
	}
	
	private static State minSearch(State state, int depth, int side, int alpha, int beta){
		if (depth <= 0) {
			state.evaluateValue();
			return state;
		}
		
		int newAlpha = alpha;
		int newBeta = beta;
		List<Move> moveList = state.generateAllMoves(side);
		Iterator<Move> it = moveList.iterator();
		
		State minState = new State();
		minState.setValue(newBeta);
		
		while(it.hasNext()){
			State newState = UserMove.movePiece(state, it.next());
			int newValue = maxSearch(newState, depth-1, changeSide(side), newAlpha, newBeta).getValue();
			if (newValue < newBeta){
				minState = newState;
				newBeta = newValue;
				minState.setValue(newValue);
			}
			if (newBeta <= newAlpha){
				return minState;
			}
		}
		return minState;
	}
	
	private static State maxSearch(State state, int depth, int side, int alpha, int beta){		
		if (depth <= 0) {
			state.evaluateValue();
			return state;
		}
		
		int newAlpha = alpha;
		int newBeta = beta;
		List<Move> moveList = state.generateAllMoves(side);
		Iterator<Move> it = moveList.iterator();
		
		State maxState = new State();
		maxState.setValue(newAlpha);
		
		while(it.hasNext()){
			State newState = UserMove.movePiece(state, it.next());
			int newValue = minSearch(newState, depth-1, changeSide(side), newAlpha, newBeta).getValue();			
			if (newValue > newAlpha){
				maxState = newState;
				newAlpha = newValue;
				maxState.setValue(newValue);
			}
			if (newBeta <= newAlpha){
				return maxState;
			}
		}
		return maxState;
	}	
}
