package com.linhaibin.chess;

import java.util.List;
import java.util.Scanner;

public class Game {
	
	//UI related constant
	private static final String selectTargetString = "Please select a piece to move... \n";
	private static final String selecttargetLocationString = "Please specify the target position... \n";
	private static final String xyPositionString = "x(0~8), y(0~9): ";
	
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
			System.out.print(selectTargetString);
			System.out.print(xyPositionString);
			int fromX = reader.nextInt();
			int fromY = reader.nextInt();
			
			System.out.print(selecttargetLocationString);
			System.out.print(xyPositionString);
			int toX = reader.nextInt();
			int toY = reader.nextInt();		
			
			int moveStatus = this.handleUserMove(currentState, fromX, fromY, toX, toY);
			Utility.debug(moveStatus);
			if (moveStatus == MoveError.NO_ERROR){
				this.printStatePlain(this.currentState);
			}
				//system move piece
				//success:
				//	printState
				//	generateAllMove
				//	selectBestMove
				//	doMove
				//	printState
			else this.printError(moveStatus);
			//fail:
			//	printError
			// 	continue
		}
		
	}
	
	private int handleUserMove(State state, int fromX, int fromY, int toX, int toY){
		int moveStatus = 0;
		int fromK = Utility.getOneDimention(fromX, fromY);
		int piece = currentState.getStateList().get(fromK);
		StringBuffer buffer = new StringBuffer();
		switch(piece){
			case 16:	buffer.append("K"); break;
			case 17:	
			case 18:	buffer.append("A"); break;
			case 19:	
			case 20:	buffer.append("B"); break;
			case 21:	
			case 22:	buffer.append("N"); break;
			case 23:	
			case 24:	buffer.append("R"); break;
			case 25:	
			case 26:	buffer.append("C"); break;
			case 27:	
			case 28:
			case 29:
			case 30:
			case 31:	buffer.append("P"); break;
			case 0:		buffer.append("There's no piece."); moveStatus = MoveError.WRONG_PIECE; break;
			default: 	buffer.append("This is not your piece."); moveStatus = MoveError.WRONG_PIECE; break;
		}		
		state = UserMove.movePiece(state, fromX, fromY, toX, toY);
		return moveStatus;
	}
	
	
	void printWelcome(){
		System.out.println(
				"Welcome to Eric's Chinese Chess. \n" + 
				"K => King,\t" + 
				"A => Advisor,\t" + 
				"B => Bishop,\t" + 
				"N => Knight,\t" + 
				"R => Rook,\t" + 
				"P => Pawn\t\n" 
		);
	}
	
	//For 16*16 board
	void printStateExtended(State state){
		System.out.println(state.toStringExtended());
	}
	
	//For 9*10 board
	void printStatePlain(State state){
		List<Integer> stateList = state.getStateList();
		System.out.println(state.toString());
	}
	
	void printError(int error){
		System.out.println("Error: " + error);
	}
}
