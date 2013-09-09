package edu.bismarckstate.shortestpathhelper.util;

public class MovementInstruction {

	
	private double distance;
	
	
	private Direction direction;
	
	
	public MovementInstruction(){
		setDirection(Direction.NORTH);
		setDistance(0);
	}
	
	public MovementInstruction(Direction d){
		setDirection(d);
		setDistance(0);
	}
	
	public MovementInstruction(Direction d, double distanceToTravel){
		setDirection(d);
		setDistance(distanceToTravel);
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public void setDirection(Direction d){
		direction = d;
	}
	
	public double getDistance(){
		return distance;
	}
	
	public void setDistance(double d){
		distance = d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MovementInstruction other = (MovementInstruction) obj;
		if (direction != other.direction)
			return false;
		if (Double.doubleToLongBits(distance) != Double
				.doubleToLongBits(other.distance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "<" + distance + ", " + direction
				+ ">";
	}
	
	
}
