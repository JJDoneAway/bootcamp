package com.mt_ag.tic_tac_toe;

public interface IPosition {

	public static enum ROWS {
		A, B, C, D, E, F
	}

	
	Integer getRow();

	Integer getColumn();

}