package com.linhaibin.chess;

public class PieceFactory {

	public PieceFactory() {
		
	}
	
	public static Piece getPiece(int number, int x, int y){
		if ((number & Game.USER_TURN) == Game.USER_TURN)
			switch(number){
				case 16:	return new KingPiece(number,x,y);
				case 17:
				case 18:	return new AdvisorPiece(number,x,y);
				case 19:	
				case 20:	return new BishopPiece(number,x,y);
				case 21:	
				case 22:	return new KnightPiece(number,x,y);
				case 23:	
				case 24:	return new RookPiece(number,x,y);
				case 25:	
				case 26:	return new CannonPiece(number,x,y);
				case 27:	
				case 28:
				case 29:
				case 30:
				case 31:	return new PondPiece(number,x,y);
				default: return new EmptyPiece(number,x,y);
			}
		else 
			switch(number - Game.USER_TURN){
			case 16:	return new KingPiece(number,x,y);
			case 17:
			case 18:	return new AdvisorPiece(number,x,y);
			case 19:	
			case 20:	return new BishopPiece(number,x,y);
			case 21:	
			case 22:	return new KnightPiece(number,x,y);
			case 23:	
			case 24:	return new RookPiece(number,x,y);
			case 25:	
			case 26:	return new CannonPiece(number,x,y);
			case 27:	
			case 28:
			case 29:
			case 30:
			case 31:	return new PondPiece(number,x,y);
			}
		return new EmptyPiece(number,x,y);
	}

}
