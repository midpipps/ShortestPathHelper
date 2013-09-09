/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import java.util.Collection;

import lejos.nxt.LCD;
import edu.bismarckstate.shortestpathhelper.util.Direction;
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
	
	/**
	 * Used for testing right now will be deleted before the end
	 * @param args
	 */
	public static void main(String [] args)
	{
		MenuController test = new MenuController();
		MovementInstructions instructions = new MovementInstructions();
		instructions.add(new MovementInstruction(Direction.NORTH, 9));
		instructions.add(new MovementInstruction(Direction.SOUTH, 5));
		instructions.add(new MovementInstruction(Direction.EAST, 100));
		instructions.add(new MovementInstruction(Direction.WEST, 20));
		instructions.add(new MovementInstruction(Direction.NORTH, 10));
		instructions.add(new MovementInstruction(Direction.EAST, 8));
		test.setInstructions(instructions);
		test.Start();
	}
}
