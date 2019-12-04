package com.mt_ag.tic_tac_toe.impl;

import com.mt_ag.tic_tac_toe.IBoard;
import com.mt_ag.tic_tac_toe.IPlayer;
import com.mt_ag.tic_tac_toe.IPosition;
import com.mt_ag.tic_tac_toe.impl.util.DrawBoard;
import com.mt_ag.tic_tac_toe.impl.util.GameStatus;


public class Board implements IBoard {


	private int rows = 3, columns = 3;

	private int currentMove = 0;
	private Player nextMover;

	private Player player_a, player_b;

	public Board(Player first, Player second) {
		if (first == null || second == null) {
			throw new IllegalArgumentException("Players must not be null");
		}
		if (first.equals(second)) {
			throw new IllegalArgumentException("Players must not be the same");
		}
		if (first.getSign() == second.getSign()) {
			throw new IllegalArgumentException("Players must not have same sign");
		}
		if (!first.getMoves().isEmpty() || !second.getMoves().isEmpty()) {
			throw new IllegalArgumentException("Players must not have any already done moves");
		}

		this.player_a = first;
		this.player_b = second;
		this.nextMover = first;
	}

	@Override
	public GAME_STATUS checkStatus() {
		return GameStatus.checkStatus(this);
	}

	@Override
	public VALIDATION move(IPosition position) {
		IPlayer winner = getWinner();
		if (winner != null) {
			throw new IllegalArgumentException(
					String.format("Game over. %s with %s won it.", winner.getName(), winner.getSign()));
		}

		VALIDATION validation = validateMove(position);
		if (!validation.equals(VALIDATION.OK)) {
			return validation;
		}

		this.nextMover.addMove(position);
		// könnte man auch ganz hübsch mit modulo machen
		if (player_a.equals(nextMover)) {
			nextMover = player_b;
		} else {
			nextMover = player_a;
		}
		currentMove++;
		return validation;
	}

	@Override
	public IPlayer getWinner() {
		// check if game is already over
		IPlayer ret = null;
		GAME_STATUS status = checkStatus();
		if (!status.equals(GAME_STATUS.RUNNING)) {
			ret = player_a;
			if (status.equals(GAME_STATUS.B_WINNS)) {
				ret = player_b;
			}

		}

		return ret;
	}

	@Override
	public VALIDATION validateMove(IPosition position) {
		if (position.getColumn() <= 0 || position.getRow() <= 0) {
			return VALIDATION.OUT_OF_BOARD;
		}

		if (position.getColumn() > getColumns() || position.getRow() > getRows()) {
			return VALIDATION.OUT_OF_BOARD;
		}

		if (this.player_a.positionBlocked(position) || this.player_b.positionBlocked(position)) {
			return VALIDATION.BLOCKED;
		}

		return VALIDATION.OK;
	}

	@Override
	public int getCurrentMove() {
		return currentMove;
	}

	@Override
	public IPlayer getPlayer_a() {
		return player_a;
	}

	@Override
	public IPlayer getPlayer_b() {
		return player_b;
	}

	@Override
	public IPlayer getNextMover() {
		return nextMover;
	}

	@Override
	public int getColumns() {
		return columns;
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public String toString() {
		return DrawBoard.draw(this);
	}

}
