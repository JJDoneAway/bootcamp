package com.mt_ag.tic_tac_toe;

import java.util.List;

public interface IPlayer {

	boolean positionBlocked(IPosition toBeChecked);

	String getName();

	char getSign();

	List<IPosition> getMoves();

}