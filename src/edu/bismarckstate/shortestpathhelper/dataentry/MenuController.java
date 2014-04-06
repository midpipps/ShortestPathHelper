/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import lejos.nxt.LCD;

/**
 * Menu controller just keeps the menus running and keeps them running until the current menu becomes false
 * @author midpipps
 * @version 0.0.5
 */
public class MenuController {

	/**
	 * The initial menu for the system to start on
	 */
	private Menu startMenu;
		
	/**
	 * Start the menu system will continue until the menus return null
	 * @return true if the menus filled the instruction set with anything false otherwise
	 */
	public boolean Start()
	{
		
		Menu currentMenu = startMenu;
		while (currentMenu != null)
		{
			LCD.clear();
			currentMenu = currentMenu.run();
		}
		
		if (startMenu.instructions.hasItems())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Constructor passing in just the menu
	 * @param sMenu the menu item with the instruction parser already created in it.
	 */
	public MenuController(Menu sMenu)
	{
		startMenu = sMenu;
	}
}
