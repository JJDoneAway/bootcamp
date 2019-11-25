package com.mt_ag.tic_tac_toe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

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
		Player player = new Player("Johannes", 'x');
		try {
			player.getMoves().add(new Position(1, 1));
			fail();
		} catch (Exception e) {
		}

		// add positions already known
		player = new Player("Johannes", 'x');
		player.addMove(new Position(1, 1));
		player.addMove(new Position(1, 2));

		try {
			player.addMove(new Position(1, 1));
			fail();
		} catch (Exception e) {
		}

		assertEquals(player.getMoves().size(), 2);
		
		assertEquals(new Player("Johannes   ", 'x'), new Player("Johannes", 'x'));

		assertEquals(new Player("Johannes   ", 'x'), new Player("Johannes", 'o'));
		
		assertEquals(new Player("Johannes   ", 'x'), new Player("JOHANNes", 'x'));
		
		assertNotEquals(new Player("Johannes", 'x'), new Player("Karl", 'x'));
		
		assertEquals(new Player("Johannes   ", 'x').hashCode(), new Player("JOHANNes", 'x').hashCode());




		System.out.println(player.toString());
	}
}
