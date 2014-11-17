package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.BishopPiece;
import com.linhaibin.chess.KnightPiece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class KnightMoveTest {

	private State state;
	private KnightPiece knightPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		knightPiece = new KnightPiece(21);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 1;
		int fromY = 9;
		List<State> newStateList = knightPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newStateList.size(), 2);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 1;
		int fromY = 9;
		int toX = 2;
		int toY = 7;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<State> newStateList = knightPiece.generateAllMove(midState, toX, toY);
		assertEquals(newStateList.size(), 2);
	}
	

	@Test
	public void testSimpleObstacle() {
		int fromX = 1;
		int fromY = 9;
		int toX = 2;
		int toY = 7;
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		
		int fromXObstacle = 2;
		int fromYObstacle = 9;
		int toXObstacle = 2;
		int toYObstacle = 8;
		
		midState = UserMove.movePiece(midState, fromXObstacle, fromYObstacle, toXObstacle, toYObstacle);
		List<State> newStateList = knightPiece.generateAllMove(midState, toX, toY);
		assertEquals(newStateList.size(), 1);
	}
	
}
