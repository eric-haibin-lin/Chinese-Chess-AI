package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.Evaluate;
import com.linhaibin.chess.State;
import com.linhaibin.chess.Utility;

public class EvaluateTest {

	private State currentState;
	@Before
	public void setUp() throws Exception {
		this.currentState = new State();
	}

	@After
	public void tearDown() throws Exception {
		this.currentState = null;
	}

	@Test
	public void test() {
		int value = Evaluate.evaluateState(currentState);	
		Utility.debug(value);
		assert(true);
	}

}
