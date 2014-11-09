package com.linhaibin.chess;

import java.util.Arrays;
import java.util.Hashtable;
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
	*/
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
	
	
	
	List<Integer> stateList;
	public static Hashtable<Integer, Boolean> stateListHashtable;
	
	public State() {
		this.stateList = initStateList;
		
	}
	
	public List<Integer> getStateList(){
		return this.stateList;
	}
	

}
