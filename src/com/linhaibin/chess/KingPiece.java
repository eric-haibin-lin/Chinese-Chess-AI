package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KingPiece extends AbstractPiece implements Piece {
	private static boolean DEBUG_PRINT = false;
	private static List<DirectionMove> moveDirection = Arrays.asList(new DirectionMove(-1,0), new DirectionMove(+1,0), new DirectionMove(0,-1), new DirectionMove(0,+1));
	private static List<Integer> LegalPosition = Arrays.asList(
			0,0,0,1,1,1,0,0,0,   
			0,0,0,1,1,1,0,0,0,     
			0,0,0,1,1,1,0,0,0,   
			0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,     
			
			0,0,0,0,0,0,0,0,0,     
			0,0,0,0,0,0,0,0,0,
			0,0,0,1,1,1,0,0,0,    
			0,0,0,1,1,1,0,0,0,    
			0,0,0,1,1,1,0,0,0);
	
	private static int EXISTENCE_VALUE = 10000;
	private static int MOBILITY_VALUE = 2;
	
	@Override
	public int evaluateMobility(State state, int fromX, int fromY){
		return generateAllMove(state, fromX, fromY).size() * MOBILITY_VALUE;
	}
	
	@Override
	public int evaluateExistence() {
		int value = (side == Game.USER_TURN) ? EXISTENCE_VALUE : (-1 * EXISTENCE_VALUE);
		return value;
	}
	
	public KingPiece(int number) {
		super(number);
	}
	
	public KingPiece(int number, int x, int y) {
		super(number,x,y);
	}
	
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "K";
		else return "k";
	}
	@Override
	public int evaluateStatic(int x, int y){
		int k = Utility.getOneDimention(x, y);
		int value = (side == Game.USER_TURN) ? Evaluate.redKingPositionValue.get(k) : (-1 * Evaluate.blackKingPositionValue.get(k));
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
			if (!isOnBoard(toX, toY))	continue;
			int toK = Utility.getOneDimention(toX, toY);
			int fromSide = pieceList.get(fromK).getSide();
			int toSide = pieceList.get(toK).getSide();
			if (LegalPosition.get(toK).equals(1) && (fromSide != toSide)){
				Move newMove = new Move(fromX, fromY, toX, toY);
				newMoveList.add(newMove);
			}	
		}
		if (this.getSide() == Game.USER_TURN){
			int i;
			for (i = 0; i<3; i++){
				if (pieceList.get(Utility.getOneDimention(fromX, i)).getClass() == KingPiece.class)	break;
			}
			if (i < 3 && cleanPath(state, fromX, i+1, fromY-1)) {
				Move newMove = new Move(fromX, fromY, fromX, i);
				newMoveList.add(newMove);
			}
			else return newMoveList;
				
		}
		else if (this.getSide() == Game.COMP_TURN){
			int i;
			for (i = 9; i>6; i--){
				if (pieceList.get(Utility.getOneDimention(fromX, i)).getClass() == KingPiece.class)	break;
			}
			if (i > 6 && cleanPath(state, fromX, fromY+1, i-1)) {
				Move newMove = new Move(fromX, fromY, fromX, i);
				newMoveList.add(newMove);
			}
			else return newMoveList;
		} 
		return newMoveList;
	}
	
	private boolean cleanPath(State state, int x, int fromY, int toY){
		PieceMap<Integer, Piece> pieceList = state.getPieceList();
		for(int i = fromY; i <= toY; i++){
			if (pieceList.get(Utility.getOneDimention(x, i)).getClass() != EmptyPiece.class)	return false;
		}
		return true;
	}
	
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		
		if (!AbstractPiece.isLegalBasic(state, fromX, fromY, toX, toY)) return false;
		
		int toK = Utility.getOneDimention(toX, toY);
		if (!LegalPosition.get(toK).equals(1)) return false;
		if (fromX == toX && Utility.abs(fromY-toY)>4){
			if (fromY > toY)
				return cleanPath(state, fromX, toY+1, fromY -1);
			else 
				return cleanPath(state, fromX, fromY+1, toY -1);
		}
		if (Utility.distanceSquare(fromX, fromY, toX, toY) != 1) return false;
		else return true;
	}
	
	
}
