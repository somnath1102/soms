package com.somnath.queens;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

	private static Set<Position> positions = new HashSet<>();
	private static Map<Position, Set<Position>> queenTargetsMap = new HashMap<>();
	private static Board board = new Board();

	static {
		for (Dimension rank : Dimension.values()) {
			for (Dimension file : Dimension.values()) {
				positions.add(new Position(rank, file));
			}
		}
	}

	private Board() {
		// TODO Auto-generated constructor stub
	}

	public static Board getInstance() {
		return board;
	}

	public Position getPosition(Dimension rank, Dimension file) {
		for (Position position : positions) {
			if (position.equals(new Position(rank, file)))
				return position;
		}
		return null;
	}

	public Set<Position> getQueenTargets(Position currPosition) {
		Set<Position> rankTargets = getRankTargets(currPosition);
		Set<Position> fileTargets = getFileTargets(currPosition);
		Set<Position> diagonalTargets = getDiagonalTargets(currPosition);
		fileTargets.addAll(diagonalTargets);
		rankTargets.addAll(fileTargets);
		rankTargets.remove(null);// if any
		return rankTargets;
	}

	private Set<Position> getDiagonalTargets(Position currPosition) {
		Set<Position> result = new HashSet<>();
		// forward diagonal
		for (Dimension rank : Dimension.values()) {
			int fileValue = -1;
			fileValue = currPosition.getFile().getValue() - (currPosition.getRank().getValue() - rank.getValue());
			result.add(board.getPosition(rank, rank.findByValue(fileValue)));
		}

		// backward diagonal
		for (Dimension rank : Dimension.values()) {
			int fileValue = -1;
			fileValue = currPosition.getFile().getValue() + (currPosition.getRank().getValue() - rank.getValue());
			result.add(board.getPosition(rank, rank.findByValue(fileValue)));
		}
		return result;
	}

	private Set<Position> getFileTargets(Position currPosition) {
		Set<Position> result = new HashSet<>();
		for (Dimension file : Dimension.values()) {
			result.add(board.getPosition(currPosition.getRank(), file));
		}
		return result;
	}

	private Set<Position> getRankTargets(Position currPosition) {
		Set<Position> result = new HashSet<>();
		for (Dimension rank : Dimension.values()) {
			result.add(board.getPosition(rank, currPosition.getFile()));
		}
		return result;
	}

	public boolean placeNextQueen(Dimension rank) {
		if (rank == null)
			return true;
		for (Dimension file : Dimension.values()) {
			Position consideredQPos = new Position(rank, file);
			if (!getAllQueenTargets().contains(consideredQPos)) {
				Set<Position> consideredQueenTargets = board.getQueenTargets(consideredQPos);
				queenTargetsMap.put(consideredQPos, consideredQueenTargets);
				drawQueenTargets();
				if (placeNextQueen(rank.increment())) {
					return true;
				} else {
					// cleanup last entry and retry next file
					queenTargetsMap.remove(consideredQPos);
					System.out.println("\nabandoned position " + consideredQPos.toString());
				}
			}
		}
		return false;
	}

	private Set<Position> getAllQueenTargets() {
		Set<Position> allQueenTargets = new HashSet<>();
		for (Set<Position> targetsOfaQueen : queenTargetsMap.values()) {
			allQueenTargets.addAll(targetsOfaQueen);
		}
		return allQueenTargets;
	}
	
	public void draw() {
		char boardToDraw[][] = new char[8][8];
		for (int i = 0; i < boardToDraw.length; i++) {
			for (int j = 0; j < boardToDraw[0].length; j++) {
				boardToDraw[i][j] = '#';
			}
		}
		for (Position qPos : queenTargetsMap.keySet()) {
			boardToDraw[qPos.getRank().getValue() - 1][qPos.getFile().getValue() - 1] = 'Q';
		}
		for (int i = boardToDraw.length - 1; i >= 0; i--) {
			System.out.println();
			for (int j = 0; j < boardToDraw[0].length; j++) {
				System.out.print(boardToDraw[i][j] + " ");
			}
		}
	}

	public void drawQueenTargets(Position currQPos) {
		char boardToDraw[][] = new char[8][8];
		for (int i = 0; i < boardToDraw.length; i++) {
			for (int j = 0; j < boardToDraw[0].length; j++) {
				boardToDraw[i][j] = '#';
			}
		}
		for (Position target : board.getQueenTargets(currQPos)) {
			boardToDraw[target.getRank().getValue() - 1][target.getFile().getValue() - 1] = 'T';
		}
		boardToDraw[currQPos.getRank().getValue() - 1][currQPos.getFile().getValue() - 1] = 'Q';

		for (int i = boardToDraw.length - 1; i >= 0; i--) {
			System.out.println();
			for (int j = 0; j < boardToDraw[0].length; j++) {
				System.out.print(boardToDraw[i][j] + " ");
			}
		}
	}

	public void drawQueenTargets() {
		System.out.println();
		char boardToDraw[][] = new char[8][8];
		for (int i = 0; i < boardToDraw.length; i++) {
			for (int j = 0; j < boardToDraw[0].length; j++) {
				boardToDraw[i][j] = '#';
			}
		}
		for (Position target : getAllQueenTargets()) {
			boardToDraw[target.getRank().getValue() - 1][target.getFile().getValue() - 1] = 'T';
		}

		for (Position qPos : queenTargetsMap.keySet()) {
			boardToDraw[qPos.getRank().getValue() - 1][qPos.getFile().getValue() - 1] = 'Q';
		}

		for (int i = boardToDraw.length - 1; i >= 0; i--) {
			System.out.println();
			for (int j = 0; j < boardToDraw[0].length; j++) {
				System.out.print(boardToDraw[i][j] + " ");
			}
		}
	}

}
