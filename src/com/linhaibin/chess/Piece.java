package com.linhaibin.chess;

import java.util.List;

public interface Piece{
	public int getNumber();
	public String toString();
	public int getSide();
	public int evaluateStatic(int x, int y);
	public int evaluateExistence();
	public List<State> generateAllMove(State state, int fromX, int fromY);
	public Object clone();
	public boolean isLegalMove(State state, int fromX, int fromY, int toX, int toY);
	public int getX();
	public int getY();
	public void setPosition(int x, int y);
}