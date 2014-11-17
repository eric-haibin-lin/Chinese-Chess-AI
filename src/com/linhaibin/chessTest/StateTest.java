package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.State;

public class StateTest {

	@Before
	public void setUp() throws Exception {
		State.initializePieceStateList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(State.initStateList.toString());
		assert(true);
	}
}
