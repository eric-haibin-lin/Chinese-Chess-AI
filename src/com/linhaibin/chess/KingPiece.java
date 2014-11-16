package com.linhaibin.chess;

public class KingPiece extends AbstractPiece implements Piece {

	public KingPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "K";
		else return "k";
	}
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redKingPositionValue.get(k) : Evaluate.blackKingPositionValue.get(k);
		return value;
	}
	
}
