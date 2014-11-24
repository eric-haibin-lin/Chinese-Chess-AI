package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondPiece extends AbstractPiece implements Piece {
	private static boolean DEBUG_PRINT = false;
	private static List<DirectionMove> moveDirection = Arrays.asList(new DirectionMove(-1,0), new DirectionMove(+1,0), new DirectionMove(0,-1), new DirectionMove(0,+1));
	private static List<Integer> redLegalPosition = Arrays.asList(
			1,1,1,1,1,1,1,1,1,   
			1,1,1,1,1,1,1,1,1,     
			1,1,1,1,1,1,1,1,1,   
			1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1,     
			
			1,0,1,0,1,0,1,0,1,     
			1,0,1,0,1,0,1,0,1,
			0,0,0,0,0,0,0,0,0,    
			0,0,0,0,0,0,0,0,0,    
			0,0,0,0,0,0,0,0,0);
	private static List<Integer> blackLegalPosition = Arrays.asList(
			0,0,0,0,0,0,0,0,0,    
			0,0,0,0,0,0,0,0,0,    
			0,0,0,0,0,0,0,0,0,
			1,0,1,0,1,0,1,0,1,     
			1,0,1,0,1,0,1,0,1,
			
			1,1,1,1,1,1,1,1,1,   
			1,1,1,1,1,1,1,1,1,     
			1,1,1,1,1,1,1,1,1,   
			1,1,1,1,1,1,1,1,1,
			1,1,1,1,1,1,1,1,1);
	
	private static int EXISTENCE_VALUE = 10;
	
	@Override
	public int evaluateExistence() {
		int value = (side == Game.USER_TURN) ? EXISTENCE_VALUE : (-1 * EXISTENCE_VALUE);
		return value;
	}
	public PondPiece(int number) {
		super(number);
	}
	
	public PondPiece(int number, int x, int y) {
		super(number,x,y);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "P";
		else return "p";
	}
	
	@Override
	public int evaluateStatic(int x, int y){
		int k = Utility.getOneDimention(x, y);
		int value = (side == Game.USER_TURN) ? Evaluate.redPondPositionValue.get(k) : (-1 * Evaluate.blackPondPositionValue.get(k));
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
			if (this.getSide() == Game.USER_TURN && moveDirection.get(i).y == 1) continue;
			if (this.getSide() == Game.COMP_TURN && moveDirection.get(i).y == -1) continue;
			if (!isOnBoard(toX, toY))	continue;
			int toK = Utility.getOneDimention(toX, toY);
			int fromSide = pieceList.get(fromK).getSide();
			int toSide = pieceList.get(toK).getSide();
			if (checkLegalPosition(toK) && (fromSide != toSide)){
				Move newMove = new Move(fromX, fromY, toX, toY);
				newMoveList.add(newMove);
			}	
		}
		return newMoveList;	
	}
	
	private boolean checkLegalPosition(int toK){
		if (this.side == Game.USER_TURN) return redLegalPosition.get(toK).equals(1);
		else return blackLegalPosition.get(toK).equals(1);
	}
	
	
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		
		if (!AbstractPiece.isLegalBasic(state, fromX, fromY, toX, toY)) return false;
		
		int toK = Utility.getOneDimention(toX, toY);
		if (!checkLegalPosition(toK)) return false;
		if (Utility.distanceSquare(fromX, fromY, toX, toY) != 1) return false;
		else return true;
	}
	
	
}
