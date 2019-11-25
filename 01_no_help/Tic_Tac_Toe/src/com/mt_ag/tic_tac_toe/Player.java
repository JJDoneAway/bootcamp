package com.mt_ag.tic_tac_toe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

	private String name;
	private char sign;
	private List<Position> moves = new ArrayList<Position>();
	
	public Player(String name, char sign) {
		if(name == null || name.trim().equals("")) {
			throw new IllegalArgumentException("Name must not be null or empty");
		}
		this.name = name;
		this.sign = sign;
	}
	
	List<Position> addMove(Position newPosition){
		if(positionBlocked(newPosition)) {
			throw new IllegalArgumentException(String.format("Position is already used: %s", newPosition));
		}
		
		this.moves.add(newPosition);
		
		return getMoves();
	}
	
	public boolean positionBlocked(Position toBeChecked) {
		return this.moves.contains(toBeChecked);
	}
	
	public String getName() {
		return name;
	}
	
	public char getSign() {
		return sign;
	}
	
	public List<Position> getMoves() {
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sign;
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
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sign != other.sign)
			return false;
		return true;
	}
	
	
}
