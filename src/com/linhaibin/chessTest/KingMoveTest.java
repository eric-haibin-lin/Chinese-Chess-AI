package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.KingPiece;
import com.linhaibin.chess.Move;
import com.linhaibin.chess.State;
import com.linhaibin.chess.PieceMove;

public class KingMoveTest {

	private State state;
	private KingPiece kingPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		kingPiece = new KingPiece(16);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 4;
		int fromY = 9;
		List<Move> newMoveList = kingPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newMoveList.size(), 1);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 4;
		int fromY = 9;
		int toX = 4;
		int toY = 8;
		
		State midState = PieceMove.movePiece(state, fromX, fromY, toX, toY);
		List<Move> newMoveList = kingPiece.generateAllMove(midState, toX, toY);
		assertEquals(newMoveList.size(), 4);
	}
	

	@Test
	public void testLegalMove() {
		int fromX = 4;
		int fromY = 0;
		int toX = 4;
		int toY = 1;
		assertEquals(true,kingPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testLegalMoveSuicide() {
		int fromX = 4;
		int fromY = 0;
		int toX = 5;
		int toY = 0;

		assertEquals(false,kingPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testIllegalMove() {
		int fromX = 4;
		int fromY = 0;
		int toX = 4;
		int toY = 2;
		
		assertEquals(false,kingPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	
	@Test
	public void testIllegalMoveAcross() {
		int fromX = 4;
		int fromY = 0;
		int toX = 3;
		int toY = 1;
		
		assertEquals(false,kingPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	
}
