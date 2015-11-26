package edu.bismarckstate.shortestpathhelper.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;


/**
 * @author Midpipps
 * @version 1.0
 */
public class FileParser {
	/**
	 * Reads the data from a file and returns it as a vector of strings pertaining to each line of the file.  File must end with a space and Line Feed Otherwise you may end up with Out Of Memory Exceptions
	 * @param fileName String name of the file
	 * @return Vector of the lines of the file
	 * @throws FileParserException Thrown for any errors such as IOExceptions, Not able to read from file, and generic exceptions
	 */
	public static Vector<String> readFile(String fileName) throws FileParserException
	{
		File data = new File(fileName);
		Vector<String> returnData = null;
		if (data.canRead())
		{
			returnData = new Vector<String>();
			try{
				InputStream is = new FileInputStream(data);
				DataInputStream din = new DataInputStream(is);
				BufferedReader br = new BufferedReader(new InputStreamReader(din));
				String temp = "";
				while((temp = br.readLine()) != null) {
					if (temp.equalsIgnoreCase(" "))
					{
						break;
					}
					returnData.addElement(temp);
				}
				din.close();
			}catch(IOException ioe){
			    throw new FileParserException("IOException see inner exception", ioe);
			}catch(Exception ex){
				throw new FileParserException("Generic Exception see inner exception", ex);
			}
		}else{
			throw new FileParserException("Could not read from file");
		}
		return returnData;
		
	}
}
