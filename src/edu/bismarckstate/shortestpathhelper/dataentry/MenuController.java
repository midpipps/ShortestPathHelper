/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import java.util.Collection;

import lejos.nxt.LCD;
import edu.bismarckstate.shortestpathhelper.util.MovementInstruction;
import edu.bismarckstate.shortestpathhelper.util.MovementInstructions;

/**
 * @author midpipps
 * @version 0.0.1
 */
public class MenuController {

	public Collection<MovementInstruction> Start()
	{
		MovementInstructions instructions = new MovementInstructions();
		Menu currentMenu = new MainMenu(instructions);
		while (currentMenu != null)
		{
			LCD.clear();
			currentMenu = currentMenu.run();
		}
		
		return instructions.getCollection();
	}
	
	public static void main(String [] args)
	{
		MenuController test = new MenuController();
		test.Start();
	}
}
