package com.linhaibin.chess;

public class Utility {

	public Utility() {
		// TODO Auto-generated constructor stub
	}
	public static void debug(Object message){
		System.out.print("Debug: ");
		System.out.println(message);
	}
	
	//Convert x, y to position in one-dimentional array
	public static int getOneDimention(int x, int y){
		return x + y * 9;
	}
	
}
