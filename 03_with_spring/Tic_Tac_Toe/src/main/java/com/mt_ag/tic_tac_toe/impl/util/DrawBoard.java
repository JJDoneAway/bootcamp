package com.mt_ag.tic_tac_toe.impl.util;

import com.mt_ag.tic_tac_toe.IBoard;
import com.mt_ag.tic_tac_toe.IPlayer;
import com.mt_ag.tic_tac_toe.IPosition.ROWS;
import com.mt_ag.tic_tac_toe.impl.Position;

/**
 * Ein kleiner interner Helper, um das Tic Tac Toe Board als SysOut zu zeichnen
 * 
 * <code>
--------------------------------
Current move: 5
Johannes plays x
Annabell plays o

    | 1 | 2 | 3 |
-----------------
 A  | x |   | o |
-----------------
 B  |   | x | o |
-----------------
 C  |   |   | x |
-----------------
--------------------------------
 * </code>
 * 
 * @author jhoehne
 *
 */

public final class DrawBoard {

	/**
	 * Util classes are static
	 */
	private DrawBoard() {
	}

	private static IBoard b;
	private static IPlayer player_a, player_b;

	// Helper to draw the board
	public static String draw(IBoard board) {
		b = board;
		player_a = b.getPlayer_a();
		player_b = b.getPlayer_b();

		StringBuilder ret = new StringBuilder();

		getHeader(ret);

		getColumnNameLine(ret);

		for (int r = 1; r <= b.getRows(); r++) {
			getSeparatorLine(ret);
			getBoxLine(ret, r);
		}

		getSeparatorLine(ret);
		return ret.toString();
	}

	private static void getHeader(StringBuilder ret) {
		ret.append(String.format("Current move: %d\n", b.getCurrentMove()));
		ret.append(String.format("%s plays %s\n", player_a.getName(), player_a.getSign()));
		ret.append(String.format("%s plays %s\n\n", player_b.getName(), player_b.getSign()));
	}

	private static void getColumnNameLine(StringBuilder ret) {
		for (int c = 0; c <= b.getColumns(); c++) {
			if (c == 0) {
				ret.append("    ");
			} else {
				ret.append(String.format("| %d ", c));
			}
		}
		ret.append("|\n");
	}

	private static void getBoxLine(StringBuilder ret, int r) {
		for (int c = 1; c <= b.getColumns(); c++) {
			if (c == 1) {
				ret.append(String.format(" %S  ", ROWS.values()[r - 1]));
			}

			ret.append("| ");

			if (player_a.positionBlocked(new Position(r, c))) {
				ret.append(player_a.getSign());
			} else if (player_b.positionBlocked(new Position(r, c))) {
				ret.append(player_b.getSign());
			} else {
				ret.append(" ");
			}
			ret.append(" ");
		}
		ret.append("|\n");
	}

	private static void getSeparatorLine(StringBuilder ret) {
		for (int c = 0; c <= b.getColumns(); c++) {
			ret.append("----");
		}
		ret.append("-\n");
	}

}
