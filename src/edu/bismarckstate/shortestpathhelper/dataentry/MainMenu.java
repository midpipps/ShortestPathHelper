/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.InstructionParser;
import lejos.util.TextMenu;


/**
 * The main menu for finishing entering new points or viewing/deleting current points
 * @author midpipps
 * @version 1.5
 */
public class MainMenu extends Menu {
	
	/**
	 * TextMenu object for displaying the menus selection options
	 */
	private TextMenu textMenu;
	
	/**
	 * Options that will show up in the menu.
	 */
	private String[] menuOptions = {
		"Enter New Points",
		"Current Points",
		"Finish"
	};
	
	/**
	 * Default constructor sets the menu title to Main Menu
	 */
	public MainMenu(InstructionParser instructions) {
		super("Main Menu", instructions);
		textMenu = new TextMenu(menuOptions, 1, super.MENU_TITLE);
	}

	/**
	 * Starts the menu and returns the next menu object that will need to be run.
	 */
	@Override
	public Menu run() {
		switch(textMenu.select()){
			case 0: //Enter New Data Points
				return new AddTypeMenu(super.instructions);
			case 1: //Current Data Points
				return new PointListMenu(super.instructions);
			case 2: //Finish
		    default:
				//return null to exit the menu system and return the data structure to the main program
				return null;
		}
		
	}
}
