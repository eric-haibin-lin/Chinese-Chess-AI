package com.linhaibin.chess;

import java.util.Hashtable;
import java.util.List;

public class UserMove{

	public UserMove() {
	}

	public static State movePiece(State state, Move move) {
		return movePiece(state,  move.fromX, move.fromY, move.toX, move.toY);
	}
	
	public static State movePiece(State state, int fromX, int fromY, int toX, int toY) {
		State newState = null;
		try {
			newState = (State) state.clone();
			
			List<Piece> stateList = newState.getStateList();
			PieceMap<Integer, Piece> pieceList = newState.getPieceList();
			
			int fromK = Utility.getOneDimention(fromX, fromY);
			int toK = Utility.getOneDimention(toX, toY);
			Piece pieceFrom = (Piece) stateList.get(fromK).clone();

			pieceList.remove(pieceFrom.getK());
			stateList.set(fromK, PieceFactory.getPiece(0, fromX, fromY));
			
			pieceFrom.setPosition(toX, toY);
			stateList.set(toK, pieceFrom);			
			pieceList.put(toK, pieceFrom);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newState;
	}
	
	public static boolean movePieceLegal(State state, int fromX, int fromY, int toX, int toY) {
		List<Piece> stateList = state.getStateList();
		PieceMap<Integer, Piece> pieceList = state.getPieceList();
		
		int fromK = Utility.getOneDimention(fromX, fromY);
		int toK = Utility.getOneDimention(toX, toY);
		Piece pieceFrom = stateList.get(fromK);

		if (pieceFrom.isLegalMove(state, fromX, fromY, toX, toY)){
			Piece pieceTo = stateList.get(toK);
			pieceFrom.setPosition(toX, toY);
			stateList.set(toK, pieceFrom);
			pieceList.replace(pieceFrom.getNumber(), pieceFrom);
			stateList.set(fromK, PieceFactory.getPiece(0, fromX, fromY));
			pieceList.remove(pieceTo.getNumber());
			return true;
		}
		else return false;
	}

}
