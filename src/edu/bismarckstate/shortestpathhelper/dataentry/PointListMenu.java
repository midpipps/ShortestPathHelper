package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;
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
	public PointListMenu(MovementInstructions instructions){
		super("Data Points List", instructions);
		textMenu = new TextMenu(super.instructions.getToStringArray(), 1, super.MENU_TITLE);
	}
	
	@Override
	public Menu run() {
		// TODO Auto-generated method stub
		textMenu.select();
		return new MainMenu(super.instructions);
	}

	@Override
	public void buttonEvent(Button b) {
		// TODO Auto-generated method stub

	}

}
