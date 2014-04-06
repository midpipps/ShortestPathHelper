package edu.bismarckstate.shortestpathhelper.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import edu.bismarckstate.shortestpathhelper.dataentry.Menu;

/**
 * The parser for movement instructions
 * @author midpipps
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
	
	@Override
	public Menu getInputMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getEditMenu(int theInstruct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getDeleteMenu(int itemNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void remove(int index)
	{
		instructions.remove(index);
	}

	@Override
	public boolean hasItems() {
		return instructions.size() > 0;
	}
}
