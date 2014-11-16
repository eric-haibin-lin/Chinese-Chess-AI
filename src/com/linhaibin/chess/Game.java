package com.linhaibin.chess;

import java.util.List;
import java.util.Scanner;

public class Game {
	
	//UI related constant
	private static final String riverString = "\t==================================================================\n";
	private static final String coordinateXString = "y \\ x\t0\t1\t2\t3\t4\t5\t6\t7\t8\t\n";
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
		List<Integer> stateList = state.getStateList();
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(coordinateXString);
		buffer.append(riverString);
		
		for (int y = 3; y <= 12; y++){			
			buffer.append(String.valueOf(y-3) + " ||\t");
			
			for (int x = 3; x <= 11; x++){
				int k = x + (y << 4) ;
				int piece = stateList.get(k);
				int side = piece & 16;
				if (side == 16)
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
						default: 	buffer.append("0"); 
					}
				else switch(piece-16){
					case 16:	buffer.append("k"); break;
					case 17:	
					case 18:	buffer.append("a"); break;
					case 19:	
					case 20:	buffer.append("b"); break;
					case 21:	
					case 22:	buffer.append("n"); break;
					case 23:	
					case 24:	buffer.append("r"); break;
					case 25:	
					case 26:	buffer.append("c"); break;
					case 27:	
					case 28:
					case 29:
					case 30:
					case 31:	buffer.append("p"); break;
					default: 	buffer.append("0"); 
				}
				buffer.append("\t");
			}
			buffer.append((y == 7) ? ("\n" + riverString) : "\n");
		}
		System.out.println(buffer.toString());
	}
	
	//For 9*10 board
	void printStatePlain(State state){
		List<Integer> stateList = state.getStateList();
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(coordinateXString);
		buffer.append(riverString);
		
		for (int y = 0; y <= 9; y++){			
			buffer.append(String.valueOf(y) + " ||\t");
			for (int x = 0; x <= 8; x++){
				int k = y * 9 + x;
				int piece = stateList.get(k);
				int side = piece & 16;
				if (side == 16)
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
						default: 	buffer.append("0"); 
					}
				else switch(piece-16){
					case 16:	buffer.append("k"); break;
					case 17:	
					case 18:	buffer.append("a"); break;
					case 19:	
					case 20:	buffer.append("b"); break;
					case 21:	
					case 22:	buffer.append("n"); break;
					case 23:	
					case 24:	buffer.append("r"); break;
					case 25:	
					case 26:	buffer.append("c"); break;
					case 27:	
					case 28:
					case 29:
					case 30:
					case 31:	buffer.append("p"); break;
					default: 	buffer.append("0"); 
				}
				buffer.append("\t");
			}
			buffer.append((y == 4) ? ("\n" + riverString) : "\n");
		}
		System.out.println(buffer.toString());
	}
	
	void printError(int error){
		System.out.println("Error: " + error);
	}
}
