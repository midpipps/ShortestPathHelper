/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import edu.bismarckstate.shortestpathhelper.util.InstructionParser;
import lejos.util.TextMenu;

/**
 * Menu to delete specific items from a menu
 * @author midpipps
 *
 */
public class DeleteModifyMenu extends Menu {
	
	/**
	 * the item from instruction parser to change
	 */
	private int selectedItem;
	
	/**
	 * A textmenu to display the items to display to user
	 */
	private TextMenu textMenu;
	
	/**
	 * a menu of items to that are selectable
	 */
	private String[] menuOptions = {
			//"Modify",
			"Delete"
		};
	
	/**
	 * Constructor
	 * @param instructions the instruction parser to use for this menu item that needs to be modified
	 * @param selectedInstruction the instruction that is to be modified
	 */
	public DeleteModifyMenu(InstructionParser instructions, int selectedInstruction)
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
			/*case 0://Modify
				//TODO add MenuItem to Modify the item.
				break;*/
			case 0:
				//Delete
				super.instructions.remove(selectedItem);
				break;
		}
		return new PointListMenu(super.instructions);
	}
}
