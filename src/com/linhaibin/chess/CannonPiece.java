package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CannonPiece extends AbstractPiece implements Piece {
	private static boolean DEBUG_PRINT = false;
	private static List<DirectionMove> moveDirection = Arrays.asList(new DirectionMove(-1,0), new DirectionMove(+1,0), new DirectionMove(0,-1), new DirectionMove(0,+1));
	private static int EXISTENCE_VALUE = 90;
	private static int MOBILITY_VALUE = 3;
	
	@Override
	public int evaluateMobility(State state, int fromX, int fromY){
		return generateAllMove(state, fromX, fromY).size() * MOBILITY_VALUE;
	}
	
	@Override
	public int evaluateExistence() {
		int value = (side == Game.USER_TURN) ? EXISTENCE_VALUE : (-1 * EXISTENCE_VALUE);
		return value;
	}
	
	public CannonPiece(int number) {
		super(number);
	}
	
	public CannonPiece(int number, int x, int y) {
		super(number,x,y);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "C";
		else return "c";
	}
	@Override
	public int evaluateStatic(int x, int y){
		int k = Utility.getOneDimention(x, y);
		int value = (side == Game.USER_TURN) ? Evaluate.redCannonPositionValue.get(k) : (-1 * Evaluate.blackCannonPositionValue.get(k));
		return value;
	}
	
	@Override
	public List<Move> generateAllMove(State state, int fromX, int fromY) {
		List<Move> newMoveList = new ArrayList<Move>();
		PieceMap<Integer, Piece> pieceList = state.getPieceList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<4; i++){
			boolean hasObstacle = false;
			for (int j = 1; j<=10; j++){
				int toX = fromX + moveDirection.get(i).x * j;
				int toY = fromY + moveDirection.get(i).y * j;
				int toK = Utility.getOneDimention(toX, toY);
				if (!isOnBoard(toX, toY))	break;
				int fromSide = pieceList.get(fromK).getSide();
				int toSide = pieceList.get(toK).getSide();
				if (!hasObstacle){
					if (toSide == Game.EMPTY_SPACE) {
						Move newMove = new Move(fromX, fromY, toX, toY);
						newMoveList.add(newMove);
					}
					else hasObstacle = true;
				}
				else {
					if (fromSide == toSide) break;
					else if (toSide == Game.EMPTY_SPACE) continue;
					else {
						Move newMove = new Move(fromX, fromY, toX, toY);
						newMoveList.add(newMove);
						break;
					}
					
				}
			}
		}
		return newMoveList;	
	}

	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		
		if (!AbstractPiece.isLegalBasic(state, fromX, fromY, toX, toY)) return false;
		int toK = Utility.getOneDimention(toX, toY);
		PieceMap<Integer, Piece> pieceList = state.getPieceList();
		
		if (fromX == toX){
			int lowerBound = (fromY > toY ? toY : fromY)+1;
			int upperBound = (fromY > toY ? fromY : toY)-1;
			int obstacleCount = 0;
			for (int i = lowerBound; i <= upperBound; i++){
				if (!pieceList.get(Utility.getOneDimention(fromX, i)).getClass().equals(EmptyPiece.class))	obstacleCount++;
			}
			if (obstacleCount == 1 && ((!pieceList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else if (obstacleCount == 0 && ((pieceList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else return false;
		}
		else if (fromY == toY){
			int lowerBound = (fromX > toX ? toX : fromX)+1;
			int upperBound = (fromX > toX ? fromX : toX)-1;
			int obstacleCount = 0;
			for (int i = lowerBound; i <= upperBound; i++){
				if (!pieceList.get(Utility.getOneDimention(i, fromY)).getClass().equals(EmptyPiece.class))	obstacleCount++;
			}
			if (obstacleCount == 1 && ((!pieceList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else if (obstacleCount == 0 && ((pieceList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else return false;
		} else return false;
	}
	
}
