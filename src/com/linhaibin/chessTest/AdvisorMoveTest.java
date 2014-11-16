package com.linhaibin.chessTest;

import static org.junit.Assert.*;

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
	
	
}
