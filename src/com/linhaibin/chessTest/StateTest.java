package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.Game;
import com.linhaibin.chess.Move;
import com.linhaibin.chess.Piece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class StateTest {

	State state;
	State anotherState;
	String initStateString = "[r, n, b, a, k, a, b, n, r, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, c, 0, 0, 0, 0, 0, c, 0, p, 0, p, 0, p, 0, p, 0, p, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, P, 0, P, 0, P, 0, P, 0, P, 0, C, 0, 0, 0, 0, 0, C, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, R, N, B, A, K, A, B, N, R, r, n, b, a, k, a, b, n, r, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, c, 0, 0, 0, 0, 0, c, 0, p, 0, p, 0, p, 0, p, 0, p, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, P, 0, P, 0, P, 0, P, 0, P, 0, C, 0, 0, 0, 0, 0, C, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, R, N, B, A, K, A, B, N, R]";
	
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
		assertEquals(initStateString, State.initStateList.toString());
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
		List<Move> newMoveList = state.generateAllMoves(Game.COMP_TURN);
		List<Move> anotherMoveList = anotherState.generateAllMoves(Game.USER_TURN);
		assertEquals(newMoveList.size(), anotherMoveList.size());
		assertEquals(anotherMoveList.size(), 44);
	}
}
