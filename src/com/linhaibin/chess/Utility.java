package com.linhaibin.chess;

public class Utility {

	public Utility() {
		// TODO Auto-generated constructor stub
	}
	public static void debug(Object message){
		System.out.println(message);
	}
	
	//Convert x, y to position in one-dimentional array
	public static int getOneDimention(int x, int y){
		return x + y * 9;
	}
	
	public static boolean isOnBoard(int x, int y){
		return (x <= 8 && x >= 0 && y <= 9 && y >= 0);
	}
	
	public static int distanceSquare(int x1, int y1, int x2, int y2){
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	}
	
	public static boolean standStill(int x1, int y1, int x2, int y2){
		if (x1== x2 && y1 == y2) return true;
		else return false;
	}
}
