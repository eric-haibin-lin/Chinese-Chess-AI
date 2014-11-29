package com.linhaibin.chessTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.linhaibin.chess.BishopPiece;
import com.linhaibin.chess.Move;
import com.linhaibin.chess.State;
import com.linhaibin.chess.PieceMove;

public class BishopMoveTest {
	private State state;
	private BishopPiece bishopPiece;
	@Before
	public void setUp() throws Exception {
		state = new State();
		bishopPiece = new BishopPiece(19);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGenerateAllSimple() {
		int fromX = 2;
		int fromY = 9;
		List<Move> newMoveList = bishopPiece.generateAllMove(state, fromX, fromY);
		assertEquals(newMoveList.size(), 2);
	}

	@Test
	public void testGenerateNumberAllMid() {
		int fromX = 2;
		int fromY = 9;
		int toX = 4;
		int toY = 7;
		
		State midState = PieceMove.movePiece(state, fromX, fromY, toX, toY);
		List<Move> newMoveList = bishopPiece.generateAllMove(midState, toX, toY);
		assertEquals(newMoveList.size(), 3);
	}
	
	@Test
	public void testGenerateNumberAllMidNonCloning() {
		int fromX = 2;
		int fromY = 9;
		int toX = 4;
		int toY = 7;
		
		PieceMove.movePieceNonCloning(state, fromX, fromY, toX, toY);
		List<Move> newMoveList = bishopPiece.generateAllMove(state, toX, toY);
		assertEquals(newMoveList.size(), 3);
		PieceMove.movePieceNonCloning(state, toX, toY, fromX, fromY);
	}

	@Test
	public void testSimpleObstacle() {
		int fromX = 2;
		int fromY = 9;
		int toX = 4;
		int toY = 7;
		State midState = PieceMove.movePiece(state, fromX, fromY, toX, toY);
		
		int fromXObstacle = 3;
		int fromYObstacle = 9;
		int toXObstacle = 3;
		int toYObstacle = 8;
		
		midState = PieceMove.movePiece(midState, fromXObstacle, fromYObstacle, toXObstacle, toYObstacle);
		
		List<Move> newMoveList = bishopPiece.generateAllMove(midState, toX, toY);
		assertEquals(newMoveList.size(), 2);
	}
	

	@Test
	public void testSimpleObstacleNonCloning() {
		int fromX = 2;
		int fromY = 9;
		int toX = 4;
		int toY = 7;
		PieceMove.movePieceNonCloning(state, fromX, fromY, toX, toY);
		
		int fromXObstacle = 3;
		int fromYObstacle = 9;
		int toXObstacle = 3;
		int toYObstacle = 8;
		
		PieceMove.movePieceNonCloning(state, fromXObstacle, fromYObstacle, toXObstacle, toYObstacle);
		
		List<Move> newMoveList = bishopPiece.generateAllMove(state, toX, toY);
		assertEquals(newMoveList.size(), 2);
		
		PieceMove.movePieceNonCloning(state, toXObstacle, toYObstacle,fromXObstacle, fromYObstacle);
		PieceMove.movePieceNonCloning(state, toX, toY, fromX, fromY);
	}
	

	@Test
	public void testIllegalMoveSuicide() {
		int fromX = 2;
		int fromY = 9;
		int toX = 4;
		int toY = 7;
		State midState = PieceMove.movePiece(state, fromX, fromY, toX, toY);
		
		int toXSuicide = 6;
		int toYSuicide = 9;
		assertEquals(false,bishopPiece.isLegalMove(midState, toX, toY, toXSuicide, toYSuicide));
	}

	
	@Test
	public void testLegalMove() {
		int fromX = 2;
		int fromY = 0;
		int toX = 4;
		int toY = 2;
		assertEquals(true,bishopPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testIllegalMove() {
		int fromX = 2;
		int fromY = 0;
		int toX = 4;
		int toY = 4;
		
		assertEquals(false,bishopPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	
	@Test
	public void testIllegalMoveAcross() {
		int fromX = 2;
		int fromY = 0;
		int toX = 2;
		int toY = 4;
		
		assertEquals(false,bishopPiece.isLegalMove(state, fromX, fromY, toX, toY));
	}
	
	@Test
	public void testIllegalMoveWithObstacle() {
		int fromXObstacle = 3;
		int fromYObstacle = 9;
		int toXObstacle = 3;
		int toYObstacle = 8;
		
		State midState = PieceMove.movePiece(state, fromXObstacle, fromYObstacle, toXObstacle, toYObstacle);
		
		int fromX = 2;
		int fromY = 9;
		int toX = 4;
		int toY = 9;
		
		assertEquals(false,bishopPiece.isLegalMove(midState, fromX, fromY, toX, toY));
	}
	
}
