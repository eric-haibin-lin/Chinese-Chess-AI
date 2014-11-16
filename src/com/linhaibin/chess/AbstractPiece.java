package com.linhaibin.chess;

public class AbstractPiece implements Piece{

	int number;
	int side;
	
	public AbstractPiece(int number){
		this.number = number;
		this.side = number & Game.USER_TURN; 
	}
	
	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public int getSide() {
		return this.side;
	}

	@Override
	public int evaluateStatic(int k) {
		return 0;
	}
	
}
