/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import java.util.ArrayList;

import lejos.nxt.Button;

/**
 * @author midpipps
 *
 */
public abstract class Menu{
	
	/**
	 * Start the current menu
	 * @return Returns the next menu to display or null if exiting
	 */
	abstract Menu Run();
	
	/**
	 * Pass any button events into the menus not sure about this one yet
	 * @param b
	 */
	abstract void ButtonEvent(Button b);

}
