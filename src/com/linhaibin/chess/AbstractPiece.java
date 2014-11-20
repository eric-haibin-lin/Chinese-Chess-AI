package com.linhaibin.chess;

import java.util.List;

public class AbstractPiece implements Cloneable{

	int number;
	int side;
	
	public AbstractPiece(int number){
		this.number = number;
		if (number == 0) this.side = Game.EMPTY_SPACE;
		else if ((number & Game.USER_TURN) == Game.USER_TURN)	this.side = Game.USER_TURN; 
		else	this.side = Game.COMP_TURN;
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
	
	private static boolean suicide(State state, int fromX, int fromY, int toX, int toY){
		List<Piece> stateList = state.getStateList();
		Piece sourcePiece = stateList.get(Utility.getOneDimention(fromX, fromY));
		Piece targetPiece = stateList.get(Utility.getOneDimention(toX, toY));
		if (sourcePiece.getSide() == targetPiece.getSide()) return true;
		else return false;
	}
	
	protected static boolean isLegalBasic(State state, int fromX, int fromY, int toX, int toY){
		if (!Utility.isOnBoard(toX, toY)) return false;
		if (suicide(state, fromX, fromY, toX, toY)) return false;
		if (Utility.standStill(fromX, fromY, toX, toY)) return false;
		else return true;
	}
}
