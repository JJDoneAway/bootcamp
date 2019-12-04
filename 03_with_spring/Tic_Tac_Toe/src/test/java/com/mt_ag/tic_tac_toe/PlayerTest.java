package com.mt_ag.tic_tac_toe;

import static com.mt_ag.tic_tac_toe.IPosition.ROWS.A;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.mt_ag.tic_tac_toe.impl.Board;
import com.mt_ag.tic_tac_toe.impl.Player;
import com.mt_ag.tic_tac_toe.impl.Position;

public class PlayerTest {

	@Test
	public void testPlayer() throws Exception {
		try {
			new Player(null, 'x');
			fail();
		} catch (Exception e) {
		}

		// empty name
		try {
			new Player("  ", 'o');
			fail();
		} catch (Exception e) {
		}

		// modify positions
		IPlayer player = new Player("Johannes", 'x');
		try {
			player.getMoves().add(new Position(1, 1));
			fail();
		} catch (Exception e) {
		}

		
		IBoard board = new Board(new Player("a", 'x'), new Player("b", 'o'));
		board.move(new Position(1, 1));
		board.move(new Position(2, 1));
		board.move(new Position(1, 2));
		player = board.getPlayer_a();
		
		assertEquals(player.getMoves().size(), 2);
		assertEquals(player.getMoves().get(0), new Position(A, 1));
		assertEquals(player.getMoves().get(1), new Position(A, 2));
		
		assertEquals(new Player("Johannes   ", 'x'), new Player("Johannes", 'x'));

		assertEquals(new Player("Johannes   ", 'x'), new Player("Johannes", 'o'));

		assertEquals(new Player("Johannes   ", 'x'), new Player("JOHANNes", 'x'));

		assertNotEquals(new Player("Johannes", 'x'), new Player("Karl", 'x'));

		assertEquals(new Player("Johannes   ", 'x').hashCode(), new Player("JOHANNes", 'x').hashCode());

		System.out.println(player.toString());
	}
}
