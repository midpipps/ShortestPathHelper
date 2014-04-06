/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import lejos.util.TextMenu;
import edu.bismarckstate.shortestpathhelper.util.InstructionParser;

/**
 * Menu for choosing what kind of entering skeem to use
 * @author midpipps
 *
 */
public class AddTypeMenu extends Menu {

	/**
	 * The menu system to display options
	 */
	private TextMenu textMenu;
	
	/**
	 * the actual options
	 */
	private String [] menuOptions = {
			//"On Brick",
			"File Enter"
	};
	
	/**
	 * Constructor
	 * @param instructions the instruction parser to use
	 */
	public AddTypeMenu(InstructionParser instructions)
	{
		super("Type of Add", instructions);
		textMenu = new TextMenu(menuOptions, 1, super.MENU_TITLE);
	}
	
	/* (non-Javadoc)
	 * @see edu.bismarckstate.shortestpathhelper.dataentry.Menu#run()
	 */
	@Override
	public Menu run() {
		switch(textMenu.select())
		{
			/*case 0:
				//TODO add the On brick entry menu
				return null;*/
			case 0://file add points
				return new FileAddPointsMenu(instructions);
			default:
				return new MainMenu(super.instructions);
		}
	}

}
