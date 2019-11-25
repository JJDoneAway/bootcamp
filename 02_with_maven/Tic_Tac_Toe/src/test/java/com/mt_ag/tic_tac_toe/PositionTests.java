package com.mt_ag.tic_tac_toe;

import static com.mt_ag.tic_tac_toe.Position.ROWS.B;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PositionTests {

	@Test
	public void testPosition() throws Exception {

		Position pos = new Position(2, 3);
		assertEquals(pos.toString(), "(B,3)");
		System.out.println(pos);

		assertEquals(pos, new Position(2, 3));
		assertEquals(pos, new Position(B, 3));
		assertNotEquals(pos, new Position(3, 2));

		assertEquals(pos.hashCode(), new Position(2, 3).hashCode());

		Position next = new Position(B, 3);
		assertEquals(pos, next);
	}
}
