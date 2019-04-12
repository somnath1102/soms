package com.somnath.leetcode.array;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		// check all rows and columns
		for (int i = 0; i < 9; i++) {
			boolean[] rChk = new boolean[9];
			boolean[] cChk = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && rChk[board[i][j] - '1']) {
					// System.out.println("" + i + "," + j + "board[i][j]=" +
					// board[i][j]);
					return false;
				}
				if (board[j][i] != '.' && cChk[board[j][i] - '1']) {
					// System.out.println("" + i + "," + j + "board[j][i]=" +
					// board[j][i]);
					return false;
				}
				if (board[i][j] != '.')
					rChk[board[i][j] - '1'] = true;
				if (board[j][i] != '.')
					cChk[board[j][i] - '1'] = true;
			}
		}

		// check boxes
		boolean[] cChk = new boolean[9];

		int j = -3;
		while (j < 6) {
			j += 3;
			int i = -3;
			while (i < 6) {
				i += 3;
				int l = -1;
				cChk = new boolean[9];
				// System.out.println("new box------------");
				while (++l < 3) {
					int k = -1;
					while (++k < 3) {
						// System.out.println("board["+(i+l) + "," +(j+k) + "]="
						// + board[i + l][j + k]);
						if (board[i + l][j + k] != '.') {
							if (cChk[board[i + l][j + k] - '1'])
								return false;
							cChk[board[i + l][j + k] - '1'] = true;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] x = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(isValidSudoku(x));
	}

}
