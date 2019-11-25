package com.mt_ag.tic_tac_toe;

import com.mt_ag.tic_tac_toe.util.DrawBoard;
import com.mt_ag.tic_tac_toe.util.GameStatus;

public class Board {

	public static enum VALIDATION {
		BLOCKED, OUT_OF_BOARD, OK
	}

	public static enum GAME_STATUS {
		RUNNING, A_WINNS, B_WINNS
	}

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

	public GAME_STATUS checkStatus() {
		return GameStatus.checkStatus(this);
	}

	public VALIDATION move(Position position) {
		Player winner = getWinner();
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

	public Player getWinner() {
		// check if game is already over
		Player ret = null;
		GAME_STATUS status = checkStatus();
		if (!status.equals(GAME_STATUS.RUNNING)) {
			ret = player_a;
			if (status.equals(GAME_STATUS.B_WINNS)) {
				ret = player_b;
			}

		}

		return ret;
	}

	public VALIDATION validateMove(Position position) {
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

	public int getCurrentMove() {
		return currentMove;
	}

	public Player getPlayer_a() {
		return player_a;
	}

	public Player getPlayer_b() {
		return player_b;
	}

	public Player getNextMover() {
		return nextMover;
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	@Override
	public String toString() {
		return DrawBoard.draw(this);
	}

}
