package edu.bismarckstate.shortestpathhelper.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

/**
 * The parser for movement instructions
 * @author Lucas Pippenger
 *
 */
public class MovementInstructions implements InstructionParser{

	/**
	 * The list of instructions to use.
	 */
	private ArrayList<MovementInstruction> instructions;
	
	/**
	 * default constructor
	 */
	public MovementInstructions(){
		instructions = new ArrayList<MovementInstruction>();
	}
	
	/**
	 * returns an array of the movement instructions
	 * @return array of movement instructions
	 */
	public MovementInstruction[] getArray()
	{
		return instructions.toArray(new MovementInstruction[instructions.size()]);
	}
	
	/**
	 * removes an instruction from the movement instruction list
	 * @param instruction the instruction to remove most be .equals 
	 * @return true if it was able to remove the instruction
	 */
	public boolean remove(MovementInstruction instruction)
	{
		return instructions.remove(instruction);
	}
	
	/**
	 * Add an instruction to the list
	 * @param instruction the instruction to add
	 * @return true if the instruction was correctly added
	 */
	public boolean add(MovementInstruction instruction)
	{
		return instructions.add(instruction);
	}

	@Override
	/**
	 * Parses a list of string elements from a FileParser into the movement instruction type
	 * @param instructionList the Vector of string from the file parser code. 
	 */
	public void parseStringList(Vector<String> instructionList) {
		
		for (int i = 0; i < instructionList.size(); i++)
		{
			MovementInstruction mi = new MovementInstruction();
			mi.setDirection(Double.parseDouble(instructionList.elementAt(i).trim()));
			i++;
			if (i < instructionList.size())
			{
				mi.setDistance(Double.parseDouble(instructionList.elementAt(i).trim()));
			}
			instructions.add(mi);
		}
	}

	@Override
	/**
	 * Returns a nice string array of elements that the instruction set is holding
	 * @return String array of all the elements for displaying
	 */
	public String[] getToStringArray()
	{
		String[] returnString = new String[instructions.size()];
		for (int i = 0; i < instructions.size(); i++)
		{
			returnString[i] = instructions.get(i).toString();
		}
		
		return returnString;
	}
	
	/**
	 * Returns the collection of movement instructions that is being stored
	 * @return the collection of movement instructions.
	 */
	public Collection<MovementInstruction> getCollection()
	{
		return instructions;
	}
	
	@Override
	/**
	 * Removed the instruction from the position specified.
	 * @param index value of the element to remove
	 */
	public void remove(int index)
	{
		instructions.remove(index);
	}

	@Override
	/**
	 * Returns whether the MovementInstruction has a list of Items or not
	 * @return true if it has any items in it false otherwise
	 */
	public boolean hasItems() {
		return instructions.size() > 0;
	}
}
