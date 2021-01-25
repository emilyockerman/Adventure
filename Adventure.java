/*
* Adventure.java
* Author: Emily Ockerman
* Submission Date: November 8, 2018
*
* Purpose: main method in which the classes map, room, player, lamp, chest, and key can do their ~thang~
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

import java.util.Scanner;

public class Adventure {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//declaration of variables
		Player player = new Player();
		Map map = new Map();
		int xCoord = 0, yCoord = 0;
		player.setXCoord(0);
		player.setYCoord(0);
		String command;
		boolean locked;
		
		//initial welcome statement
		System.out.println("Welcome to UGA Adventures: Episode I\n" + 
				"The Adventure of the Cave of Redundancy Adventure\n" + 
				"By: Emily Ockerman\n");
		
		System.out.println(map.getRoom(xCoord, yCoord).getDescription());
		
		//runs until player is woefully murdered by the grue or finds and opens the chest
		boolean alive = true, won = false;
		while (alive && !won)
		{
			//game starts with player in first room (0,0)
			command = input.nextLine();
			
			//GAME OVERRRR
			//if room is dark and user either has the lamp and it's not lit or doesn't have the lamp and their next command isn't light lamp they perish
			if ((command.equalsIgnoreCase("west") || command.equalsIgnoreCase("east")) && map.getRoom(xCoord, yCoord).isDark() && (player.getLamp() == null || (!(player.getLamp() != null && player.getLamp().isLit()))))
			{
				System.out.println("You have stumbled into a passing grue, and have been eaten.");
				alive = false;
			}
			//successfully light lamp and proceed with the rest of the game!
			else
			{
				//LOOK: looks around room and returns directions player can move 
				if (command.equalsIgnoreCase("look"))
				{
					if (map.getRoom(xCoord, yCoord).isDark() && (player.getLamp() == null || (!(player.getLamp() != null && player.getLamp().isLit()))))
					{
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else
					{
						System.out.println(map.getRoom(xCoord, yCoord).getDescription());
						if (map.getRoom(xCoord, yCoord).getLamp() != null)
						{
							System.out.println("There is an old oil lamp here that was made long ago");
						}
						if (map.getRoom(xCoord, yCoord).getKey() != null)
						{
							System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
						}
						if (map.getRoom(xCoord, yCoord).getChest() != null)
						{
							System.out.println("There is a large, wooden, massive, oaken chest here with the word \"CHEST\" carved into it");
						}
						System.out.print("Exits are: ");
						if(map.getRoom(xCoord, yCoord).canGoEast())
						{
							System.out.println("east");
						}
						if(map.getRoom(xCoord, yCoord).canGoSouth())
						{
							System.out.println("south");
						}
						if (map.getRoom(xCoord, yCoord).canGoWest())
						{
							System.out.println("west");
						}
						if(map.getRoom(xCoord, yCoord).canGoNorth())
						{
							System.out.println("north");
						}
					}
				}
				//GET LAMP: gets lamp for user if there's a lamp in the room
				else if(command.equalsIgnoreCase("get lamp"))
				{
					if (map.getRoom(xCoord, yCoord).getLamp() != null)
					{
						System.out.println("OK");
						player.setLamp(map.getRoom(xCoord, yCoord).getLamp());
						map.getRoom(xCoord, yCoord).clearLamp();
					}
					else
					{
						System.out.println("No lamp present");
					}
				}
				//LIGHT LAMP: lights lamp if user has one in their possession
				else if(command.equalsIgnoreCase("light lamp"))
				{
					if(player.getLamp() != null)
					{
						player.getLamp().setLampLit();
						System.out.println("OK");
					}
					else
					{
						System.out.println("You don't have a lamp to light");
					}
				}
				//NORTH: moves user north
				else if(command.equalsIgnoreCase("north"))
				{
					if(map.getRoom(xCoord, yCoord).canGoNorth())
					{
						xCoord -= 1;
						if (map.getRoom(xCoord, yCoord).isDark() && (player.getLamp() == null || (!(player.getLamp() != null && player.getLamp().isLit()))))
						{
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
						else
						{
							System.out.println(map.getRoom(xCoord, yCoord).getDescription());
						}
					}
					else
					{
						System.out.println("Can't go that way.");
					}
				}
				//SOUTH: moves user south
				else if(command.equalsIgnoreCase("south"))
				{
					if(map.getRoom(xCoord, yCoord).canGoSouth())
					{
						xCoord += 1;
						if (map.getRoom(xCoord, yCoord).isDark() && (player.getLamp() == null || (!(player.getLamp() != null && player.getLamp().isLit()))))
						{
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
						else
						{
							System.out.println(map.getRoom(xCoord, yCoord).getDescription());
						}
					}
					else
					{
						System.out.println("Can't go that way.");
					}
				}
				//EAST: moves user east
				else if(command.equalsIgnoreCase("east"))
				{
					if(map.getRoom(xCoord, yCoord).canGoEast())
					{
						yCoord += 1;
						if (map.getRoom(xCoord, yCoord).isDark() && (player.getLamp() == null || (!(player.getLamp() != null && player.getLamp().isLit()))))
						{
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
						else
						{
							System.out.println(map.getRoom(xCoord, yCoord).getDescription());
						}
					}
					else
					{
						System.out.println("Can't go that way.");
					}
				}
				//WEST: moves user west
				else if(command.equalsIgnoreCase("west"))
				{
					if (map.getRoom(xCoord, yCoord).canGoWest())
					{
						yCoord -= 1;
						if (map.getRoom(xCoord, yCoord).isDark() && (player.getLamp() == null || (!(player.getLamp() != null && player.getLamp().isLit()))))
						{
							System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
						}
						else
						{
							System.out.println(map.getRoom(xCoord, yCoord).getDescription());
						}
					}
					else
					{
						System.out.println("Can't go that way.");
					}
				}
				//GET KEY: gives user key if key is present
				else if(command.equalsIgnoreCase("get key"))
				{
					if (map.getRoom(xCoord, yCoord).getKey() != null)
					{
						System.out.println("OK");
						player.setKey(map.getRoom(xCoord, yCoord).getKey());
						map.getRoom(xCoord, yCoord).clearKey();
					}
					else
					{
						System.out.println("No key present");
					}
				}
				//OPEN CHEST: opens chest if user has key and chest is present
				else if(command.equalsIgnoreCase("open chest"))
				{
					if (map.getRoom(xCoord, yCoord).getChest() != null && !(map.getRoom(xCoord, yCoord).getChest().isLocked()))
					{
						System.out.println(map.getRoom(xCoord, yCoord).getChest().getContents());
						won = true;
					}
					if (map.getRoom(xCoord, yCoord).getChest() != null && map.getRoom(xCoord, yCoord).getChest().isLocked())
					{
						System.out.println("The chest is locked.");
					}
					if (map.getRoom(xCoord, yCoord).getChest() == null)
					{
						System.out.println("No chest present.");
					}
				}
				//UNLOCK CHEST: unlocks chest if user has key and if chest is present
				else if(command.equalsIgnoreCase("unlock chest"))
				{
					if (player.getKey() != null && map.getRoom(xCoord, yCoord).getChest() != null)
					{
						player.getKey().use(map.getRoom(xCoord, yCoord).getChest());
						locked = false;
						System.out.println("OK");
					}
					if (player.getKey() == null && map.getRoom(xCoord, yCoord).getChest() != null)
					{
						System.out.println("Need a key to do any unlocking!");
					}
					if (map.getRoom(xCoord, yCoord).getChest() == null)
					{
						System.out.println("No chest to unlock.");
					}
				}
				//INVALID COMMAND: if user enters command not listed above
				else
				{
					System.out.println("I'm sorry I don't know how to do that.");
				}
			}
		}
			
		
	}
}
