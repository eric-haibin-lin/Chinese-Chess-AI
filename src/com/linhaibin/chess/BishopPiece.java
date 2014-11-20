package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BishopPiece extends AbstractPiece implements Piece {

	private static boolean DEBUG_PRINT = false;
	private static List<Integer> LegalPosition = Arrays.asList(
			0,0,1,0,0,0,1,0,0,   
			0,0,0,0,0,0,0,0,0,     
			1,0,0,0,1,0,0,0,1,   
			0,0,0,0,0,0,0,0,0,
			0,0,1,0,0,0,1,0,0,     
			
			0,0,1,0,0,0,1,0,0,   
			0,0,0,0,0,0,0,0,0,     
			1,0,0,0,1,0,0,0,1,   
			0,0,0,0,0,0,0,0,0,
			0,0,1,0,0,0,1,0,0);
	
	private static List<DirectionMove> moveDirection = Arrays.asList(new DirectionMove(-2,-2), new DirectionMove(-2,+2), new DirectionMove(+2,-2), new DirectionMove(+2,+2));

	
	public BishopPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "B";
		else return "b";
	}
	
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redBishopPositionValue.get(k) : (-1 * Evaluate.blackBishopPositionValue.get(k));
		return value;
	}
	
	@Override
	public List<State> generateAllMove(State state, int fromX, int fromY) {
		List<State> newStateList = new ArrayList<State>();
		List<Piece> stateList = state.getStateList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<4; i++){
			int toX = fromX + moveDirection.get(i).x;
			int toY = fromY + moveDirection.get(i).y;
			if (!Utility.isOnBoard(toX, toY))	continue;
			int obstacleX = fromX + moveDirection.get(i).x / 2;
			int obstacleY = fromY + moveDirection.get(i).y / 2;
			if (!stateList.get(Utility.getOneDimention(obstacleX, obstacleY)).getClass().equals(EmptyPiece.class)) 	continue;
			int toK = Utility.getOneDimention(toX, toY);
			int fromSide = stateList.get(fromK).getSide();
			int toSide = stateList.get(toK).getSide();
			if (LegalPosition.get(toK).equals(1) && (fromSide != toSide)){
				State newState = UserMove.movePiece(state, fromX, fromY, toX, toY);
				if (BishopPiece.DEBUG_PRINT){
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
		int toK = Utility.getOneDimention(toX, toY);
		if (!Utility.isOnBoard(toX, toY)) return false;
		if (!LegalPosition.get(toK).equals(1)) return false;
		if (Utility.distanceSquare(fromX, fromY, toX, toY) != 8) return false;
		
		int obstacleX = (fromX + toX) / 2;
		int obstacleY = (fromY + toY) / 2;
		List<Piece> stateList = state.getStateList();
		if (!stateList.get(Utility.getOneDimention(obstacleX, obstacleY)).getClass().equals(EmptyPiece.class)) 	return false;
		
		else return true;
	}
	
}
