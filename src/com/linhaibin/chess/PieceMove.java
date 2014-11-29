package com.linhaibin.chess;

public class PieceMove{

	public PieceMove() {
	}

	public static void movePieceNonCloning(State state, Move move) {
		movePieceNonCloning(state, move.fromX, move.fromY, move.toX, move.toY);
	}	
	
	public static void movePieceNonCloning(State state, int fromX, int fromY, int toX, int toY) {

		PieceMap<Integer, Piece> pieceList = state.getPieceList();

		int fromK = Utility.getOneDimention(fromX, fromY);
		int toK = Utility.getOneDimention(toX, toY);
		Piece pieceFrom = (Piece) pieceList.get(fromK).clone();

		pieceList.remove(pieceFrom.getK());
		pieceFrom.setPosition(toX, toY);
		pieceList.put(toK, pieceFrom);
	}
	
	public static State movePiece(State state, Move move) {
		return movePiece(state,  move.fromX, move.fromY, move.toX, move.toY);
	}
	
	public static State movePiece(State state, int fromX, int fromY, int toX, int toY) {
		State newState = null;
		try {
			newState = (State) state.clone();
			
			PieceMap<Integer, Piece> pieceList = newState.getPieceList();
			
			int fromK = Utility.getOneDimention(fromX, fromY);
			int toK = Utility.getOneDimention(toX, toY);
			Piece pieceFrom = (Piece) pieceList.get(fromK).clone();

			pieceList.remove(pieceFrom.getK());
			pieceFrom.setPosition(toX, toY);	
			pieceList.put(toK, pieceFrom);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newState;
	}
	
	public static boolean movePieceLegal(State state, int fromX, int fromY, int toX, int toY) {
		PieceMap<Integer, Piece> pieceList = state.getPieceList();
		
		int fromK = Utility.getOneDimention(fromX, fromY);
		int toK = Utility.getOneDimention(toX, toY);
		Piece pieceFrom = (Piece) pieceList.get(fromK).clone();

		if (pieceFrom.isLegalMove(state, fromX, fromY, toX, toY)){
			pieceList.remove(pieceFrom.getK());
			pieceFrom.setPosition(toX, toY);
			pieceList.put(toK, pieceFrom);
			
			return true;
		}
		else return false;
	}

}
