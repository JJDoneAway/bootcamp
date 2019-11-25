package com.mt_ag.tic_tac_toe.util;

import static com.mt_ag.tic_tac_toe.Board.GAME_STATUS.A_WINNS;
import static com.mt_ag.tic_tac_toe.Board.GAME_STATUS.B_WINNS;
import static com.mt_ag.tic_tac_toe.Board.GAME_STATUS.RUNNING;
/**
 * Util class to check the status of the game
 * 
 */
import static com.mt_ag.tic_tac_toe.Position.ROWS.A;
import static com.mt_ag.tic_tac_toe.Position.ROWS.B;
import static com.mt_ag.tic_tac_toe.Position.ROWS.C;

import java.util.List;

import com.mt_ag.tic_tac_toe.Board;
import com.mt_ag.tic_tac_toe.Board.GAME_STATUS;
import com.mt_ag.tic_tac_toe.Player;
import com.mt_ag.tic_tac_toe.Position;

public final class GameStatus {

	/**
	 * Util classes are static
	 */
	private GameStatus() {
	}

	public static GAME_STATUS checkStatus(Board board) {
		Player a = board.getPlayer_a();
		Player b = board.getPlayer_b();
		List<Position> p_a = a.getMoves();
		List<Position> p_b = b.getMoves();

		if (p_a.size() < 3 && p_b.size() < 3) {
			return RUNNING;
		}

		if(checkWinning(p_a)) {
			return A_WINNS;
		}

		if(checkWinning(p_b)) {
			return B_WINNS;
		}

		return RUNNING;
	}

	private static boolean checkWinning(List<Position> m) {
		// diagonal \
		if (m.contains(new Position(A, 1)) //
				&& m.contains(new Position(B, 2)) //
				&& m.contains(new Position(C, 3))) {
			return true;
		}

		// diagonal /
		if (m.contains(new Position(A, 3)) //
				&& m.contains(new Position(B, 2)) //
				&& m.contains(new Position(C, 1))) {
			return true;
		}

		// row
		for (int r = 1; r <= 3; r++) {
			boolean found = true;

			for (int c = 1; c <= 3; c++) {
				if (!m.contains(new Position(r, c))) {
					found = false;
					break;
				}
			}

			if (found) {
				return true;
			}
		}

		// column
		for (int c = 1; c <= 3; c++) {
			boolean found = true;

			for (int r = 1; r <= 3; r++) {
				if (!m.contains(new Position(r, c))) {
					found = false;
					break;
				}
			}

			if (found) {
				return true;
			}
		}

		return false;

	}
}
