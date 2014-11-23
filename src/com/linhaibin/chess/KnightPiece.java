package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightPiece extends AbstractPiece implements Piece {
	private static boolean DEBUG_PRINT = false;
	private static List<DirectionMove> moveDirection = Arrays.asList(
			new DirectionMove(-2,-1), new DirectionMove(-2,+1), 
			new DirectionMove(-1,-2), new DirectionMove(-1,+2), 
			new DirectionMove(+1,-2), new DirectionMove(+1,+2),
			new DirectionMove(+2,-1), new DirectionMove(+2,+1));
	
	public KnightPiece(int number) {
		super(number);
	}
	
	
	public KnightPiece(int number, int x, int y) {
		super(number,x,y);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "N";
		else return "n";
	}
	
	@Override
	public int evaluateStatic(int x, int y){
		int k = Utility.getOneDimention(x, y);
		int value = (side == Game.USER_TURN) ? Evaluate.redKnightPositionValue.get(k) : (-1 * Evaluate.blackKnightPositionValue.get(k));
		return value;
	}
	@Override
	public List<State> generateAllMove(State state, int fromX, int fromY) {
		List<State> newStateList = new ArrayList<State>();
		List<Piece> stateList = state.getStateList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<8; i++){
			int toX = fromX + moveDirection.get(i).x;
			int toY = fromY + moveDirection.get(i).y;
			if (!Utility.isOnBoard(toX, toY))	continue;
			int obstacleX = fromX + moveDirection.get(i).x / 2;
			int obstacleY = fromY + moveDirection.get(i).y / 2;
			if (!stateList.get(Utility.getOneDimention(obstacleX, obstacleY)).getClass().equals(EmptyPiece.class)) 	continue;
			int toK = Utility.getOneDimention(toX, toY);
			int fromSide = stateList.get(fromK).getSide();
			int toSide = stateList.get(toK).getSide();
			if (fromSide != toSide){
				State newState = UserMove.movePiece(state, fromX, fromY, toX, toY);
				if (KnightPiece.DEBUG_PRINT){
					//Legal move
					Utility.debug(i);
					Utility.debug(newState.toString());
					Utility.debug("\n");
				}
				newStateList.add(newState);
			}	
		}
		return newStateList;	
	}
	
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY){
		if (!AbstractPiece.isLegalBasic(state, fromX, fromY, toX, toY)) return false;
		
		List<Piece> stateList = state.getStateList();

		if (Utility.distanceSquare(fromX, fromY, toX, toY) != 5) return false;
		
		int obstacleX = (fromX + toX) / 2;
		int obstacleY = (fromY + toY) / 2;
		if (!stateList.get(Utility.getOneDimention(obstacleX, obstacleY)).getClass().equals(EmptyPiece.class)) 	return false;
		
		else return true;
	}
}
