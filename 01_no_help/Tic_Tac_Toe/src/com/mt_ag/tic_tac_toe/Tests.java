package com.mt_ag.tic_tac_toe;

import static com.mt_ag.tic_tac_toe.Board.VALIDATION.BLOCKED;
import static com.mt_ag.tic_tac_toe.Board.VALIDATION.OK;
import static com.mt_ag.tic_tac_toe.Board.VALIDATION.OUT_OF_BOARD;
import static com.mt_ag.tic_tac_toe.Position.ROWS.A;
import static com.mt_ag.tic_tac_toe.Position.ROWS.B;
import static com.mt_ag.tic_tac_toe.Position.ROWS.C;
import static com.mt_ag.tic_tac_toe.Position.ROWS.D;
import static com.mt_ag.tic_tac_toe.Board.GAME_STATUS.*;

import java.util.List;

public class Tests {

	public static void main(String[] args) {
		testPosition();
		testPlayer();
		testBoard();
		testGameState();
	}

	private static void testGameState() {
		System.out.println("------------------------------------");
		System.out.println("Test the status of the game");
		// diagonal \
		Player first = new Player("Johannes", 'x');
		Player second = new Player("Annabell", 'o');
		Board board = new Board(first, second);

		if (!board.checkStatus().equals(RUNNING)) {
			throw new IllegalArgumentException("Game is running");
		}

		board.move(new Position(A, 1));
		if (!board.checkStatus().equals(RUNNING)) {
			throw new IllegalArgumentException("Game is running");
		}
		// there must be no winner
		if (board.getWinner() != null) {
			throw new RuntimeException("game is still running");
		}
		board.move(new Position(C, 1));
		if (!board.checkStatus().equals(RUNNING)) {
			throw new IllegalArgumentException("Game is running");
		}

		board.move(new Position(B, 2));
		if (!board.checkStatus().equals(RUNNING)) {
			throw new IllegalArgumentException("Game is running");
		}

		board.move(new Position(C, 2));
		if (!board.checkStatus().equals(RUNNING)) {
			throw new IllegalArgumentException("Game is running");
		}

		board.move(new Position(C, 3));
		if (!board.checkStatus().equals(A_WINNS)) {
			throw new IllegalArgumentException("a wins");
		}
		System.out.println(board);
		if (!board.getWinner().equals(first)) {
			throw new RuntimeException("a wins");
		}
		System.out.println();

		// diagonal /
		first = new Player("Johannes", 'x');
		second = new Player("Annabell", 'o');
		board = new Board(first, second);
		board.move(new Position(A, 1));
		board.move(new Position(A, 3));

		board.move(new Position(A, 2));
		board.move(new Position(B, 2));

		board.move(new Position(B, 1));
		board.move(new Position(C, 1));
		System.out.println(board);
		System.out.println();
		if (!board.checkStatus().equals(B_WINNS)) {
			throw new IllegalArgumentException("b winns");
		}

		// row 2
		first = new Player("Johannes", 'x');
		second = new Player("Annabell", 'o');
		board = new Board(first, second);
		board.move(new Position(B, 1));
		board.move(new Position(A, 3));

		board.move(new Position(B, 2));
		board.move(new Position(A, 1));

		board.move(new Position(B, 3));
		System.out.println(board);
		System.out.println();
		if (!board.checkStatus().equals(A_WINNS)) {
			throw new IllegalArgumentException("a winns");
		}

		// column 3
		first = new Player("Johannes", 'x');
		second = new Player("Annabell", 'o');
		board = new Board(first, second);
		board.move(new Position(A, 1));
		board.move(new Position(A, 3));

		board.move(new Position(A, 2));
		board.move(new Position(C, 3));

		board.move(new Position(B, 2));
		board.move(new Position(B, 3));
		System.out.println(board);
		System.out.println();
		if (!board.checkStatus().equals(B_WINNS)) {
			throw new IllegalArgumentException("b winns");
		}

	}

	private static void testBoard() {
		System.out.println("------------------------------------");
		System.out.println("Test the Board");
		// null constructor
		boolean cought = false;
		Player first = new Player("Johannes", 'x');
		try {
			new Board(null, first);
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("Players must not be null");
		}

		cought = false;
		try {
			new Board(first, first);
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("Players must not be same");
		}

		cought = false;
		try {
			new Board(first, new Player("Annabell", 'x'));
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("Players must not have same sign");
		}

		Player second = new Player("Annabell", 'o');
		Board board = new Board(first, second);
		if (!board.move(new Position(A, 1)).equals(OK) | !board.move(new Position(A, 3)).equals(OK)) {
			throw new RuntimeException("Must be OK");
		}

		if (!board.move(new Position(A, 1)).equals(BLOCKED)) {
			throw new RuntimeException("Must be OK");
		}

		board.move(new Position(B, 2));
		board.move(new Position(B, 3));

		board.move(new Position(C, 3));

		if (board.getCurrentMove() != 5) {
			throw new IllegalArgumentException("Current move is 5");
		}

		if (!board.getNextMover().equals(second)) {
			throw new IllegalArgumentException("Next mover must be Annabell");
		}
		System.out.printf("Next mover: %s\n", board.getNextMover());

		// check to move if game is over
		cought = false;
		try {
			board.move(new Position(B, 1));
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("Game is over");
		}

		List<Position> firstMoves = first.getMoves();
		if (!(firstMoves.size() == 3 //
				&& firstMoves.contains(new Position(A, 1)) //
				&& firstMoves.contains(new Position(B, 2)) //
				&& firstMoves.contains(new Position(C, 3)))) {

			throw new IllegalArgumentException("Wrong number of moves");
		}

		System.out.println(board);
		System.out.printf("Next mover: %s with %s\n", board.getNextMover().getName(), board.getNextMover().getSign());

		if (!board.validateMove(new Position(B, 1)).equals(OK)) {
			throw new RuntimeException("Position must be valid");
		}
		if (!board.validateMove(new Position(B, 2)).equals(BLOCKED)) {
			throw new RuntimeException("Position must be blocked");
		}
		if (!board.validateMove(new Position(B, 3)).equals(BLOCKED)) {
			throw new RuntimeException("Position must be blocked");
		}
		if (!board.validateMove(new Position(B, 0)).equals(OUT_OF_BOARD)) {
			throw new RuntimeException("Position must be out of board");
		}
		if (!board.validateMove(new Position(D, 1)).equals(OUT_OF_BOARD)) {
			throw new RuntimeException("Position must be out of board");
		}
		if (!board.validateMove(new Position(A, 4)).equals(OUT_OF_BOARD)) {
			throw new RuntimeException("Position must be out of board");
		}
		if (!board.validateMove(new Position(0, 1)).equals(OUT_OF_BOARD)) {
			throw new RuntimeException("Position must be out of board");
		}

	}

	private static void testPlayer() {
		System.out.println("------------------------------------");
		System.out.println("Test the Player");
		// null constructor
		boolean cought = false;
		try {
			new Player(null, 'x');
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("Name must not be null");
		}

		// empty name
		cought = false;
		try {
			new Player("  ", 'o');
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("Name must not be empty");
		}

		// modify positions
		Player player = new Player("Johannes", 'x');
		cought = false;
		try {
			player.getMoves().add(new Position(1, 1));
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("must not be possible to change moves.");
		}

		// add positions already known
		player = new Player("Johannes", 'x');
		player.addMove(new Position(1, 1));
		player.addMove(new Position(1, 2));
		cought = false;
		try {
			player.addMove(new Position(1, 1));
		} catch (Exception e) {
			cought = true;
		}
		if (!cought) {
			throw new RuntimeException("must not be possible add a position tvice.");
		}

		if (player.getMoves().size() != 2) {
			throw new RuntimeException("Size must be 2");
		}

		System.out.println(player.toString());
	}

	public static void testPosition() {
		System.out.println("------------------------------------");
		System.out.println("Test the Position");

		Position pos = new Position(2, 3);
		if (!pos.toString().equals("(B,3)")) {
			throw new RuntimeException(String.format("Wrong toString Format. %s", pos.toString()));
		}
		System.out.println(pos);

		if (!pos.equals(new Position(2, 3))) {
			throw new RuntimeException(String.format("wrong equal"));
		}

		if (pos.equals(new Position(3, 2))) {
			throw new RuntimeException(String.format("wrong equal"));
		}

		if (pos.hashCode() != new Position(2, 3).hashCode()) {
			throw new RuntimeException(String.format("wrong hash"));
		}

		Position next = new Position(B, 3);
		System.out.println(next);
		if (!next.equals(pos)) {
			throw new RuntimeException("Positions must be equal");
		}
	}
}
