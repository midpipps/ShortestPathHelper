/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import lejos.util.TextMenu;
import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;

/**
 * @author midpipps
 *
 */
public class AddTypeMenu extends Menu {

	private TextMenu textMenu;
	private String [] menuOptions = {
			"On Brick",
			"File Enter"
	};
	
	public AddTypeMenu(MovementInstructions instructions)
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
			case 0:
				//TODO add the On brick entry menu
				return null;
			case 1://file add points
				return new FileAddPointsMenu(instructions);
			default:
				return new MainMenu(super.instructions);
		}
	}

}
