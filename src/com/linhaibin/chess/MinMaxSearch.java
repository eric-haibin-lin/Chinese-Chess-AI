package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinMaxSearch {

	public static State minMaxSearch(State state, int depth){
		return minSearch(state, depth, Game.COMP_TURN);
	}
	
	private static int changeSide(int side){
		if (side == Game.COMP_TURN) return Game.USER_TURN;
		else return Game.COMP_TURN;
	}
	
	private static State minSearch(State state, int depth, int side){
		if (depth <= 0) {
			state.evaluateValue();
			return state;
		}
		
		List<Move> moveList = state.generateAllMoves(side);
		Iterator<Move> it = moveList.iterator();
		
		State minState = null;
		Integer value = Integer.MAX_VALUE;
		
		while(it.hasNext()){
			State newState = UserMove.movePiece(state, it.next());
			int newValue = maxSearch(newState, depth-1, changeSide(side)).getValue();
			if (newValue < value){
				minState = newState;
				value = newValue;
				minState.setValue(newValue);
			}	
		}
		return minState;
	}
	
	private static State maxSearch(State state, int depth, int side){
		if (depth <= 0) {
			state.evaluateValue();
			return state;
		}
		List<Move> moveList = state.generateAllMoves(side);
		Iterator<Move> it = moveList.iterator();
		
		State maxState = null;
		Integer value = Integer.MIN_VALUE;
		
		while(it.hasNext()){
			State newState = UserMove.movePiece(state, it.next());
			int newValue = minSearch(newState, depth-1, changeSide(side)).getValue();
			if (newValue > value){
				maxState = newState;
				value = newValue;
				maxState.setValue(newValue);
			}	
		}
		return maxState;
	}	
}
