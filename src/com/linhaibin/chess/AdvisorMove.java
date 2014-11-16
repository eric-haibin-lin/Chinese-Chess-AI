package com.linhaibin.chess;

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
	
	private static List<Integer> AdvisorDirection = Arrays.asList(-10,-8,+8,+10);
	
	@Override
	public void generateAllMove(State state, int fromX, int fromY) {
		List<Integer> stateList = state.getStateList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		for (int i = 0; i<4; i++){
			int toK = fromK + AdvisorDirection.get(i);
			int fromSide = stateList.get(fromK) & 16;
			int toSide = stateList.get(toK) & 16; 
			if (AdvisorPosition.get(toK).equals(1) && (fromSide != toSide)){
				//Legal move
				Utility.debug("Legal move");
				Utility.debug(i);
				Utility.debug("\n");
			}
			
		}
		
	}

	
	
	
}
