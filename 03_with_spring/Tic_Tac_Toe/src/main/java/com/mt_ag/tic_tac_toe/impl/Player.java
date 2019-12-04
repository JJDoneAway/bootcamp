package com.mt_ag.tic_tac_toe.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mt_ag.tic_tac_toe.IPlayer;
import com.mt_ag.tic_tac_toe.IPosition;

public class Player implements IPlayer {

	private String name;
	private char sign;
	private List<IPosition> moves = new ArrayList<IPosition>();
	
	public Player(String name, char sign) {
		if(name == null || name.trim().equals("")) {
			throw new IllegalArgumentException("Name must not be null or empty");
		}
		this.name = name.trim();
		this.sign = sign;
	}
	
	List<IPosition> addMove(IPosition newPosition){
		if(positionBlocked(newPosition)) {
			throw new IllegalArgumentException(String.format("Position is already used: %s", newPosition));
		}
		
		this.moves.add(newPosition);
		
		return getMoves();
	}
	
	@Override
	public boolean positionBlocked(IPosition toBeChecked) {
		return this.moves.contains(toBeChecked);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public char getSign() {
		return sign;
	}
	
	@Override
	public List<IPosition> getMoves() {
		return Collections.unmodifiableList(moves);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", sign=" + sign + ", moves=" + moves + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name.toLowerCase() != null)
				return false;
		} else if (!name.toLowerCase().equals(other.name.toLowerCase()))
			return false;
		return true;
	}
	
	
}
