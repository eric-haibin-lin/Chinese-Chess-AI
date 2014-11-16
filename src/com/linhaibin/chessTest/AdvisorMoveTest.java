package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.*;

public class AdvisorMoveTest {
	private State state;
	private AdvisorMove advisorMove;
	@Before
	public void setUp() throws Exception {
		state = new State();
		advisorMove = new AdvisorMove();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int fromX = 3;
		int fromY = 9;
		advisorMove.generateAllMove(state, fromX, fromY);
		assert(true);
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 3;
		int fromY = 9;
		List<State> newStateList = advisorMove.generateAllMove(state, fromX, fromY);
		Utility.debug(newStateList.toString());
		assert(true);
	}

	@Test
	public void testGenerateAllMid() {
		int fromX = 3;
		int fromY = 9;
		int toX = 4;
		int toY = 8;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<State> newStateList = advisorMove.generateAllMove(midState, toX, toY);
		
		Utility.debug(newStateList.toString());
		assert(true);
	}
	
}
