package com.linhaibin.chess;

import java.util.Iterator;
import java.util.List;

public class Search {

	public static State minMaxSearch(State state, int depth){
		return minSearch(state, depth, Game.COMP_TURN);
	}
	
	private static int changeSide(int side){
		if (side == Game.COMP_TURN) return Game.USER_TURN;
		else return Game.COMP_TURN;
	}
	
	public static State minSearch(State state, int depth, int side){
		if (depth <= 0) {
			state.evaluateValue();
			return state;
		}
		
		List<State> stateList = state.generateAllState(side);
		Iterator<State> it = stateList.iterator();
		
		State minState = null;
		Integer value = Integer.MAX_VALUE;
		
		while(it.hasNext()){
			State newState = it.next();
			int newValue = maxSearch(newState, depth-1, changeSide(side)).getValue();
//			System.out.println("Min search Value:" + String.valueOf(newValue));
			if (newValue < value){
//				System.out.println("Min search update value:" + String.valueOf(newValue));
				minState = newState;
				value = newValue;
				minState.setValue(newValue);
			}	
		}
		return minState;
	}
	
	public static State maxSearch(State state, int depth, int side){
		if (depth <= 0) {
			state.evaluateValue();
			return state;
		}
		List<State> stateList = state.generateAllState(side);
		Iterator<State> it = stateList.iterator();
		
		State maxState = null;
		Integer value = Integer.MIN_VALUE;
		
		while(it.hasNext()){
			State newState = it.next();
			int newValue = minSearch(newState, depth-1, changeSide(side)).getValue();
//			System.out.println("Max search New Value:" + String.valueOf(newValue));
			if (newValue > value){
				maxState = newState;
				value = newValue;
				maxState.setValue(newValue);
			}	
		}
		return maxState;
	}	
}
