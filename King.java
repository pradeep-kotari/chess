package com.mychessproject.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import static com.mychessproject.core.ChessConstants.indices;
import static com.mychessproject.core.ChessConstants.colors;
public class King {
	// non static, non final fields
	private SquareColor squareColor;
	public SquareEnum currentSquare;
	
	// static and final fields
	public static final int WEIGHTAGE = 41;
	public static final String LETTER = "K";
	public static final String PIECE_NAME = "King";
	
	static SortedMap<Integer,List<Integer>> kingIndices = new TreeMap<>();
	static SortedMap<SquareEnum,List<SquareEnum>> kingMoves = new TreeMap<>();
	
	public SquareColor getSquareColor(int index) {
		int leftIndex = index/10;
		int rightIndex = index%10;
		squareColor = getSquareColorFromIndex(leftIndex,rightIndex);
		return squareColor;
	}

	private SquareColor getSquareColorFromIndex(int leftIndex, int rightIndex) {
		if((leftIndex>=0&& leftIndex<=7)&&(rightIndex>=0&&rightIndex<=7)){
			int value = colors[leftIndex][rightIndex];
			if (value==0){
				return SquareColor.BLACK;
			}
			if (value==1){
				return SquareColor.WHITE;
			}
		}
		return null;
	}

	public static final List<Integer> canGoToIndices (int index){
		return kingIndices.get(index);
	}
	
	public static final SquareEnum[] canGoToSquares (SquareEnum currentSquare){
		SquareEnum[] squareArray = (SquareEnum[]) kingMoves.get(currentSquare).toArray();
		return squareArray;

	}
	
	public static final List<Integer> canGoToIndices (SquareEnum currentSquare){
		int index =ChessBoard.getIndexFromSquare(currentSquare);
		return kingIndices.get(index);
	}
	
	public static final SquareEnum[] canGoToSquares (int index){
		SquareEnum[] squareArray =ChessBoard.getSquaresFromIndices(kingIndices.get(index));
		return squareArray;
	}
	
	public static void main(String[] args) {
		
		// calling compute
		computeIndicesAndMoves();
		
		King bishop = new King();
		for(int[]indexOfIndices : indices){
			for (int index: indexOfIndices){
				SquareColor squareColor = bishop.getSquareColor(index);
				System.out.println(index+ " " + squareColor);
			}
		}
		
		for(Entry<Integer, List<Integer>> entry:kingIndices.entrySet()){
			System.out.println("A "+PIECE_NAME+" on square "+entry.getKey()+" can possibly goto "+entry.getValue());
		}
		for(Entry<SquareEnum, List<SquareEnum>> entry:kingMoves.entrySet()){
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
					addToIndices(leftIndex+1, rightIndex, indices);
					addToIndices(leftIndex-1, rightIndex, indices);
					addToIndices(leftIndex, rightIndex-1, indices);
					addToIndices(leftIndex, rightIndex+1, indices);
					addToIndices(leftIndex+1, rightIndex+1, indices);
					addToIndices(leftIndex-1, rightIndex-1, indices);
					addToIndices(leftIndex+1, rightIndex-1, indices);
					addToIndices(leftIndex-1, rightIndex+1, indices);
				Collections.sort(indices);
				kingIndices.put(index, indices);
				
				SquareEnum squareEnum = ChessBoard.getSquareFromIndex(index);
				SquareEnum[] squareEnums = ChessBoard.getSquaresFromIndices(indices);
				
				List<SquareEnum> squareEnumsList = Arrays.asList(squareEnums);
				Collections.sort(squareEnumsList);
				kingMoves.put(squareEnum, squareEnumsList);
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
