package com.linhaibin.chess;

import java.util.List;

public interface Piece{
	public int getNumber();
	public String toString();
	public int getSide();
	public int evaluateStatic(int k);
	public List<State> generateAllMove(State state, int fromX, int fromY);
	public Object clone();
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY);
	
}