package com.linhaibin.chess;

import java.util.Arrays;
import java.util.List;

public class Evaluate {

	public Evaluate() {
	}

	public static final List<Integer> redKingPositionValue = Arrays.asList(
			0,0,0,0,0,0,0,0,0,   
			0,0,0,0,0,0,0,0,0,     
			0,0,0,0,0,0,0,0,0,   
			0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,     
			
			0,0,0,0,0,0,0,0,0,     
			0,0,0,0,0,0,0,0,0,
			0,0,0,1,1,1,0,0,0,    
			0,0,0,10,10,10,0,0,0,    
			0,0,0,15,20,15,0,0,0);
	
	public static final List<Integer> blackKingPositionValue = Arrays.asList(
			0,0,0,15,20,15,0,0,0,   
			0,0,0,10,10,10,0,0,0,  
			0,0,0,1,1,1,0,0,0,
			0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,     
			
			0,0,0,0,0,0,0,0,0,     
			0,0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,       
			0,0,0,0,0,0,0,0,0,       
			0,0,0,0,0,0,0,0,0);
	
	public static final List<Integer> redRookPositionValue = Arrays.asList(

			160,170,160,150,150,150,160,170,160,   
			170,180,170,190,250,190,170,180,170,     
			170,190,200,220,240,220,200,190,170,   
			180,220,210,240,250,240,210,220,180,
			180,220,210,240,250,240,210,220,180,     
			
			180,220,210,240,250,240,210,220,180,
			170,190,200,220,240,220,200,190,170,
			170,180,170,170,160,170,170,180,170,
			160,170,160,160,150,160,160,170,160,    
			150,160,150,160,150,160,150,160,150);
	
	public static final List<Integer> blackRookPositionValue = Arrays.asList(
			150,160,150,160,150,160,150,160,150,
			160,170,160,160,150,160,160,170,160,    
			170,180,170,170,160,170,170,180,170,
			170,190,200,220,240,220,200,190,170,
			180,220,210,240,250,240,210,220,180,
			
			180,220,210,240,250,240,210,220,180,
			180,220,210,240,250,240,210,220,180,
			170,190,200,220,240,220,200,190,170,
			170,180,170,190,250,190,170,180,170,   
			160,170,160,150,150,150,160,170,160);
	
	public static final List<Integer> redAdvisorPositionValue = Arrays.asList(null);
	public static final List<Integer> blackAdvisorPositionValue = Arrays.asList(null);
	public static final List<Integer> redBishopPositionValue = Arrays.asList(null);
	public static final List<Integer> blackBishopPositionValue = Arrays.asList(null);
	public static final List<Integer> redKnightPositionValue = Arrays.asList(null);
	public static final List<Integer> blackKnightPositionValue = Arrays.asList(null);
	public static final List<Integer> redPondPositionValue = Arrays.asList(null);
	public static final List<Integer> blackPondPositionValue = Arrays.asList(null);
	public static final List<Integer> redCannonPositionValue = Arrays.asList(null);
	public static final List<Integer> blackCannonPositionValue = Arrays.asList(null);
	
	
	public static int evaluateState(State state){
		int value = 0;
		value += evaluateStatic(state);
		value += evaluateMobility(state);
		return value;
	}
	
	private static int evaluateStatic(State state){
		int staticValue = 0;
		List<Piece> stateList = state.getStateList();
		
		for (int y = 0; y <= 9; y++){			
			for (int x = 0; x <= 8; x++){
				int k = y * 9 + x;
				Piece piece = stateList.get(k);
				staticValue += piece.evaluateStatic(k);
			}
		}
		return staticValue;
	}
	
	private static int evaluateMobility(State state){
		return 0;
	}
	
}
