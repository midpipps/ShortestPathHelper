/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import java.io.File;
import java.util.ArrayList;

import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;
import lejos.nxt.Button;
import lejos.util.TextMenu;

/**
 * @author midpipps
 *
 */
public class FileAddPointsMenu extends Menu {

	private TextMenu textMenu;
	
	
	public FileAddPointsMenu(MovementInstructions instructions)
	{
		super("File Add Menu", instructions);
		textMenu = new TextMenu(null, 1, super.MENU_TITLE);
	}
	
	/* (non-Javadoc)
	 * @see edu.bismarckstate.shortestpathhelper.dataentry.Menu#run()
	 */
	@Override
	public Menu run() {
		// TODO Auto-generated method stub
		File[] files = File.listFiles();
		ArrayList<String> menuOptions = new ArrayList<String>();
		for (int i = 0; i < files.length; i++)
		{
			if (files[i] != null && files[i].getName().indexOf(".pnt") >= 0)
			{
				menuOptions.add(files[i].getName());
			}
		}
		textMenu.setItems(menuOptions.toArray(new String[menuOptions.size()]));
		int selection = textMenu.select();
		if (selection >= 0)
		{
			//TODO load the data into the instruction set
		}	
		return new AddTypeMenu(super.instructions);
	}
}
