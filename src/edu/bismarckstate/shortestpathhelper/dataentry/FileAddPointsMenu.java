package edu.bismarckstate.shortestpathhelper.dataentry;

import java.io.File;
import java.util.ArrayList;

import edu.bismarckstate.shortestpathhelper.util.FileParser;
import edu.bismarckstate.shortestpathhelper.util.FileParserException;
import edu.bismarckstate.shortestpathhelper.util.InstructionParser;
import lejos.nxt.Button;
import lejos.util.TextMenu;

/**
 * Menu to add points from a file
 * @author Lucas Pippenger
 * @version 1.5
 */
public class FileAddPointsMenu extends Menu {

	/**
	 * will be the menu item to use for displaying
	 */
	private TextMenu textMenu;
	
	/**
	 * The constructor
	 * @param instructions the instruction parser to use for the menu
	 */
	public FileAddPointsMenu(InstructionParser instructions)
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
			try{
				super.instructions.parseStringList(FileParser.readFile(menuOptions.get(selection)));
			}catch(FileParserException ioe){
				System.out.println("error:" + ioe.getMessage());
				Button.ENTER.waitForPressAndRelease();
			}catch(Exception ex){
				System.out.println("error:" + ex.getMessage());
				Button.ENTER.waitForPressAndRelease();
			}
		}	
		return new AddTypeMenu(super.instructions);
	}
}
