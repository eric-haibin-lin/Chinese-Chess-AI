package com.linhaibin.chess;

public class MoveError {

	public MoveError() {
	}
	public static final int NO_ERROR = 0;
	public static final int WRONG_PIECE = -1;
	public static final int ILLEGAL_MOVE = -2;
	public static void printError(int error){
		System.out.println("Error: " + error);
	}
}

