package com.linhaibin.chess;

public class Move {

	public int fromX;
	public int fromY;
	public int toX;
	public int toY;
	
	public Move(int fromX, int fromY, int toX, int toY){
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
	}
	
	public static Move getReverse(Move move){
		return new Move(move.toX, move.toY, move.fromX, move.fromY);
	}
	
	public String toString(){
		String from = "(" + String.valueOf(fromX) + "," + String.valueOf(fromY) + ")";
		String to = "(" + String.valueOf(toX) + "," + String.valueOf(toY) + ")";
		return from + "->" + to;
	}
}
