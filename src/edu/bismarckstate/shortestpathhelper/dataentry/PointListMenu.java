package edu.bismarckstate.shortestpathhelper.dataentry;

import lejos.nxt.Button;
import lejos.util.TextMenu;

public class PointListMenu extends Menu {

	/**
	 * Will be filled with all the data point in the list
	 */
	private TextMenu textMenu;
	
	/**
	 * The Menu's Title
	 */
	private final String MENU_TITLE = "Data Points List";
	
	/**
	 * The list of data points for the system to push through
	 */
	private String [] datapoints;
	
	@Override
	Menu Run() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void ButtonEvent(Button b) {
		// TODO Auto-generated method stub

	}

}
