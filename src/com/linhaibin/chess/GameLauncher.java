package com.linhaibin.chess;

public class GameLauncher {

	public GameLauncher() {
		
	}

	
	public static void main(String args[]){
		Game game = new Game();
		
		game.printWelcome();
		
		
		State initState = new State();
		game.printState(initState);
		
		game.printAsk();
		
		
		
		
		
		
	}
	
	
}
