package com.mt_ag.tic_tac_toe;

import static com.mt_ag.tic_tac_toe.IBoard.GAME_STATUS.A_WINNS;
import static com.mt_ag.tic_tac_toe.IBoard.GAME_STATUS.B_WINNS;
import static com.mt_ag.tic_tac_toe.IBoard.GAME_STATUS.RUNNING;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.A;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.B;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.C;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.mt_ag.tic_tac_toe.impl.Board;
import com.mt_ag.tic_tac_toe.impl.Player;
import com.mt_ag.tic_tac_toe.impl.Position;
public class StatusTest {


	@Test
	public void testGameState() throws Exception {

		// diagonal \
		Player first = new Player("Johannes", 'x');
		Player second = new Player("Annabell", 'o');
		IBoard board = new Board(first, second);

		assertEquals("Game is running", board.checkStatus(), RUNNING);

		board.move(new Position(A, 1));
		assertEquals("Game is running", board.checkStatus(), RUNNING);

		// there must be no winner
		assertNull("game is still running", board.getWinner());

		board.move(new Position(C, 1));
		assertNull("game is still running", board.getWinner());

		board.move(new Position(B, 2));
		assertNull("game is still running", board.getWinner());

		board.move(new Position(C, 2));
		assertNull("game is still running", board.getWinner());

		board.move(new Position(C, 3));
		assertEquals("A is the winner", board.checkStatus(),  A_WINNS);

		System.out.println(board);
		assertEquals("A must be the winner",board.getWinner(), first);

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
		assertEquals(board.checkStatus(), B_WINNS);

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
		assertEquals(board.checkStatus(), A_WINNS);

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
		assertEquals(board.checkStatus(), B_WINNS);

	}

}
