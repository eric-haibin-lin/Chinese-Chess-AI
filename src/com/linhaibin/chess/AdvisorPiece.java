package com.linhaibin.chess;

public class AdvisorPiece extends AbstractPiece implements Piece {

	public AdvisorPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "A";
		else return "a";
	}
	
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redAdvisorPositionValue.get(k) : (-1 * Evaluate.blackAdvisorPositionValue.get(k));
		return value;
	}
	
}