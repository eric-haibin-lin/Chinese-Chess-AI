package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.*;

public class AdvisorMoveTest {
	private State state;
	private AdvisorPiece advisorPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		advisorPiece = new AdvisorPiece(18);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	

	@Test
	public void test() {
		int fromX = 3;
		int fromY = 9;
		advisorPiece.generateAllMove(state, fromX, fromY);
		assert(true);
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 3;
		int fromY = 9;
		List<State> newStateList = advisorPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newStateList.size(), 1);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 3;
		int fromY = 9;
		int toX = 4;
		int toY = 8;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<State> newStateList = advisorPiece.generateAllMove(midState, toX, toY);
		assertEquals(newStateList.size(), 3);
	}
	
}
