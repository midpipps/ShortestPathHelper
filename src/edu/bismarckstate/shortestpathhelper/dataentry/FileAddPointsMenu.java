/**
 * 
 */
package edu.bismarckstate.shortestpathhelper.dataentry;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.bismarckstate.shortestpathhelper.util.MovementInstruction;
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
			
			File data = new File(menuOptions.get(selection));
			if (data.canRead())
			{
				try{
					InputStream is = new FileInputStream(data);
					DataInputStream din = new DataInputStream(is);
					BufferedReader br = new BufferedReader(new InputStreamReader(din));
					String strLineDirection;
					while((strLineDirection = br.readLine()) != null) {
						String strLineDistance = br.readLine();
						if (strLineDistance != null)
						{
							MovementInstruction mi = new MovementInstruction();
							mi.setDirection(Double.parseDouble(strLineDirection.trim()));
							mi.setDistance(Double.parseDouble(strLineDistance.trim()));
							super.instructions.add(mi);
						}
						if (!br.ready()){
							//no idea why this works but it does so meh;
							break;
						}						
					}
					din.close();
				}catch(IOException ioe){
					System.out.println("error:" + ioe.getMessage());
					Button.ENTER.waitForPressAndRelease();
				}catch(Exception ex){
					System.out.println("error:" + ex.getMessage());
					Button.ENTER.waitForPressAndRelease();
				}
			}
		}	
		return new AddTypeMenu(super.instructions);
	}
}
