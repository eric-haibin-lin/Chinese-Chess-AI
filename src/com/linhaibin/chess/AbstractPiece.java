package com.linhaibin.chess;

import java.util.List;

public class AbstractPiece implements Cloneable{

	int number;
	int side;
	int x;
	int y;
	int k;
	
	public int getK(){
		return this.k;
	}
	
	public AbstractPiece(int number){
		this.number = number;
		setSide();
	}
	
	public AbstractPiece(int number, int x, int y) {
		this.number = number;
		this.x = x;
		this.y = y;
		this.k = Utility.getOneDimention(x, y);
		setSide();
	}
	
	public int getNumber() {
		return this.number;
	}

	private void setSide(){
		if (number == 0) this.side = Game.EMPTY_SPACE;
		else if ((number & Game.USER_TURN) == Game.USER_TURN)	this.side = Game.USER_TURN; 
		else	this.side = Game.COMP_TURN;
	}
	
	public int getSide() {
		return this.side;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int evaluateStatic(int x, int y) {
		return 0;
	}
	
	public int evaluateExistence() {
		return 0;
	}

	public int evaluateMobility(State state, int fromX, int fromY){
		return 0;
	}
	
	public List<Move> generateAllMove(State state, int fromX, int fromY) {
		return null;
	}
	
	@Override
	public Object clone(){
		Object returnObj = null;
		try {
			returnObj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return returnObj;
	}
	
	private static boolean suicide(State state, int fromX, int fromY, int toX, int toY){
		PieceMap<Integer, Piece> pieceList = state.getPieceList();
		Piece sourcePiece = pieceList.get(Utility.getOneDimention(fromX, fromY));
		Piece targetPiece = pieceList.get(Utility.getOneDimention(toX, toY));
		if (sourcePiece.getSide() == targetPiece.getSide()) return true;
		else return false;
	}
	
	protected static boolean isLegalBasic(State state, int fromX, int fromY, int toX, int toY){
		if (!isOnBoard(toX, toY)) return false;
		if (suicide(state, fromX, fromY, toX, toY)) return false;
		if (standStill(fromX, fromY, toX, toY)) return false;
		else return true;
	}
	public void setPosition(int x, int y ){
		this.x = x;
		this.y = y;
		this.k = Utility.getOneDimention(x, y);
	}
	
	private static boolean standStill(int x1, int y1, int x2, int y2){
		if (x1== x2 && y1 == y2) return true;
		else return false;
	}
	
	protected static boolean isOnBoard(int x, int y){
		return (x <= 8 && x >= 0 && y <= 9 && y >= 0);
	}
	
	
}
