package com.linhaibin.chess;

public class EmptyPiece extends AbstractPiece implements Piece {

	public EmptyPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		return "0";
	}
	
	@Override
	public int evaluateStatic(int k){
		return 0;
	}
}
