package com.linhaibin.chess;

import java.util.List;

interface Move {
	
	public List<State> generateAllMove(State state, int fromX, int fromY);
	
}