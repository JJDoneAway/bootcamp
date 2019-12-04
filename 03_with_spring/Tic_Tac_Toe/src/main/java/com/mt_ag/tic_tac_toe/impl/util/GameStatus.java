package com.mt_ag.tic_tac_toe.impl.util;

import static com.mt_ag.tic_tac_toe.IBoard.GAME_STATUS.A_WINNS;
import static com.mt_ag.tic_tac_toe.IBoard.GAME_STATUS.B_WINNS;
import static com.mt_ag.tic_tac_toe.IBoard.GAME_STATUS.RUNNING;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.A;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.B;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.C;

import java.util.List;

import com.mt_ag.tic_tac_toe.IBoard;
import com.mt_ag.tic_tac_toe.IBoard.GAME_STATUS;
import com.mt_ag.tic_tac_toe.IPlayer;
import com.mt_ag.tic_tac_toe.IPosition;
import com.mt_ag.tic_tac_toe.impl.Position;

public final class GameStatus {

	/**
	 * Util classes are static
	 */
	private GameStatus() {
	}

	public static GAME_STATUS checkStatus(IBoard board) {
		IPlayer a = board.getPlayer_a();
		IPlayer b = board.getPlayer_b();
		List<IPosition> p_a = a.getMoves();
		List<IPosition> p_b = b.getMoves();

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

	private static boolean checkWinning(List<IPosition> m) {
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
