package edu.bismarckstate.shortestpathhelper.dataentry;

import lejos.nxt.Button;
import lejos.util.TextMenu;

public class PointListMenu extends Menu {

	/**
	 * Will be filled with all the data point in the list
	 */
	private TextMenu textMenu;
	
	/**
	 * default constructor sets the menu title to Data Points List
	 */
	public PointListMenu(){
		super("Data Points List", null);
		textMenu = new TextMenu(null, 5, super.MENU_TITLE);
	}
	
	@Override
	public Menu Run() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ButtonEvent(Button b) {
		// TODO Auto-generated method stub

	}

}
