package com.linhaibin.chess;

public class KnightPiece extends AbstractPiece implements Piece {

	public KnightPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "N";
		else return "n";
	}
	
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redKnightPositionValue.get(k) : Evaluate.blackKnightPositionValue.get(k);
		return value;
	}
	
}
