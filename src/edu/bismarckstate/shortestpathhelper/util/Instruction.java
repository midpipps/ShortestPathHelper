/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.util;

/**
 * @author midpipps
 * @version 1.1
 */
public interface Instruction {

	/**
	 * Get the degrees to turn for this instruction set based on current angle
	 * @param currentAngle the current angle the robot is facing
	 * @return the fixed degree that it should turn
	 */
	double getNormalizedTurn(double currentAngle);
	
	/**
	 * Get the distance the robot should travel
	 * @return a double of the distance to travel
	 */
	double getNormalizedDistance();
	
	/**
	 * Set the first param from the 
	 * @param par1 - a value to set a param to
	 */
	void setParam1(double par1);
	
	/**
	 * set the second param
	 * @param par2 a value to set the param to
	 */
	void setParam2(double par2);
	
	/**
	 * set param1 and param 2
	 * @param par1 value to set param 1
	 * @param par2 value to set param 2
	 */
	void setParams(double par1, double par2);
}
