package edu.bismarckstate.shortestpathhelper.util;

import java.util.ArrayList;
import java.util.Collection;

public class MovementInstructions {

	private ArrayList<MovementInstruction> instructions;
	
	public MovementInstructions(){
		instructions = new ArrayList<MovementInstruction>();
	}
	
	public String[] getToStringArray()
	{
		String[] returnString = new String[instructions.size()];
		for (int i = 0; i < instructions.size(); i++)
		{
			returnString[i] = instructions.get(i).toString();
		}
		
		return returnString;
	}
	
	public Collection<MovementInstruction> getCollection()
	{
		return instructions;
	}
	
	public MovementInstruction[] getArray()
	{
		return instructions.toArray(new MovementInstruction[instructions.size()]);
	}
	
	public boolean remove(MovementInstruction instruction)
	{
		return instructions.remove(instruction);
	}
	
	public boolean add(MovementInstruction instruction)
	{
		return instructions.add(instruction);
	}
}
