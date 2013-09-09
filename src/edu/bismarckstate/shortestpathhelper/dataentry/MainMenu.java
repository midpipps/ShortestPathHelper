/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;
import lejos.nxt.Button;
import lejos.util.TextMenu;


/**
 * @author midpipps
 * @version 0.0.1
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
		"Current Data Points",
		"Finish"
	};
	
	/**
	 * Default constructor sets the menu title to Main Menu
	 */
	public MainMenu(MovementInstructions instructions) {
		super("Main Menu", instructions);
		textMenu = new TextMenu(menuOptions, 1, super.MENU_TITLE);
	}

	/**
	 * Starts the menu and returns the next menu object that will need to be run.
	 */
	@Override
	public Menu run() {
		int selectedItem = textMenu.select();
		switch(selectedItem){
			case 0: //Enter New Data Points
				//TODO add menu item for selecting the type of input method
				return null;
			case 1: //Current Data Points
				return new PointListMenu(super.instructions);
			case 2: //Finish
		    default:
				//return null to exit the menu system and return the data structure to the main program
				return null;
		}
		
	}
	
	@Override
	void buttonEvent(Button b) {
		// TODO Auto-generated method stub
		
	}
}
