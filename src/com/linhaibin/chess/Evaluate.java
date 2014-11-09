package com.linhaibin.chess;

public class Evaluate {

	public Evaluate() {
	}

	public int evaluateState(State state){
		int value = 0;
		value += evaluateStatic(state);
		value += evaluateMobility(state);
		return value;
	}
	
	private int evaluateStatic(State state){
		return 0;
	}
	
	private int evaluateMobility(State state){
		return 0;
	}
}
