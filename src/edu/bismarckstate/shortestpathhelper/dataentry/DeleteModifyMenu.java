/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;
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
		switch(textMenu.select())
		{
			case 0://Modify
				//TODO add MenuItem to Modify the item.
				break;
			case 1:
				//Delete
				super.instructions.remove(selectedItem);
				break;
		}
		return new PointListMenu(super.instructions);
	}
}
