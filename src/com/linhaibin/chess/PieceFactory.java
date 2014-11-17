package com.linhaibin.chess;

public class PieceFactory {

	public PieceFactory() {
		
	}
	
	public static Piece getPiece(int number){
		if ((number & Game.USER_TURN) == Game.USER_TURN)
			switch(number){
				case 16:	return new KingPiece(number);
				case 17:
				case 18:	return new AdvisorPiece(number);
				case 19:	
				case 20:	return new BishopPiece(number);
				case 21:	
				case 22:	return new KnightPiece(number);
				case 23:	
				case 24:	return new RookPiece(number);
				case 25:	
				case 26:	return new CannonPiece(number);
				case 27:	
				case 28:
				case 29:
				case 30:
				case 31:	return new PondPiece(number);
				default: return new EmptyPiece(number);
			}
		else 
			switch(number - Game.USER_TURN){
			case 16:	return new KingPiece(number);
			case 17:
			case 18:	return new AdvisorPiece(number);
			case 19:	
			case 20:	return new BishopPiece(number);
			case 21:	
			case 22:	return new KnightPiece(number);
			case 23:	
			case 24:	return new RookPiece(number);
			case 25:	
			case 26:	return new CannonPiece(number);
			case 27:	
			case 28:
			case 29:
			case 30:
			case 31:	return new PondPiece(number);
			}
		return new EmptyPiece(number);
	}
}
