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

	private MovementInstructions instructions;
	
	public MovementInstructions getInstructions()
	{
		return instructions;
	}
	
	public void setInstructions(MovementInstructions instruct)
	{
		instructions = instruct;
	}
	
	public Collection<MovementInstruction> Start()
	{
		
		Menu currentMenu = new MainMenu(instructions);
		while (currentMenu != null)
		{
			LCD.clear();
			currentMenu = currentMenu.run();
		}
		
		return instructions.getCollection();
	}
}
