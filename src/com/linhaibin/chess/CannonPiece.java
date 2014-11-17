package com.linhaibin.chess;

public class CannonPiece extends AbstractPiece implements Piece {

	public CannonPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "C";
		else return "c";
	}
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redCannonPositionValue.get(k) : (-1 * Evaluate.blackCannonPositionValue.get(k));
		return value;
	}
	
}
