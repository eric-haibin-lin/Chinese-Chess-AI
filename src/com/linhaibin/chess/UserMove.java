package com.linhaibin.chess;

import java.util.Hashtable;
import java.util.List;

public class UserMove{

	public UserMove() {
	}

	public static State movePiece(State state, int fromX, int fromY, int toX, int toY) {
		State newState = null;
		try {
			newState = (State) state.clone();
			List<Piece> stateList = newState.getStateList();
			Hashtable<Integer, Piece> pieceList = newState.getPieceList();
			
			int fromK = Utility.getOneDimention(fromX, fromY);
			int toK = Utility.getOneDimention(toX, toY);
			Piece pieceFrom = stateList.get(fromK);
			Piece pieceTo = stateList.get(toK);
			
			stateList.set(toK, pieceFrom);
			stateList.set(fromK, PieceFactory.getPiece(0, fromX, fromY));
			pieceList.remove(pieceTo.getNumber());
//			state.evaluateValue();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newState;
	}
	
	

}
