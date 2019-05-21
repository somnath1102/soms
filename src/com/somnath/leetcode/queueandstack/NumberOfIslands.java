package com.somnath.leetcode.queueandstack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		// convert to Unit so we can capture visited info
		Unit[][] uGrid = convert(grid);

		// for each unit in uGrid do bfs and mark as visited - once done
		// increase
		// island count
		int islandCount = 0;
		for (int i = 0; i < uGrid.length; i++) {
			for (int j = 0; j < uGrid[i].length; j++) {
				if (uGrid[i][j].value == '1' && !uGrid[i][j].visited) {
					++islandCount;
					Queue<Unit> q = new LinkedList<>();
					q.add(uGrid[i][j]);
					while (!q.isEmpty()) {
						//print(uGrid);
						int currQSize = q.size();
						for (int k = 0; k < currQSize; k++) {
							Unit first = q.poll();
							for (Unit neighbour : first.getNeighbors(uGrid, uGrid.length, uGrid[0].length)) {
								if (neighbour.value == '1' && !neighbour.visited) {
									neighbour.visited = true;
									q.offer(neighbour);
								}
							}
						}
					}
				}
			}
		}
		 print(uGrid);
		System.out.println(islandCount);
		return islandCount;
	}

	public static void main(String[] args) {
		NumberOfIslands s = new NumberOfIslands();
		char[][] cs = { { '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1' },
				{ '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0' },
				{ '1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1' },
				{ '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' } };
		// { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1',
		// '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		s.numIslands(cs);
	}

	private void print(Unit[][] uGrid) {
		for (int i = 0; i < uGrid.length; i++) {
			for (int j = 0; j < uGrid[0].length; j++) {
				System.out.print(uGrid[i][j].value + "-" + (uGrid[i][j].visited ? "V" : "N") + " ");
			}
			System.out.println();
		}
	}

	private Unit[][] convert(char[][] grid) {
		Unit[][] uGrid = new Unit[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				uGrid[i][j] = new Unit(grid[i][j], i, j);
			}
		}
		return uGrid;
	}

}

class Unit {
	final char value;
	final int row;
	final int col;
	boolean visited;

	Unit(char value, int row, int col) {
		this.value = value;
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Unit [value=" + value + ", row=" + row + ", col=" + col + ", visited=" + visited + "]";
	}

	List<Unit> getNeighbors(Unit[][] uGrid, int rows, int cols) {
		List<Unit> n = new ArrayList<Unit>();
		if (row > 0)
			n.add(uGrid[row - 1][col]);
		if (row < rows - 1)
			n.add(uGrid[row + 1][col]);
		if (col < cols - 1)
			n.add(uGrid[row][col + 1]);
		if (col > 0)
			n.add(uGrid[row][col - 1]);
		// n.removeIf(x -> x.visited || x.value != '1');
		return n;
	}
}
