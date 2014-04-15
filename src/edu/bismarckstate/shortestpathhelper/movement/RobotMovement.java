package edu.bismarckstate.shortestpathhelper.movement;

import java.io.IOException;
import java.util.Vector;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import edu.bismarckstate.shortestpathhelper.util.FileParser;
import edu.bismarckstate.shortestpathhelper.util.Instruction;

/**
 * Used to move the robot in simple ways will load a file to setup the robot for correct movement.
 * @author midpipps
 */
public class RobotMovement {

	/**
	 * the degrees the robot is facing
	 */
	private double facing;
	
	/**
	 * the differential pilot that robot movement uses to move around
	 */
	private DifferentialPilot diffPilot;
	
	/**
	 * used to keep track of if the pilot is setup ok or not.
	 */
	private boolean diffPilotSetup = false;
	
	/**
	 * The morot assigned to left side
	 */
	private NXTRegulatedMotor left = Motor.A;
	
	/**
	 * the motor assigned to right side
	 */
	private NXTRegulatedMotor right = Motor.A;
	
	/**
	 * Default Constructor uses the default file name of robotsetup.rbt
	 */
	public RobotMovement(){
		setDifferentialPilotFromFile("robotsetup.rbt");
	}
	
	/**
	 * Used for custom robots.
	 * @param wheel The name of the file holding the wheel diameter. Just put the wheel diameter in the file, nothing else.
	 * @param trackW The name of the file holding the track Width. Just put the track width in the file, nothing else.
	 */
	public RobotMovement(String fileName){
		setDifferentialPilotFromFile(fileName);
	}
	
	/**
	 * sets the base diff pilot up and also sets the boolean value to tell if the pilot correctly set up or not
	 * @param fileName the string filename of the pilot setup file
	 */
	private void setDifferentialPilotFromFile(String fileName)
	{
		double trackwidth = 0;
		double wheelwidth = 0;
		left = Motor.B;
		right = Motor.A;
		boolean reversed = false;
		boolean fileReadok = true;
		try
		{
			Vector<String> fileData = FileParser.readFile(fileName);
			if (fileData != null && fileData.size() == 5){
					left = getMotorFromString(fileData.elementAt(0));
					right = getMotorFromString(fileData.elementAt(1));
					trackwidth = Double.parseDouble(fileData.elementAt(2).trim());
					wheelwidth = Double.parseDouble(fileData.elementAt(3).trim());
					reversed = getMotorReversed(fileData.elementAt(4).trim());
			}else{
				fileReadok = false;
			}
		}catch(IOException ioe){
			fileReadok = false;
			System.out.println("error:" + ioe.getMessage());
			Button.ENTER.waitForPressAndRelease();
		}catch(Exception ex){
			fileReadok = false;
			System.out.println("error:" + ex.getMessage());
			Button.ENTER.waitForPressAndRelease();
		}
		
		if (fileReadok){
			this.diffPilotSetup = true;
			this.diffPilot = new DifferentialPilot(wheelwidth, trackwidth, left, right,reversed);
		} else {
			this.diffPilotSetup = false;
		}
	}
	
	/**
	 * Changes from string representation of a motor to an actual motor port
	 * @param motorLetter the letter of the motor A, B, C
	 * @return the regulated motor that is defined by the string passed in
	 * @throws Exception Generic exception if something went wrong
	 */
	private NXTRegulatedMotor getMotorFromString(String motorLetter) throws Exception{
		if (motorLetter.toLowerCase().equals("a")){
			return Motor.A;
		} else if (motorLetter.toLowerCase().equals("b")){
			return Motor.B;
		} else if (motorLetter.toLowerCase().equals("c")){
			return Motor.C;
		}else{
			throw new Exception("Error finding a motor");
		}
	}
	
	/**
	 * takes in a string of 1 or anything else 1 for reversed anything else for not
	 * @param reversed string param 1 for reversed 0 for not reversed
	 * @return true if reversed false otherwise.
	 */
	private boolean getMotorReversed(String reversed){
		if (reversed.equals("1"))
			return true;
		else
			return false;
	}
	
	/**
	 * Checks if the diffpilot was created correctly
	 * @return true if diffpilot was created ok false if not
	 */
	public boolean isDiffPilotOk()
	{
		return diffPilot != null && diffPilotSetup;
	}
	
	/**
	 * Calls the move with immediate return set to false; Always resets tach counts before moving forward
	 * @param theMove the movement Instruction to move
	 */
	public void move(Instruction theMove)
	{
		move(theMove, false);
	}
	
	/**
	 * Moves the robot according to MovementInstruction always resets motor tach counts before moving
	 * @param theMove The instruction you want to send. Should have a direction and distance.
	 * 				Will face the direction (north south east or west, or 0 to 360) and move the distance you send.
	 * @param immediateReturnAfterRotate Return immediately to calling code if this bool is set to true.
	 */
	public void move(Instruction theMove, boolean immediateReturnAfterRotate){
		
		double dist = theMove.getNormalizedDistance();
		double rot = theMove.getNormalizedTurn(facing);
		this.facing = (this.facing + rot) % 360;
		if (this.facing < 0){
			this.facing += 360;
		}
		this.diffPilot.rotate(rot);
		this.diffPilot.reset();
		this.diffPilot.travel(dist, immediateReturnAfterRotate);
		
	}
	
	/**
	 * returns tachocount from the left then right motors in order
	 * @return
	 */
	public int[] getTachCounts()
	{
		int[] temp = {left.getTachoCount(), right.getTachoCount()};
		return temp;
	}
	
	/**
	 * Stop the differential pilot from moving
	 */
	public void stop()
	{
		this.diffPilot.stop();
	}

	/**
	 * @return The direction (in degrees) the robot is facing. 0 = North, 90 = East, 180 = South, 270 = West
	 * 		   When the robot is started the direction it's facing is considered north until reset.
	 */
	public double getFacing() {
		return facing;
	}

	/**
	 * @param facing: The direction you want your robot to 'think' it's facing. 0 = North, 90 = East, 180 = South, 270 = West
	 *                When the robot is started the direction it's facing is considered north until reset.
	 *                DALE AND TUCKER WARN: It's best to probably not change it's facing to avoid confusion, but hey you're in charge.
	 */
	public void setFacing(double facing) {
		this.facing = facing;
	}
	
	/**
	 * A string version of the class will show facing in N E S W or number of degrees depending on where the bot is facing.
	 */
	@Override
	public String toString(){
		String output = "Facing: ";
		
		switch((int)facing){
		case 0: output.concat("NORTH"); break;
		case 180: output.concat("SOUTH"); break;
		case 90: output.concat("EAST"); break;
		case 270: output.concat("WEST"); break;
		default: output.concat(facing + " degrees"); break;
		}
		
		return output;
	}
}
