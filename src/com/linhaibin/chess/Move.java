package com.linhaibin.chess;

import java.util.List;

interface Move {
	
//	public State movePiece(State state, int fromX, int fromY, int toX, int toY);
//	public boolean isMoveValid(State state, int fromX, int fromY, int toX, int toY);
	public List<State> generateAllMove(State state, int fromX, int fromY);
	
}