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
		return "+";
	}
	
	@Override
	public int evaluateStatic(int x, int y){
		return 0;
	}
	
	
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		return false;
	}
	
}
