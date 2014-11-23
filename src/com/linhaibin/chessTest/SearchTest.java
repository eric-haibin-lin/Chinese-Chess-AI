package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.Search;
import com.linhaibin.chess.State;

public class SearchTest {

	State state;
	@Before
	public void setUp() throws Exception {
		state = new State();
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testLevelOne() {
//		State chosenState = (Search.minMaxSearch(state, 1));
//		System.out.println(chosenState);
//		System.out.println(chosenState.getValue());
//		assert(true);
//	}
//	
//
	@Test
	public void testLevelFour() {
		State chosenState = (Search.minMaxSearch(state, 3));
		System.out.println(chosenState);
		System.out.println(chosenState.getValue());
		assert(true);
	}

}
