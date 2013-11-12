/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.util;

/**
 * @author midpipps
 *
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
}
