package com.linhaibin.chess;

import java.util.List;

public class UserMove{

	public UserMove() {
	}

	public static State movePiece(State state, int fromX, int fromY, int toX, int toY) {
		State newState = null;
		try {
			newState = (State) state.clone();
			List<Piece> stateList = newState.getStateList();
			int fromK = Utility.getOneDimention(fromX, fromY);
			int toK = Utility.getOneDimention(toX, toY);
			stateList.set(toK, stateList.get(fromK));
			stateList.set(fromK, PieceFactory.getPiece(0));
//			state.evaluateValue();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newState;
	}
	
	

}
