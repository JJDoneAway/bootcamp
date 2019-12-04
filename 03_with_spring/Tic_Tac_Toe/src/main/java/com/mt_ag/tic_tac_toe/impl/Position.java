package com.mt_ag.tic_tac_toe.impl;

import com.mt_ag.tic_tac_toe.IPosition;

public class Position implements IPosition {


	private Integer row;
	private Integer column;

	public Position(ROWS row, int column) {
		this(row.ordinal() + 1, column);
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public Integer getRow() {
		return row;
	}

	@Override
	public Integer getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return String.format("(%s,%d)", ROWS.values()[row - 1], column);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
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
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		return true;
	}

}
