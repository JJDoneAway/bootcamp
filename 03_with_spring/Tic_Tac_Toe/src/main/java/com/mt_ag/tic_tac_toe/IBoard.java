package com.mt_ag.tic_tac_toe;

public interface IBoard {

	public static enum VALIDATION {
		BLOCKED, OUT_OF_BOARD, OK
	}

	public static enum GAME_STATUS {
		RUNNING, A_WINNS, B_WINNS
	}

	
	GAME_STATUS checkStatus();

	VALIDATION move(IPosition position);

	IPlayer getWinner();

	VALIDATION validateMove(IPosition position);

	int getCurrentMove();

	IPlayer getPlayer_a();

	IPlayer getPlayer_b();

	IPlayer getNextMover();

	int getColumns();

	int getRows();

}