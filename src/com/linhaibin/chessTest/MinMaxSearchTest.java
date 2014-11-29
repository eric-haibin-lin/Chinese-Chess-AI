package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.Game;
import com.linhaibin.chess.MinMaxSearch;
import com.linhaibin.chess.State;
import com.linhaibin.chess.PieceMove;

public class MinMaxSearchTest {

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
		State chosenState = (MinMaxSearch.minMaxSearch(state, 1));
		System.out.println(chosenState);
		assert(true);
	}
	
	@Test
	public void testLevelFour() {
		State chosenState = (MinMaxSearch.minMaxSearch(state, 4));
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
		
		midState = PieceMove.movePiece(state, fromX, fromY, toX, toY);
		State chosenState = (MinMaxSearch.minMaxSearch(midState, 3));
		System.out.println(chosenState);
		assert(true);
	}
}
