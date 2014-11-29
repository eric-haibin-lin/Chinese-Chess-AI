package com.linhaibin.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class State implements Cloneable{
	
	/*
	public static final int KING_RED = 16;
	public static final int GUARD_RED = 18;
	public static final int MINISTER_RED = 20;
	public static final int ROOK_RED = 22;
	public static final int KNIGHT_RED = 24;
	public static final int CANNON_RED = 26;
	public static final int PAWN_RED = 31;
	
	public static final int KING_BLACK = 32;
	public static final int GUARD_BLACK = 34;
	public static final int MINISTER_BLACK = 36;
	public static final int ROOK_BLACK = 38;
	public static final int KNIGHT_BLACK = 40;
	public static final int CANNON_BLACK = 42;
	public static final int PAWN_BLACK = 47;

	//For 16*16 extended board, deprecated
	public static List<Integer> initStateList = Arrays.asList(
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			
			0,0,0,     39,37,35,33,32,34,36,38,40,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,41,0,0,0,0,0,42,0,     0,0,0,0,
			0,0,0,     43,0,44,0,45,0,46,0,47,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     27,0,28,0,29,0,30,0,31,     0,0,0,0,
			0,0,0,     0,25,0,0,0,0,0,26,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     23,21,19,17,16,18,20,22,24,     0,0,0,0,
			
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0,
			0,0,0,     0,0,0,0,0,0,0,0,0,     0,0,0,0);
		*/
	
	public static List<Integer> initIntList = Arrays.asList(
			39,37,35,33,32,34,36,38,40,   
			0,0,0,0,0,0,0,0,0,     
			0,41,0,0,0,0,0,42,0,   
			43,0,44,0,45,0,46,0,47,
			0,0,0,0,0,0,0,0,0,     
			
			0,0,0,0,0,0,0,0,0,     
			27,0,28,0,29,0,30,0,31,
			0,25,0,0,0,0,0,26,0,    
			0,0,0,0,0,0,0,0,0,    
			23,21,19,17,16,18,20,22,24);
	
	
	private static final String riverString = "    ==============================\n";
	private static final String coordinateXString = "y\\x   0  1  2  3  4  5  6  7  8    x/y\n";
	public static PieceMap<Integer, Piece> initPieceList = new PieceMap<Integer, Piece>(PieceFactory.getPiece(0, 10, 10));
	public static boolean PRINT_NUM = false;
	
	PieceMap<Integer, Piece> pieceList;
	private int value;
	
	
	public static void initializePieceStateList(){
		Iterator<Integer> iterator = initIntList.iterator();
		for (int y = 0; y <= 9; y++){			
			for (int x = 0; x <= 8; x++){
				if(iterator.hasNext()){
					int i = iterator.next();
					Piece piece = PieceFactory.getPiece(i,x,y);
					if (i != 0) initPieceList.put(piece.getK(), piece);
				}
			}
		}
	}
	
	public State() {
		initState();
	}
	
	private void initState(){
		if (initPieceList.size() == 0) State.initializePieceStateList();
		this.pieceList = initPieceList;
	}
	
	public PieceMap<Integer, Piece> getPieceList(){
		return this.pieceList;
	}
	
	public void evaluateValue(){
		this.value = Evaluate.evaluateState(this);
	}
	
	public int getValue(){
		return this.value;
	}

	public void setValue(int value){
		this.value = value;
	}
	
	public String toStringExtended(){
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(coordinateXString);
		buffer.append(riverString);
		
		for (int y = 3; y <= 12; y++){			
			buffer.append(String.valueOf(y-3) + " ||\t");
			
			for (int x = 3; x <= 11; x++){
				int k = x + (y << 4) ;
				Piece piece = pieceList.get(k);
				String pieceString;
				if (State.PRINT_NUM) pieceString = String.valueOf(piece.getNumber());
				else pieceString = piece.toString();
				buffer.append(pieceString);
				buffer.append("\t");
			}
			buffer.append((y == 7) ? ("\n" + riverString) : "\n");
		}
		return (buffer.toString());
	}
		
	private void setPieceList(PieceMap<Integer, Piece> pieceList){
		this.pieceList = pieceList;
	}
	
	public String toString(){
		return toString(this.pieceList);
	}
	
	public String toString(PieceMap<Integer, Piece> pieceList){
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(coordinateXString);
		buffer.append(riverString);
		
		for (int y = 0; y <= 9; y++){			
			buffer.append(String.valueOf(y) + " ||");
			for (int x = 0; x <= 8; x++){
				buffer.append("  ");
				int k = Utility.getOneDimention(x, y);
				Piece piece = pieceList.get(k);
				String pieceString;
				if (State.PRINT_NUM) pieceString = String.valueOf(piece.getNumber());
				else pieceString = piece.toString();
				buffer.append(pieceString);
			}
			buffer.append("   || "+ String.valueOf(y));
			buffer.append((y == 4) ? ("\n" + riverString) : "\n");
		}
		buffer.append(riverString);
		buffer.append(coordinateXString);
		return(buffer.toString());
	}
	
	private PieceMap<Integer, Piece> clonePieceList(){
		PieceMap<Integer, Piece> list = new PieceMap<Integer, Piece>(PieceFactory.getPiece(0, 10, 10));
		Collection<Piece> pieces = pieceList.values();
		for(Piece piece : pieces){
			list.put(piece.getK(), (Piece) piece.clone());
		}
		return list;	
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		State returnState =  (State) super.clone();
		returnState.setPieceList(this.clonePieceList());
		return returnState;
	}
	
	public List<Move> generateAllMoves(int side){
		List<Move> childMoves = new ArrayList<Move>();
		Collection<Piece> pieces = pieceList.values();
		Iterator<Piece> it = pieces.iterator();
		
	    while (it.hasNext()) {
	        Piece piece = (Piece) it.next();
	        if (piece.getSide() == side){
	        	List<Move> newStates = piece.generateAllMove(this, piece.getX(), piece.getY()); 
	        	
	        	childMoves.addAll(newStates);
	        }
	    }
		return childMoves;	
	}
	
	public int getWinner(){
		Iterator<Piece> it = pieceList.values().iterator();
		boolean user = false;
		boolean computer = false;
	    while (it.hasNext()) {
	        Piece piece = (Piece) it.next();
	        if (piece.getClass().equals(KingPiece.class)){
	        	if (piece.getSide() == Game.COMP_TURN){
		        	computer = true;
		        }
		        else user = true;	
	        }
	    }
		if (user == false) return Game.COMP_TURN;
		else if (computer == false) return Game.USER_TURN;
		else return Game.EMPTY_SPACE;
	}

}
