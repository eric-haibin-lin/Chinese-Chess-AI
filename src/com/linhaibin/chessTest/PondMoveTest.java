package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.KingPiece;
import com.linhaibin.chess.PondPiece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class PondMoveTest {

	private State state;
	private PondPiece pondPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		pondPiece = new PondPiece(27);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 0;
		int fromY = 6;
		List<State> newStateList = pondPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newStateList.size(), 1);
	}

	@Test
	public void testGenerateNumberAllLeft() {
		int fromX = 0;
		int fromY = 6;
		int toX = 0;
		int toY = 4;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<State> newStateList = pondPiece.generateAllMove(midState, toX, toY);
		assertEquals(newStateList.size(), 2);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 2;
		int fromY = 6;
		int toX = 2;
		int toY = 4;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<State> newStateList = pondPiece.generateAllMove(midState, toX, toY);
		assertEquals(newStateList.size(), 3);
	}

}
