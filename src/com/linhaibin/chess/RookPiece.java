package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RookPiece extends AbstractPiece implements Piece {
	private static boolean DEBUG_PRINT = false;
	private static List<DirectionMove> moveDirection = Arrays.asList(new DirectionMove(-1,0), new DirectionMove(+1,0), new DirectionMove(0,-1), new DirectionMove(0,+1));
	
	public RookPiece(int number) {
		super(number);
	}
	
	public RookPiece(int number, int x, int y) {
		super(number,x,y);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "R";
		else return "r";
	}
	
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redRookPositionValue.get(k) : (-1 * Evaluate.blackRookPositionValue.get(k));
		return value;
	}
	
	@Override
	public List<State> generateAllMove(State state, int fromX, int fromY) {
		List<State> newStateList = new ArrayList<State>();
		List<Piece> stateList = state.getStateList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<4; i++){
			for (int j = 1; j<=10; j++){
				int toX = fromX + moveDirection.get(i).x * j;
				int toY = fromY + moveDirection.get(i).y * j;
				int toK = Utility.getOneDimention(toX, toY);
				if (!Utility.isOnBoard(toX, toY))	break;
				int fromSide = stateList.get(fromK).getSide();
				int toSide = stateList.get(toK).getSide();
				if (fromSide != toSide){
					State newState = UserMove.movePiece(state, fromX, fromY, toX, toY);
					if (RookPiece.DEBUG_PRINT){
						Utility.debug(i);
						Utility.debug(newState.toString());
						Utility.debug("\n");
					}
					newStateList.add(newState);
					if (toSide != Game.EMPTY_SPACE) break;
				}
				else break;
			}
			
		}
		return newStateList;	
	}
	
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		if (!AbstractPiece.isLegalBasic(state, fromX, fromY, toX, toY)) return false;
		
		List<Piece> stateList = state.getStateList();
		if (fromX == toX){
			int lowerBound = (fromY > toY ? toY : fromY)+1;
			int upperBound = (fromY > toY ? fromY : toY)-1;
			for (int i = lowerBound; i <= upperBound; i++){
				if (!stateList.get(Utility.getOneDimention(fromX, i)).getClass().equals(EmptyPiece.class))	return false;
			}
			return true;
		}
		else if (fromY == toY){
			int lowerBound = (fromX > toX ? toX : fromX)+1;
			int upperBound = (fromX > toX ? fromX : toX)-1;
			for (int i = lowerBound; i <= upperBound; i++){
				if (!stateList.get(Utility.getOneDimention(i, fromY)).getClass().equals(EmptyPiece.class))	return false;
			}
			return true;
		} else return false;
	}
	
	
}
