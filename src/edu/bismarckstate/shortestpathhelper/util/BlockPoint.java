package edu.bismarckstate.shortestpathhelper.util;

public class BlockPoint {

	private double finalX = 0;
	private double finalY = 0;
	
	public BlockPoint()
	{
		this.finalX = 0;
		this.finalY = 0;
	}
	
	public BlockPoint(double x, double y)
	{
		this.finalX = x;
		this.finalY = y;
	}
	
	public double getFinalX()
	{
		return this.finalX;
	}
	
	public void setFinalX(double x)
	{
		this.finalX = x;
	}
	
	public double getFinalY()
	{
		return this.finalY;
	}
	
	public void setFinalY(double y)
	{
		this.finalY = y;
	}
	
	@Override
	public String toString() {
		return "<" + this.finalX + ", " + this.finalY + ">";
	}
	
}
