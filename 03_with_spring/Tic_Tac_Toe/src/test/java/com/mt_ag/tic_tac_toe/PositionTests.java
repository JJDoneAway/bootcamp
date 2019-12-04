package com.mt_ag.tic_tac_toe;

import static com.mt_ag.tic_tac_toe.IPosition.ROWS.B;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.mt_ag.tic_tac_toe.impl.Position;

public class PositionTests {

	@Test
	public void testPosition() throws Exception {

		IPosition pos = new Position(2, 3);
		assertEquals(pos.toString(), "(B,3)");
		System.out.println(pos);

		assertEquals(pos, new Position(2, 3));
		assertEquals(pos, new Position(B, 3));
		assertNotEquals(pos, new Position(3, 2));

		assertEquals(pos.hashCode(), new Position(2, 3).hashCode());

		IPosition next = new Position(B, 3);
		assertEquals(pos, next);
	}
}
