package com.linhaibin.chess;

public class RookPiece extends AbstractPiece implements Piece {

	public RookPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "R";
		else return "r";
	}
	
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redRookPositionValue.get(k) : (-1 * Evaluate.blackRookPositionValue.get(k));
		return value;
	}
	
}
