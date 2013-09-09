/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;
import lejos.nxt.Button;
import lejos.util.TextMenu;

/**
 * @author midpipps
 *
 */
public class DeleteModifyMenu extends Menu {
	
	private int selectedItem;
	private TextMenu textMenu;
	private String[] menuOptions = {
			"Modify",
			"Delete"
		};
	
	public DeleteModifyMenu(MovementInstructions instructions, int selectedInstruction)
	{
		super("Modify/Delete Menu", instructions);
		selectedItem = selectedInstruction;
		textMenu = new TextMenu(menuOptions, 1, super.MENU_TITLE);
	}

	/* (non-Javadoc)
	 * @see edu.bismarckstate.shortestpathhelper.dataentry.Menu#run()
	 */
	@Override
	public Menu run() {
		int selection = textMenu.select();
		if (selection == 0)
		{
			//Modify
			//TODO add MenuItem to Modify the item.
		}
		else if(selection == 1)
		{
			//Delete
			super.instructions.remove(selectedItem);
		}
		return new PointListMenu(super.instructions);
	}

	/* (non-Javadoc)
	 * @see edu.bismarckstate.shortestpathhelper.dataentry.Menu#buttonEvent(lejos.nxt.Button)
	 */
	@Override
	public void buttonEvent(Button b) {
		// TODO Auto-generated method stub

	}

}
