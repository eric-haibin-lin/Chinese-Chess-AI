package com.linhaibin.chess;

import java.util.Scanner;

public class Game {
	
	//UI related constant
	private static final String selectTargetString = "Please select a piece to move... \n";
	private static final String selecttargetLocationString = "Please specify the target position... \n";
	private static final String xyPositionString = "x(0~8), y(0~9): ";
	
	public static int USER_TURN = 16;
	public static int COMP_TURN = 32;
	public static int EMPTY_SPACE = 0;
	
	//game related variables
	private State currentState;
	
	public Game() {	
		this.currentState = new State();
	}
	
	public void run(){
		
		this.printWelcome();
		
		Scanner reader = new Scanner(System.in);
		
		while(true){
			this.printStatePlain(this.currentState);
			if (testWin(currentState))	return;
			System.out.print(selectTargetString);
			System.out.print(xyPositionString);
			int fromX = reader.nextInt();
			int fromY = reader.nextInt();
			
			System.out.print(selecttargetLocationString);
			System.out.print(xyPositionString);
			int toX = reader.nextInt();
			int toY = reader.nextInt();		
			
			int moveStatus = this.handleUserMove(currentState, fromX, fromY, toX, toY);
			if (moveStatus == MoveError.NO_ERROR){
				this.printStatePlain(this.currentState);
				if (testWin(currentState))	return;
				System.out.println("Now it's Computer's turn... ");
				currentState = (AlphaBetaSearch.doSearch(currentState, 4));
			}

			else MoveError.printError(moveStatus);
		}
	}
	
	private int handleUserMove(State state, int fromX, int fromY, int toX, int toY){
		int moveStatus = MoveError.NO_ERROR;
		int fromK = Utility.getOneDimention(fromX, fromY);
		Piece piece = currentState.getPieceList().get(fromK);
		if (piece.getSide() == Game.EMPTY_SPACE){
			moveStatus = MoveError.WRONG_PIECE;
		} else if (piece.getSide() != Game.USER_TURN){
			moveStatus = MoveError.WRONG_PIECE;
		} else if (!PieceMove.movePieceLegal(state, fromX, fromY, toX, toY)){
			moveStatus = MoveError.ILLEGAL_MOVE;
		}	
		return moveStatus;
	}
	
	void printWelcome(){
		System.out.println(
				"Welcome to Eric Haibin Lin's Chinese Chess. \n" + 
				"K => King,\t" + 
				"A => Advisor,\t" + 
				"B => Bishop,\t" + 
				"N => Knight,\t" + 
				"R => Rook,\t" + 
				"P => Pawn\t\n" 
		);
	}
	
	//For 9*10 board
	void printStatePlain(State state){
		System.out.println(state.toString());
	}
	
	private boolean testWin(State state){
		int winner = currentState.getWinner(); 
		if (winner == Game.COMP_TURN){
			System.out.println("Computer Wins!");
			return true;
		}
		else if (winner == Game.USER_TURN){
			System.out.println("You Win!");
			return true;
		}
		else return false;
	}

}
