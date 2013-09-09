package edu.bismarckstate.shortestpathhelper.util;

import java.util.Collection;

public class MovementInstructions {

	private Collection<MovementInstruction> instructions;
	
	public MovementInstruction[] getArray()
	{
		return instructions.toArray(new MovementInstruction[instructions.size()]);
	}
}
