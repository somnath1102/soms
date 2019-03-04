package com.somnath.queens;

public final class Position implements Comparable<Position>{
	private final Dimension rank;
	private final Dimension file;
	
	// dont initialise outside package
	Position(Dimension rank, Dimension file) {
		this.rank = rank;
		this.file = file;
	}
	
	public Dimension getRank() {
		return rank;
	}

	public Dimension getFile() {
		return file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (file != other.file)
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "{" + rank.getValue() + "," + file.getValue() + "}";
	}

	@Override
	public int compareTo(Position opponent) {
		if (this.equals(opponent))
			return 0;
		if(this.rank.getValue() > opponent.getRank().getValue())
			return 1;
		else if(this.rank.getValue() == opponent.getRank().getValue()) {
			if(this.file.getValue() > opponent.file.getValue())
				return 1;
		}
		return -1;
	}
}
