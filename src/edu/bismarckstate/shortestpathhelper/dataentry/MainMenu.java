/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

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
	 * Title of the menu.  Will display above the list of options
	 */
	private final String MENU_TITLE = "Main Menu";
	
	/**
	 * Options that will show up in the menu.
	 */
	private String[] menuOptions = {
		"Enter New Points",
		"Current Data Points",
		"Finish"
	};
	
	public MainMenu() {
		textMenu = new TextMenu(menuOptions, 5, MENU_TITLE);
	}

	@Override
	public Menu Run() {
		int selectedItem = textMenu.select();
		switch(selectedItem){
			case 0: //Enter New Data Points
				//TODO add menu item for selecting the type of input method
				return null;
			case 1: //Current Data Points
				//TODO add menu item for modifying the entered data
				return null;
			case 2: //Finish
		    default:
				//return null to exit the menu system and return the data structure to the main program
				return null;
		}
		
	}
	
	@Override
	void ButtonEvent(Button b) {
		// TODO Auto-generated method stub
		
	}
}