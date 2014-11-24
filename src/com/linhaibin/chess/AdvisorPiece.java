package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvisorPiece extends AbstractPiece implements Piece {

	private static boolean DEBUG_PRINT = false;
	private static List<Integer> LegalPosition = Arrays.asList(
			0,0,0,1,0,1,0,0,0,   
			0,0,0,0,1,0,0,0,0,     
			0,0,0,1,0,1,0,0,0,   
			0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,     
			
			0,0,0,0,0,0,0,0,0,     
			0,0,0,0,0,0,0,0,0,
			0,0,0,1,0,1,0,0,0,    
			0,0,0,0,1,0,0,0,0,    
			0,0,0,1,0,1,0,0,0);
	
	private static List<DirectionMove> moveDirection = Arrays.asList(new DirectionMove(-1,-1), new DirectionMove(-1,+1), new DirectionMove(+1,-1), new DirectionMove(+1,+1));
	private static int EXISTENCE_VALUE = 20;
	
	public AdvisorPiece(int number) {
		super(number);
	}
	
	public AdvisorPiece(int number, int x, int y) {
		super(number,x,y);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "A";
		else return "a";
	}
	
	@Override
	public int evaluateExistence() {
		int value = (side == Game.USER_TURN) ? EXISTENCE_VALUE : (-1 * EXISTENCE_VALUE);
		return value;
	}
	
	@Override
	public int evaluateStatic(int x, int y){
		int k = Utility.getOneDimention(x, y);
		int value = (side == Game.USER_TURN) ? Evaluate.redAdvisorPositionValue.get(k) : (-1 * Evaluate.blackAdvisorPositionValue.get(k));
		return value;
	}


	@Override
	public List<Move> generateAllMove(State state, int fromX, int fromY) {
		
		List<Move> newMoveList = new ArrayList<Move>();
		PieceMap<Integer, Piece> pieceList = state.getPieceList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<4; i++){
			int toX = fromX + moveDirection.get(i).x;
			int toY = fromY + moveDirection.get(i).y;
			if (isOnBoard(toX, toY)){
				int toK = Utility.getOneDimention(toX, toY);
				int fromSide = pieceList.get(fromK).getSide();
				int toSide = pieceList.get(toK).getSide();
				if (LegalPosition.get(toK).equals(1) && (fromSide != toSide)){
					Move newMove = new Move(fromX, fromY, toX, toY);
					newMoveList.add(newMove);
				}	
			}	
		}
		
		return newMoveList;	
	}
	
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		
		if (!AbstractPiece.isLegalBasic(state, fromX, fromY, toX, toY)) return false;
		
		int toK = Utility.getOneDimention(toX, toY);
		if (!LegalPosition.get(toK).equals(1)) return false;
		if (Utility.distanceSquare(fromX, fromY, toX, toY) != 2) return false;
		else return true;
	}
	
}