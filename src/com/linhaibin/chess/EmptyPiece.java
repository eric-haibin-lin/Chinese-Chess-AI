package com.linhaibin.chess;

import java.util.List;

public class EmptyPiece extends AbstractPiece implements Piece {

	public EmptyPiece(int number) {
		super(number);
	}
	
	public EmptyPiece(int number, int x, int y) {
		super(number,x,y);
	}
	
	@Override
	public String toString(){
		return "0";
	}
	
	@Override
	public int evaluateStatic(int k){
		return 0;
	}
	
	
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		return false;
	}
	
}
