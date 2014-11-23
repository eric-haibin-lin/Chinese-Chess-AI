package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.Game;
import com.linhaibin.chess.Piece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;
import com.linhaibin.chess.Utility;

public class StateTest {

	State state;
	State anotherState;
	
	@Before
	public void setUp() throws Exception {
		State.initializePieceStateList();
		state = new State();
		anotherState = new State();
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
		ConcurrentHashMap<Integer, Piece> pieceList = midState.getPieceList();
		int sizeBefore = pieceList.size();
		
		int toXSuicide = 3;
		int toYSuicide = 9;
		
		midState = UserMove.movePiece(midState, toX, toY, toXSuicide, toYSuicide);
		pieceList = midState.getPieceList();
		int sizeAfter = pieceList.size();
		
		assertEquals(sizeBefore, sizeAfter + 1);
	}
	
	@Test
	public void testGenerateAllState(){
		List<State> childStates = state.generateAllState(Game.COMP_TURN);
		List<State> anotherChildStates = anotherState.generateAllState(Game.USER_TURN);
		assertEquals(childStates.size(), anotherChildStates.size());
		assertEquals(childStates.size(), 44);
	}
}
