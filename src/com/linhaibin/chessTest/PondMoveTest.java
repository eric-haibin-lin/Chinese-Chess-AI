package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.linhaibin.chess.KingPiece;
import com.linhaibin.chess.Move;
import com.linhaibin.chess.PondPiece;
import com.linhaibin.chess.State;
import com.linhaibin.chess.UserMove;

public class PondMoveTest {

	private State state;
	private PondPiece pondPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		pondPiece = new PondPiece(27);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 0;
		int fromY = 6;
		List<Move> newMoveList = pondPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newMoveList.size(), 1);
	}

	@Test
	public void testGenerateNumberAllLeft() {
		int fromX = 0;
		int fromY = 6;
		int toX = 0;
		int toY = 4;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<Move> newMoveList = pondPiece.generateAllMove(midState, toX, toY);
		assertEquals(newMoveList.size(), 2);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 2;
		int fromY = 6;
		int toX = 2;
		int toY = 4;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		List<Move> newMoveList = pondPiece.generateAllMove(midState, toX, toY);
		assertEquals(newMoveList.size(), 3);
	}
	

	@Test
	public void testLegalMove() {
		int fromX = 4;
		int fromY = 6;
		int toX = 4;
		int toY = 5;
		assertEquals(true,pondPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testLegalMoveSuicide() {
		int fromX = 1;
		int fromY = 9;
		int toX = 2;
		int toY = 5;
		
		State midState = UserMove.movePiece(state, fromX, fromY, toX, toY);
		int fromXFinal = 2;
		int fromYFinal = 6;
		
		assertEquals(false,pondPiece.isLegalMove(midState, fromXFinal, fromYFinal, toX, toY));
	}
	
	@Test
	public void testIllegalMove() {
		int fromX = 4;
		int fromY = 6;
		int toX = 5;
		int toY = 6;
		
		assertEquals(false,pondPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	
	@Test
	public void testIllegalMoveAcross() {
		int fromX = 4;
		int fromY = 6;
		int toX = 5;
		int toY = 4;
		
		assertEquals(false,pondPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}

}
