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
		int selection = textMenu.select();
		//if there was actually a selection made then we need to go deeper by 1 menu
		if (selection >= 0)
		{
			return new DeleteModifyMenu(super.instructions, selection);
		}
		return new MainMenu(super.instructions);
	}

	@Override
	public void buttonEvent(Button b) {
		// TODO Auto-generated method stub

	}

}
