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
		List<Move> newMoveList = advisorPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newMoveList.size(), 1);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 3;
		int fromY = 9;
		int toX = 4;
		int toY = 8;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<Move> newMoveList = advisorPiece.generateAllMove(midState, toX, toY);
		assertEquals(newMoveList.size(), 3);
	}
	

	@Test
	public void testLegalMove() {
		int fromX = 3;
		int fromY = 9;
		int toX = 4;
		int toY = 8;
		assertEquals(true,advisorPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testLegalMoveSuicide() {
		int fromX = 3;
		int fromY = 9;
		int toX = 4;
		int toY = 8;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		int toXFinal = 5;
		int toYFinal = 9;
		
		assertEquals(false,advisorPiece.isLegalMove(midState, toX, toY, toXFinal, toYFinal));
	}
	
	@Test
	public void testIllegalMove() {
		int fromX = 3;
		int fromY = 9;
		int toX = 5;
		int toY = 7;
		
		assertEquals(false,advisorPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	
	@Test
	public void testIllegalMoveAcross() {
		int fromX = 3;
		int fromY = 9;
		int toX = 3;
		int toY = 0;
		
		assertEquals(false,advisorPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
}
