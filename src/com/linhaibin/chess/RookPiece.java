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
}
