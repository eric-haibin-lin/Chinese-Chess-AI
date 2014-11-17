package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class State {
	
	/*
	public static final int KING_RED = 16;
	public static final int GUARD_RED = 18;
	public static final int MINISTER_RED = 20;
	public static final int ROOK_RED = 22;
	public static final int KNIGHT_RED = 24;
	public static final int CANNON_RED = 26;
	public static final int PAWN_RED = 31;
	
	public static final int KING_BLACK = 32;
	public static final int GUARD_BLACK = 34;
	public static final int MINISTER_BLACK = 36;
	public static final int ROOK_BLACK = 38;
	public static final int KNIGHT_BLACK = 40;
	public static final int CANNON_BLACK = 42;
	public static final int PAWN_BLACK = 47;

	//For 16*16 extended board
	public static List<Integer> initStateList = Arrays.asList(
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			
			0,0,0,     39,37,35,33,32,34,36,38,40,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,41,0,0,0,0,0,42,0,     0,0,0,0,
			0,0,0,     43,0,44,0,45,0,46,0,47,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     27,0,28,0,29,0,30,0,31,     0,0,0,0,
			0,0,0,     0,25,0,0,0,0,0,26,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     23,21,19,17,16,18,20,22,24,     0,0,0,0,
			
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0);
		*/
	
	public static List<Integer> initIntList = Arrays.asList(
			39,37,35,33,32,34,36,38,40,   
			0,0,0,0,0,0,0,0,0,     
			0,41,0,0,0,0,0,42,0,   
			43,0,44,0,45,0,46,0,47,
			0,0,0,0,0,0,0,0,0,     
			
			0,0,0,0,0,0,0,0,0,     
			27,0,28,0,29,0,30,0,31,
			0,25,0,0,0,0,0,26,0,    
			0,0,0,0,0,0,0,0,0,    
			23,21,19,17,16,18,20,22,24);
	
	
	private static final String riverString = "\t==================================================================\n";
	private static final String coordinateXString = "y \\ x\t0\t1\t2\t3\t4\t5\t6\t7\t8\t\n";
	public static Hashtable<Integer, Boolean> stateListHashtable;
	public static List<Piece> initStateList = new ArrayList<Piece>();
	
	
	List<Piece> stateList;
	private int value;
	
	
	public static void initializePieceStateList(){
		Iterator<Integer> iterator = initIntList.iterator();
		while(iterator.hasNext()){
			Piece piece = PieceFactory.getPiece(iterator.next());
			initStateList.add(piece);
		}
		return;
	}
	
	public State() {
		initState();
//		evaluateValue();
	}
	
	public void initState(){
		if (initStateList.size() == 0) State.initializePieceStateList();
		this.stateList = initStateList;
	}
	
	public List<Piece> getStateList(){
		return this.stateList;
	}
	
	public void evaluateValue(){
		this.value = Evaluate.evaluateState(this);
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String toStringExtended(){
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(coordinateXString);
		buffer.append(riverString);
		
		for (int y = 3; y <= 12; y++){			
			buffer.append(String.valueOf(y-3) + " ||\t");
			
			for (int x = 3; x <= 11; x++){
				int k = x + (y << 4) ;
				Piece piece = stateList.get(k);
				buffer.append(piece.toString());
				buffer.append("\t");
			}
			buffer.append((y == 7) ? ("\n" + riverString) : "\n");
		}
		return (buffer.toString());
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(coordinateXString);
		buffer.append(riverString);
		
		for (int y = 0; y <= 9; y++){			
			buffer.append(String.valueOf(y) + " ||\t");
			for (int x = 0; x <= 8; x++){
				int k = y * 9 + x;
				Piece piece = stateList.get(k);
				buffer.append(piece.toString());
				buffer.append("\t");
			}
			buffer.append((y == 4) ? ("\n" + riverString) : "\n");
		}
		return(buffer.toString());
	}
}
