package com.linhaibin.chess;

import java.util.List;

public class Game {
	private static String riverString = "\t==================================================================\n";
	private static String coordinateXString = "y \\ x\t0\t1\t2\t3\t4\t5\t6\t7\t8\t\n";
	public Game() {	

	}
	
	void printWelcome(){
		System.out.println(
				"Welcome to Eric's Chinese Chess. \n" + 
				"K => King\n" + 
				"A => Advisor\n" + 
				"B => Bishop\n" + 
				"N => Knight\n" + 
				"R => Rook\n" + 
				"P => Pawn\n" 
		);
	}
	
	void printAsk(){
		System.out.println("Please select a piece to move: \n");
	}
	
	void printState(State state){
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
}
