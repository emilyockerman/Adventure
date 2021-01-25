/*
* Player.java
* Author: Emily Ockerman
* Submission Date: November 8, 2018
*
* Purpose: Creates a class that describes the actions and attributes of objects of type player
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
CSCI 1301: Project 4 Page 5
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

public class Player {
	
	//INSTANCE VARIABLES
	private Lamp theLamp;
	private Key theKey;
	int xCoord, yCoord;
	
	
	//SETTER FOR X COORDINATE VALUE
	public void setXCoord(int xCoord)
	{
		this.xCoord = xCoord;
	}
	
	//SETTER FOR Y COORDINATE VALUE
	public void setYCoord(int yCoord)
	{
		this.yCoord = yCoord;
	}
	
	//SET LAMP = SETS LAMP VALUE
		public void setLamp(Lamp theLamp) {
			this.theLamp = theLamp;
		}
		
	//SET KEY = SETS KEY VALUE
		public void setKey(Key theKey) {
			this.theKey = theKey;
		}
		
	//GET LAMP METHOD = TRANSFERS LAMP TO USER IF FOUND IN ROOM
	public Lamp getLamp() {
			return theLamp;
	}
	
	//GET KEY METHOD = TRANSFERS KEY TO USER IF FOUND IN ROOM
	public Key getKey() {
			return theKey;
	}

}
