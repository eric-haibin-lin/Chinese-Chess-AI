package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.*;

public class CloningTest {

	State state = new State();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCloining() {
		int fromX = 3;
		int fromY = 9;
		int toX = 4;
		int toY = 8;
		String before = state.toString();
		UserMove.movePiece(state, fromX, fromY, toX, toY);
		String after = (state.toString());
		assertEquals(before, after);
	}
}
