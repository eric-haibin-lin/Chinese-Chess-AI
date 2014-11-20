package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CannonPiece extends AbstractPiece implements Piece {
	private static boolean DEBUG_PRINT = false;
	private static List<DirectionMove> moveDirection = Arrays.asList(new DirectionMove(-1,0), new DirectionMove(+1,0), new DirectionMove(0,-1), new DirectionMove(0,+1));
	
	public CannonPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "C";
		else return "c";
	}
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redCannonPositionValue.get(k) : (-1 * Evaluate.blackCannonPositionValue.get(k));
		return value;
	}
	
	@Override
	public List<State> generateAllMove(State state, int fromX, int fromY) {
		List<State> newStateList = new ArrayList<State>();
		List<Piece> stateList = state.getStateList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<4; i++){
			boolean hasObstacle = false;
			for (int j = 1; j<=10; j++){
				int toX = fromX + moveDirection.get(i).x * j;
				int toY = fromY + moveDirection.get(i).y * j;
				int toK = Utility.getOneDimention(toX, toY);
				if (!Utility.isOnBoard(toX, toY))	break;
				int fromSide = stateList.get(fromK).getSide();
				int toSide = stateList.get(toK).getSide();
				if (!hasObstacle){
					if (toSide == Game.EMPTY_SPACE) {
						State newState = UserMove.movePiece(state, fromX, fromY, toX, toY);
						newStateList.add(newState);
						if (CannonPiece.DEBUG_PRINT){
							Utility.debug(i);
							Utility.debug(newState.toString());
							Utility.debug("\n");
						}
					}
					else hasObstacle = true;
				}
				else {
					if (fromSide == toSide) break;
					else if (toSide == Game.EMPTY_SPACE) continue;
					else {
						State newState = UserMove.movePiece(state, fromX, fromY, toX, toY);
						newStateList.add(newState);
						if (CannonPiece.DEBUG_PRINT){
							Utility.debug(i);
							Utility.debug(newState.toString());
							Utility.debug("\n");
						}
						break;
					}
					
				}
			}
		}
		return newStateList;	
	}

	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		if (Utility.standStill(fromX, fromY, toX, toY)) return false;
		int toK = Utility.getOneDimention(toX, toY);
		if (!Utility.isOnBoard(toX, toY)) return false;
		if (suicide(state, fromX, fromY, toX, toY)) return false;
		
		List<Piece> stateList = state.getStateList();
		
		if (fromX == toX){
			int lowerBound = (fromY > toY ? toY : fromY)+1;
			int upperBound = (fromY > toY ? fromY : toY)-1;
			int obstacleCount = 0;
			for (int i = lowerBound; i <= upperBound; i++){
				if (!stateList.get(Utility.getOneDimention(fromX, i)).getClass().equals(EmptyPiece.class))	obstacleCount++;
			}
			if (obstacleCount == 1 && ((!stateList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else if (obstacleCount == 0 && ((stateList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else return false;
		}
		else if (fromY == toY){
			int lowerBound = (fromX > toX ? toX : fromX)+1;
			int upperBound = (fromX > toX ? fromX : toX)-1;
			int obstacleCount = 0;
			for (int i = lowerBound; i <= upperBound; i++){
				if (!stateList.get(Utility.getOneDimention(i, fromY)).getClass().equals(EmptyPiece.class))	obstacleCount++;
			}
			if (obstacleCount == 1 && ((!stateList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else if (obstacleCount == 0 && ((stateList.get(toK).getClass().equals(EmptyPiece.class)))) return true;
			else return false;
		} else return false;
	}
	
}
