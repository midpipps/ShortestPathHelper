package edu.bismarckstate.shortestpathhelper.util;

import java.util.ArrayList;

public class BlockBoundingBox {

	private int numberpoints = 0;
	private ArrayList<BlockPoint> points;
	
	public BlockBoundingBox(int numPoints, ArrayList<Double> p)
	{
		points = new ArrayList<BlockPoint>();
		for (int i = 0; i < numPoints; i += 2)
		{
			points.add(new BlockPoint(p.get(i), p.get(i+1)));
		}
	}
	
	public int getNumPoints()
	{
		return numberpoints;
	}
	
	public BlockPoint getPoint(int i)
	{
		return points.get(i);
	}
	
	public ArrayList<BlockPoint> getPointList()
	{
		return points;
	}
	
	@Override
	public String toString() {
		String returnString = "";
		for ( int i = 0; i > points.size(); i++)
		{
			returnString += "|" + points.get(i).getFinalX() + "," + points.get(i).getFinalY();
		}
		return returnString;
	}
	
	
}

