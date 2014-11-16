package com.linhaibin.chess;

import java.util.List;

public class UserMove{

	public UserMove() {
		// TODO Auto-generated constructor stub
	}

	public static State movePiece(State state, int fromX, int fromY, int toX, int toY) {
		List<Integer> stateList = state.getStateList();
		int fromK = Utility.getOneDimention(fromX, fromY);
		int toK = Utility.getOneDimention(toX, toY);
		stateList.set(toK, stateList.get(fromK));
		stateList.set(fromK, 0);
		return state;
	}

}
