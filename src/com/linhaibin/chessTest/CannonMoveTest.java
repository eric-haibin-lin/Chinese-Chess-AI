package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.CannonPiece;
import com.linhaibin.chess.RookPiece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class CannonMoveTest {

	private State state;
	private CannonPiece cannonPiece;

	@Before
	public void setUp() throws Exception {
		state = new State();
		cannonPiece = new CannonPiece(25);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateAllSimple() {
		int fromX = 1;
		int fromY = 7;
		List<State> newStateList = cannonPiece.generateAllMove(state, fromX,
				fromY);
		assertEquals(newStateList.size(), 12);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 1;
		int fromY = 7;
		int toX = 4;
		int toY = 7;

		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
//		System.out.println(midState.toString());
		List<State> newStateList = cannonPiece
				.generateAllMove(midState, toX, toY);
		assertEquals(8,newStateList.size());
	}

}
