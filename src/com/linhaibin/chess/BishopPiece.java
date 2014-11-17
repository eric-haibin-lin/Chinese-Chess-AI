package com.linhaibin.chess;

public class BishopPiece extends AbstractPiece implements Piece {

	public BishopPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "B";
		else return "b";
	}
	
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redBishopPositionValue.get(k) : (-1 * Evaluate.blackBishopPositionValue.get(k));
		return value;
	}
	
}
