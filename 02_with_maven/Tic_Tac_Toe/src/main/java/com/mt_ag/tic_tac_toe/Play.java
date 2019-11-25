package com.mt_ag.tic_tac_toe;

import java.util.Scanner;

import com.mt_ag.tic_tac_toe.Board.GAME_STATUS;
import com.mt_ag.tic_tac_toe.Board.VALIDATION;
import com.mt_ag.tic_tac_toe.Position.ROWS;

public class Play {

	public static void main(String[] args) {
		String a = "Johannes";
		String b = "Annabell";
		if (args.length == 2) {
			a = args[0];
			b = args[1];
		}

		Board board = new Board(new Player(a, 'X'), new Player(b, 'O'));

		Scanner scanner = new Scanner(System.in);

		while (board.checkStatus().equals(GAME_STATUS.RUNNING)) {
			System.out.println(board);

			System.out.printf(
					"\n%s it is your turn. Please enter your next move (e.g.: A,3) and press enter.\nnext move:",
					board.getNextMover().getName());
			String input = scanner.nextLine().trim();

			Position nextPos = validateInput(board, input);
			if (nextPos == null) {
				continue;
			}
			board.move(nextPos);
		}

		System.out.println("\n--------------------------------------------------\n");
		System.out.println(board);
		System.out.printf("\nGame over! %s you won it.\n", board.getWinner().getName());
		System.out.println("--------------------------------------------------\n");
		scanner.close();
	}

	private static Position validateInput(Board board, String input) {
		// valid length
		if (input.length() < 3) {
			System.err.printf(
					"\n\n%s please enter your next move in the right format. You did it like this '%s' but it must be like this 'A,3'\n\n",
					board.getNextMover().getName(), input);
			return null;
		}

		// valid seperator
		if (input.charAt(1) != ',') {
			System.err.printf(
					"\n\n%s please enter your next move in the right format. You did it like this '%s' but it must be like this 'A,3'\n\n",
					board.getNextMover().getName(), input);
			return null;
		}

		String[] split = input.trim().split(",");

		// valid row name
		ROWS row = null;
		try {
			row = ROWS.valueOf(split[0].toUpperCase());
		} catch (IllegalArgumentException e) {
			System.err.printf("\n\n%s The row you entered dosn't exist. You enterd this one: '%s'.\n\n",
					board.getNextMover().getName(), split[0].toUpperCase());
			return null;
		}

		// valid column number
		int col;
		try {
			col = Integer.valueOf(split[1]);
		} catch (NumberFormatException e) {
			System.err.printf("\n\n%s The column you entered dosn't exist. You enterd this one: '%s'.\n\n",
					board.getNextMover().getName(), split[1]);
			return null;
		}

		// valid position
		Position position = new Position(row, col);

		if (board.validateMove(position).equals(VALIDATION.BLOCKED)) {
			System.err.printf("\n\n%s Sorry the position is already used. You enterd this one: '%s'.\n\n",
					board.getNextMover().getName(), position);
			return null;

		}

		if (board.validateMove(position).equals(VALIDATION.OUT_OF_BOARD)) {
			System.err.printf("\n\n%s Sorry the position is not inside the board. You enterd this one: '%s'.\n\n",
					board.getNextMover().getName(), position);
			return null;

		}

		return position;
	}
}
