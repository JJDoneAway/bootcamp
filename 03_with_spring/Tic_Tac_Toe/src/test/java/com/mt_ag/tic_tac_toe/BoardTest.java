package com.mt_ag.tic_tac_toe;

import static com.mt_ag.tic_tac_toe.IBoard.VALIDATION.BLOCKED;
import static com.mt_ag.tic_tac_toe.IBoard.VALIDATION.OK;
import static com.mt_ag.tic_tac_toe.IBoard.VALIDATION.OUT_OF_BOARD;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.A;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.B;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.C;
import static com.mt_ag.tic_tac_toe.IPosition.ROWS.D;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.mt_ag.tic_tac_toe.impl.Board;
import com.mt_ag.tic_tac_toe.impl.Player;
import com.mt_ag.tic_tac_toe.impl.Position;

public class BoardTest {

	@Test(expected = IllegalArgumentException.class)
	public void samePlayers() throws Exception{
		new Board(new Player("Johannes", 'x'), new Player("JOhannes", 'o'));
	}

	@Test
	public void testBoard() throws Exception {
		// null constructor
		Player first = new Player("Johannes", 'x');
		try {
			new Board(null, first);
			fail();
		} catch (Exception e) {
		}

		try {
			new Board(first, first);
			fail();
		} catch (Exception e) {
		}
		

		try {
			new Board(first, new Player("Annabell", 'x'));
			fail();
		} catch (Exception e) {
		}

		Player second = new Player("Annabell", 'o');
		IBoard board = new Board(first, second);

		assertEquals(board.move(new Position(A, 1)), OK);
		assertEquals(board.move(new Position(A, 3)), OK);

		assertEquals(board.move(new Position(A, 1)), BLOCKED);

		board.move(new Position(B, 2));
		board.move(new Position(B, 3));

		board.move(new Position(C, 3));

		assertEquals(board.getCurrentMove(), 5);

		assertEquals(board.getNextMover(), second);
		System.out.printf("Next mover: %s\n", board.getNextMover());

		try {
			board.move(new Position(B, 1));
			fail();
		} catch (Exception e) {
		}

		List<IPosition> firstMoves = first.getMoves();
		assertTrue((firstMoves.size() == 3 //
				&& firstMoves.contains(new Position(A, 1)) //
				&& firstMoves.contains(new Position(B, 2)) //
				&& firstMoves.contains(new Position(C, 3))));

		System.out.println(board);
		System.out.printf("Next mover: %s with %s\n", board.getNextMover().getName(), board.getNextMover().getSign());

		assertEquals(board.validateMove(new Position(B, 1)), OK);
		assertEquals(board.validateMove(new Position(B, 2)), BLOCKED);
		assertEquals(board.validateMove(new Position(B, 3)), BLOCKED);
		assertEquals(board.validateMove(new Position(B, 0)), OUT_OF_BOARD);
		assertEquals(board.validateMove(new Position(D, 1)), OUT_OF_BOARD);
		assertEquals(board.validateMove(new Position(A, 4)), OUT_OF_BOARD);
		assertEquals(board.validateMove(new Position(0, 1)), OUT_OF_BOARD);

	}
}
