package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.AdvisorPiece;
import com.linhaibin.chess.BishopPiece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class BishopMoveTest {
	private State state;
	private BishopPiece bishopPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		bishopPiece = new BishopPiece(19);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 2;
		int fromY = 9;
		List<State> newStateList = bishopPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newStateList.size(), 2);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 2;
		int fromY = 9;
		int toX = 4;
		int toY = 7;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<State> newStateList = bishopPiece.generateAllMove(midState, toX, toY);
		assertEquals(newStateList.size(), 3);
	}
	
}
