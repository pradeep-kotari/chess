package com.mychessproject.core;

import java.util.List;

public class ChessBoard {
	
	public static SquareEnum[] getSquaresFromIndices(List<Integer> indices){
		 SquareEnum[] squareArray = new SquareEnum[indices.size()];
		 for(int i=0;i<indices.size();i++){
			 int index=indices.get(i);
			 squareArray[i] = getSquareFromIndex(index);
		 }
		 return squareArray;
	}

	public static SquareEnum getSquareFromIndex(int index) {
		int leftIndex = index/10;
		int rightIndex = index%10;
		
		String leftSquare = null;
		String rightSquare = String.valueOf(8-leftIndex);
		switch(rightIndex){
			case 0:leftSquare="a";break;
			case 1:leftSquare="b";break;
			case 2:leftSquare="c";break;
			case 3:leftSquare="d";break;
			case 4:leftSquare="e";break;
			case 5:leftSquare="f";break;
			case 6:leftSquare="g";break;
			case 7:leftSquare="h";break;
		}
		return SquareEnum.valueOf(leftSquare.concat(rightSquare));
	}
	
	public static int getIndexFromSquare (SquareEnum square){
		int rightIndex = 0;
		char leftChar=square.toString().charAt(0);
		switch (leftChar) {
			case 'a': rightIndex=0;break;
			case 'b': rightIndex=0;break;
			case 'c': rightIndex=0;break;
			case 'd': rightIndex=0;break;
			case 'e': rightIndex=0;break;
			case 'f': rightIndex=0;break;
			case 'g': rightIndex=0;break;
			case 'h': rightIndex=0;break;
		}
		
		String rightChar=square.toString().substring(1);
		int leftIndex = Integer.valueOf(rightChar);
		return (8-leftIndex)*10+rightIndex;
	}
	
	

}
 