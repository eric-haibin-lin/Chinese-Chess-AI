package com.linhaibin.chess;

public class MoveError {

	public MoveError() {
	}
	public static final int NO_ERROR = 0;
	public static final int WRONG_PIECE = -1;
	public static final int ILLEGAL_MOVE = -2;
	public static void printError(int error){
		switch(error){
		case WRONG_PIECE: 
			System.out.println("Error: You moved a wrong piece. Please try again.\n");
			break;
		case ILLEGAL_MOVE:
			System.out.println("Error: You moved a piece illegally. Please make sure you follow the rule.\n");
			break;
		}
	}
}

