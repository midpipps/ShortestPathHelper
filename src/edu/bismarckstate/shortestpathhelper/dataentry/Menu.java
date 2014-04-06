/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.InstructionParser;

/**
 * Abstract class for all the menus keeps the InstructionParser and titles up to date
 * @author midpipps
 *
 */
public abstract class Menu{
	
	/**
	 * The title that will be displayed with the menu must be set when class is initialized
	 */
	protected final String MENU_TITLE;
	
	/**
	 * The instructionParser to use for the system
	 */
	protected InstructionParser instructions;
	
	/**
	 * Constructor with title and instructionparser passed in
	 * @param title the title to display on the menu
	 * @param instructs the instruction parser to use for instructions
	 */
	protected Menu(String title, InstructionParser instructs){
		MENU_TITLE = title;
		instructions = instructs;
	}
	
	/**
	 * Start the current menu
	 * @return Returns the next menu to display or null if exiting
	 */
	abstract Menu run();

}
