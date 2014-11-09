package com.linhaibin.chess;

interface Move {
	public State movePiece(State state, int fromX, int fromY, int toX, int toY);
	public boolean isMoveValid(State state, int fromX, int fromY, int toX, int toY);
	public void generateAllMove(State state);
}
