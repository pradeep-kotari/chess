package com.mychessproject.core;
import static com.mychessproject.core.SquareEnum.*;
public class ChessConstants {
	
	public static final int [][] colors = new int [][]{
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1},
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1},
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1},
		{1,0,1,0,1,0,1,0},
		{0,1,0,1,0,1,0,1}
	};
	
	public static final int [][] indices = new int [][]{
		{00,01,02,03,04,05,06,07},
		{10,11,12,13,14,15,16,17},
		{20,21,22,23,24,25,26,27},
		{30,31,32,33,34,35,36,37},
		{40,41,42,43,44,45,46,47},
		{50,51,52,53,54,55,56,57},
		{60,61,62,63,64,65,66,67},
		{70,71,72,73,74,75,76,77}
	};
	
	public static final SquareEnum[][] squares = new SquareEnum [][]{
		{a8,b8,c8,d8,e8,f8,g8,h8},
		{a7,b7,c7,d7,e7,f7,g7,h7},
		{a6,b6,c6,d6,e6,f6,g6,h6},
		{a5,b5,c5,d5,e5,f5,g5,h5},
		{a4,b4,c4,d4,e4,f4,g4,h4},
		{a3,b3,c3,d3,e3,f3,g3,h3},
		{a2,b2,c2,d2,e2,f2,g2,h2},
		{a1,b1,c1,d1,e1,f1,g1,h1}
	};

}
