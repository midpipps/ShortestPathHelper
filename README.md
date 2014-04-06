ShortestPathHelper
==================

A set of helpers for a shortest path assignment. The assignment is to take in a set of movement instructions and find the shortest path to the ending position.

This project will handle the menus for entering the data and will handle very basic movements for the students.

There will be at least 2 ways for movement instructions to be entered through a manual entry using the brick itself to enter data using the buttons on the brick and through browsing files on the brick to allow for instructors to preload movement instruction files onto the brick and select those files from the menu system.

Movement will be a very basic subset of possible movements for the robot and will be based on the default design for the robot.  If students want to modify the robot or do more complicated movements with the robot they will need to use the lejos api to accomplish this.

Still working on fleshing out this document.
[Design Documentation](https://docs.google.com/document/d/1-kHfXjxf7MLncgvYOeGCE64rBsVljTH4mVPJ7MtAusE/edit?usp=sharing)

All files used for entry must now end with a blank space and a line feed.  This is to fix an issue with the Lejos InputStream that will run off the end of the file and never stop reading causing the system to throw out of memory exceptions.
