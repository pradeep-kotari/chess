package com.mychessproject.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import static com.mychessproject.core.ChessConstants.indices;

public class Knight {
	
	public static final int WEIGHTAGE = 3;
	public static final String LETTER = "N";
	public static final String PIECE_NAME = "Knight";
	
	static SortedMap<Integer,List<Integer>> knightIndices = new TreeMap<>();
	static SortedMap<SquareEnum,List<SquareEnum>> knightMoves = new TreeMap<>();
	
	public static final List<Integer> canGoToIndices (int index){
		return knightIndices.get(index);
	}
	
	public static final SquareEnum[] canGoToSquares (SquareEnum currentSquare){
		SquareEnum[] squareArray = (SquareEnum[]) knightMoves.get(currentSquare).toArray();
		return squareArray;

	}
	
	public static final List<Integer> canGoToIndices (SquareEnum currentSquare){
		int index =ChessBoard.getIndexFromSquare(currentSquare);
		return knightIndices.get(index);
	}
	
	public static final SquareEnum[] canGoToSquares (int index){
		SquareEnum[] squareArray =ChessBoard.getSquaresFromIndices(knightIndices.get(index));
		return squareArray;
	}
	
	public static void main(String[] args) {
		// calling compute
		
		computeIndicesAndMoves();
		
		for(Entry<Integer, List<Integer>> entry:knightIndices.entrySet()){
			System.out.println("A "+PIECE_NAME+" on square "+entry.getKey()+" can possibly goto "+entry.getValue());
		}
		for(Entry<SquareEnum, List<SquareEnum>> entry:knightMoves.entrySet()){
			System.out.println("A "+PIECE_NAME+" on square "+entry.getKey()+" can possibly goto "+entry.getValue());
		}
		
		
	}
	
	public static void computeIndicesAndMoves(){
		int length = indices.length;
		for(int i=0;i<length;i++){
			for (int j = 0; j < indices.length; j++) {
				int index = indices[i][j];
				int leftIndex = index/10;
				int rightIndex = index%10;
				List<Integer> indices = new ArrayList<>();
				addToIndices(leftIndex+1, rightIndex+2, indices);
				addToIndices(leftIndex+2, rightIndex+1, indices);
				addToIndices(leftIndex-1, rightIndex-2, indices);
				addToIndices(leftIndex-2, rightIndex-1, indices);
				addToIndices(leftIndex+1, rightIndex-2, indices);
				addToIndices(leftIndex+2, rightIndex-1, indices);
				addToIndices(leftIndex-1, rightIndex+2, indices);
				addToIndices(leftIndex-2, rightIndex+1, indices);
				knightIndices.put(index, indices);
				
				SquareEnum squareEnum = ChessBoard.getSquareFromIndex(index);
				SquareEnum[] squareEnums = ChessBoard.getSquaresFromIndices(indices);
				
				knightMoves.put(squareEnum, Arrays.asList(squareEnums));
				
			}
		}
	}
	
	private static final List<Integer> addToIndices(int leftIndex, int rightIndex, List<Integer> indices){
		if((leftIndex>=0&& leftIndex<=7)&&(rightIndex>=0&&rightIndex<=7)){
			indices.add(leftIndex*10+rightIndex);
		}
		return indices;
	}
	

}
