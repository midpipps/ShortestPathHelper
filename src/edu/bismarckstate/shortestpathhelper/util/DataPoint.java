package edu.bismarckstate.shortestpathhelper.util;

public class DataPoint {

	
	private double distance;
	
	
	private Direction direction;
	
	
	public DataPoint(){
		setDirection(Direction.NORTH);
		setDistance(0);
	}
	
	public DataPoint(Direction d){
		setDirection(d);
		setDistance(0);
	}
	
	public DataPoint(Direction d, double distanceToTravel){
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
}
