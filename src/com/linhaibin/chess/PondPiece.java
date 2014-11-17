package com.linhaibin.chess;

public class PondPiece extends AbstractPiece implements Piece {

	public PondPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "P";
		else return "p";
	}
	
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redPondPositionValue.get(k) : (-1 * Evaluate.blackPondPositionValue.get(k));
		return value;
	}
	
	
}
