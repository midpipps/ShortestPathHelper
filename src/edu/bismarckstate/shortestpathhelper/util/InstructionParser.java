package edu.bismarckstate.shortestpathhelper.util;

import java.util.Vector;

import edu.bismarckstate.shortestpathhelper.dataentry.Menu;

/**
 * Interface for instruction parser to deal with how the system returns the files read in and putting them into an instruction set
 * @author Lucas Pippenger
 *
 */
public interface InstructionParser {
	/**
	 * Parses a vector of strings into the correct instructions
	 * @param instructionList the read in instructions from the file. 1 string per line.
	 */
	public void parseStringList(Vector<String> instructionList);
	
	/**
	 * gets a menu object to parse input a new data point
	 * @return the menu to take in a new data point
	 */
	public Menu getInputMenu();
	
	/**
	 * gets a menu object to edit the current instruction
	 * @return
	 */
	public Menu getEditMenu(int theInstruct);
	
	/**
	 * Gets a menu for deleting an instruction
	 * @param the instruction number to delete
	 * @return the menu to delete an instruction
	 */
	public Menu getDeleteMenu(int itemNumber);
	
	/**
	 * Returns an array of string to show all the instructions in the system
	 * @return String of instruction representation
	 */
	public String[] getToStringArray();
	
	/**
	 * Remove the Instruction at index position
	 * @param index the position of the instruction to remove
	 */
	public void remove(int index);
	
	/**
	 * checks if the internal list has items or not.
	 * @return true if there are items in the list false if not.
	 */
	public boolean hasItems();
	
	
}
