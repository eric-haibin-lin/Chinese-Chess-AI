package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvisorMove implements Move{

	public AdvisorMove() {
		// TODO Auto-generated constructor stub
	}

	private static List<Integer> AdvisorPosition = Arrays.asList(

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
	
	private static List<DirectionMove> AdvisorDirection = Arrays.asList(new DirectionMove(-1,-1), new DirectionMove(-1,+1), new DirectionMove(+1,-1), new DirectionMove(+1,+1));
	
	@Override
	public List<State> generateAllMove(State state, int fromX, int fromY) {
		
		List<State> newStateList = new ArrayList<State>();
		List<Piece> stateList = state.getStateList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<4; i++){
			int toX = fromX + AdvisorDirection.get(i).x;
			int toY = fromY + AdvisorDirection.get(i).y;
			if (Utility.isOnBoard(toX, toY)){
				int toK = Utility.getOneDimention(toX, toY);
				int fromSide = stateList.get(fromK).getSide();
				int toSide = stateList.get(toK).getSide();
				if (AdvisorPosition.get(toK).equals(1) && (fromSide != toSide)){
					//Legal move
					Utility.debug("Legal move");
					Utility.debug(i);
					Utility.debug("\n");
					State newState = UserMove.movePiece(state, fromX, fromY, toX, toY);
					newStateList.add(newState);
				}	
			}	
		}
		return newStateList;	
	}
	
}
