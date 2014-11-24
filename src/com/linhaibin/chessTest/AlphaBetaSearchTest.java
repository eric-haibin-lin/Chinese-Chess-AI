package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.AlphaBetaSearch;
import com.linhaibin.chess.MinMaxSearch;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class AlphaBetaSearchTest {

	State state;
	@Before
	public void setUp() throws Exception {
		state = new State();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLevelOne() {
		State chosenState = (AlphaBetaSearch.doSearch(state, 1));
		System.out.println(chosenState);
		assert(true);
	}
	@Test
	public void testLevelTwo() {
		State chosenState = (AlphaBetaSearch.doSearch(state, 2));
		System.out.println(chosenState);
		assert(true);
	}
	
	@Test
	public void testLevelThree() {
		State chosenState = (AlphaBetaSearch.doSearch(state, 3));
		System.out.println(chosenState);
		assert(true);
	}
	@Test
	public void testLevelFour() {
		State chosenState = (AlphaBetaSearch.doSearch(state, 4));
		System.out.println(chosenState);
		assert(true);
	}
	
	@Test
	public void testLevelFive() {
		State chosenState = (AlphaBetaSearch.doSearch(state, 5));
		System.out.println(chosenState);
		assert(true);
	}

	@Test
	public void testLevelThreeKill() {
		State midState;
		int fromX = 0;
		int fromY = 9;
		int toX = 4;
		int toY = 3;
		
		midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		State chosenState = (AlphaBetaSearch.doSearch(midState, 4));
		System.out.println(chosenState);
		assert(true);
	}
}
