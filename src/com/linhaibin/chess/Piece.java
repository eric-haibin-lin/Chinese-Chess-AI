package com.linhaibin.chess;

public interface Piece {
	public int getNumber();
	public String toString();
	public int getSide();
	public int evaluateStatic(int k);
}
