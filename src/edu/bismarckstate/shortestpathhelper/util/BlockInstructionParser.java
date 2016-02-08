package edu.bismarckstate.shortestpathhelper.util;

import java.util.ArrayList;
import java.util.Vector;

public class BlockInstructionParser implements InstructionParser {


	private BlockPoint finalPoint;
	private ArrayList<BlockBoundingBox> boxes;
	private int numBoxes = 0;
	
	public BlockInstructionParser()
	{
		finalPoint = new BlockPoint();
		boxes = new ArrayList<BlockBoundingBox>();
		numBoxes = 0;
	}
	
	public BlockPoint getFinalPoint()
	{
		return finalPoint;
	}
	
	public ArrayList<BlockBoundingBox> getBoxes()
	{
		return boxes;
	}
	
	@Override
	public void parseStringList(Vector<String> instructionList) {
		
		if (instructionList.size() > 3)
		{
			//first read the number of blocks
			numBoxes = Integer.parseInt(instructionList.elementAt(0).trim());
			instructionList.removeElementAt(0);
			//then we need to get the final point
			finalPoint = new BlockPoint(Double.parseDouble(instructionList.elementAt(0).trim()), Double.parseDouble(instructionList.elementAt(1).trim()));
			instructionList.removeElementAt(0);
			instructionList.removeElementAt(0);
		}
		
		for ( int i = 0; i < numBoxes; i++)
		{
			int numPoints = Integer.parseInt(instructionList.elementAt(i));
			instructionList.removeElementAt(0);
			ArrayList<Double> tempPointsArray = new ArrayList<Double>();
			for (int a = 0; a < numPoints; a++)
			{
				tempPointsArray.add(Double.parseDouble(instructionList.elementAt(0).trim()));
				instructionList.removeElementAt(0);
				tempPointsArray.add(Double.parseDouble(instructionList.elementAt(0).trim()));
				instructionList.removeElementAt(0);
			}
			
			boxes.add(new BlockBoundingBox(numPoints, tempPointsArray));
		}
		
		
		
	}
	
	@Override
	public String[] getToStringArray() {
		String[] returnString = new String[boxes.size() + 1];
		for (int i = 0; i < boxes.size(); i++)
		{
			returnString[i] = boxes.get(i).toString();
		}
		returnString[boxes.size()] = finalPoint.toString();
		return returnString;
	}

	@Override
	public void remove(int index) {
		boxes.remove(index);
		
	}

	@Override
	public boolean hasItems() {
		if (finalPoint.getFinalX() != 0 || finalPoint.getFinalY() != 0)
			return true;
		return false;
	}

}
