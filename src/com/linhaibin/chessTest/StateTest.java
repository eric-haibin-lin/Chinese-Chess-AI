package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.Piece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;
import com.linhaibin.chess.Utility;

public class StateTest {

	State state;
	
	@Before
	public void setUp() throws Exception {
		State.initializePieceStateList();
		state = new State();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(State.initStateList.toString());
		assert(true);
	}
	
	@Test
	public void testPieceList() {
		int fromX = 1;
		int fromY = 9;
		int toX = 2;
		int toY = 7;
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		Hashtable<Integer, Piece> pieceList = midState.getPieceList();
		Utility.debug(pieceList);
		
		int toXSuicide = 3;
		int toYSuicide = 9;
		
		midState = UserMove.movePiece(midState, toX, toY, toXSuicide, toYSuicide);
		pieceList = midState.getPieceList();
		Utility.debug(pieceList);
		
		assert(true);
	}
	
	
	
	
}
