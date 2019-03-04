package com.somnath.queens;

/**
 * 
|
|
|
|
|
|
| | Z| | Y| | | | |
| | X| | W| | | | |
X is rank 1, File 2
Y is Rank 2, File 4

pending - 
1> code placing queens - place 1 on file 1, then 2nd on non-target file 2 and so on. Any queen gets stuck go back to last file queen and retry
***2> Draw the queen positions using a drawing api
**/
public class _8queens {
	public static void main(String[] args) {
		Board board = Board.getInstance();
		System.out.println("\n" + board.placeNextQueen(Dimension.One));
		board.draw();
	}
}
