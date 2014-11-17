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
	
	public KingPiece(int number) {
		super(number);
	}
	
	@Override
	public String toString(){
		if (side == Game.USER_TURN) return "K";
		else return "k";
	}
	@Override
	public int evaluateStatic(int k){
		int value = (side == Game.USER_TURN) ? Evaluate.redKingPositionValue.get(k) : (-1 * Evaluate.blackKingPositionValue.get(k));
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
			int toK = Utility.getOneDimention(toX, toY);
			int fromSide = stateList.get(fromK).getSide();
			int toSide = stateList.get(toK).getSide();
			if (LegalPosition.get(toK).equals(1) && (fromSide != toSide)){
				State newState = UserMove.movePiece(state, fromX, fromY, toX, toY);
				if (KingPiece.DEBUG_PRINT){
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
}
