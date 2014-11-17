package com.linhaibin.chess;

import java.util.List;

public class AbstractPiece implements Cloneable{

	int number;
	int side;
	
	public AbstractPiece(int number){
		this.number = number;
		this.side = number & Game.USER_TURN; 
	}
	
	public int getNumber() {
		return this.number;
	}

	
	public int getSide() {
		return this.side;
	}

	
	public int evaluateStatic(int k) {
		return 0;
	}

	public List<State> generateAllMove(State state, int fromX, int fromY) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object clone(){
		Object returnObj = null;
		try {
			returnObj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return returnObj;
	}
}
