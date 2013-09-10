/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;

/**
 * @author midpipps
 *
 */
public abstract class Menu{
	
	/**
	 * The title that will be displayed with the menu must be set when class is initialized
	 */
	protected final String MENU_TITLE;
	
	protected MovementInstructions instructions;
	
	protected Menu(String title, MovementInstructions instructs){
		MENU_TITLE = title;
		instructions = instructs;
	}
	
	/**
	 * Start the current menu
	 * @return Returns the next menu to display or null if exiting
	 */
	abstract Menu run();

}
