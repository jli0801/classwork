package caveExplorer;

import java.util.Scanner;

public class CaveRoom {
	
	private String description; //what does it hold
	private String direction; //what doors can we used
	private String contents; //symbol what is in the room "X"
	private String defaultContents; //when you're not in the room

	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	private static Scanner inputSource = new Scanner(System.in);
	
	//constants 
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" "); 
		contents = defaultContents;
		//all arrays are instantiated w/ null
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	public static String getInput(){
		return inputSource.nextLine();
	}
	
	//every door that is not null. append a string to where it us.
	//no doors are not  null then no way out
	public void setDirections() {
		//hint to check if a door is null, use: doors[0] == null OR USE 
		//doors[0] != null
		String directions = "";
		boolean doorFound = false;
		for(int i = 0; i <doors.length; i++)
		{
			if(doors[i] != null)
			{
				doorFound = true;
				directions += "There is a " + doors[i].getDescription() + " to the " + toDirection(i) + "."
						+ doors[i].getDetails() + "/n"; 
			}
		}
		if(!doorFound)
		{
		directions += "There is no way out. You're trapped."; 
		}
		
	}
	//converts an int to a directions: 
	//0 -> North
	//1 -> East
	//without if statement 
	public static String toDirection(int dir)
	{
		String[] directions = {"the North", "the East", "the South", "the West"};
		//when i say no long if else statements, this is how 
		return directions[dir];
	}

	public void enter()
	{
		contents = "X";
		
	}
	
	public void leave()
	{
		contents = defaultContents;
	}
	
	public void setConnection(int direction, CaveRoom anotherRoom, Door door)
	{
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections(); //updates directions
	}
	
	
	public void interpretInput(String input)
	{
		while(!isValid(input))
		{
			System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
			input = CaveExplorer.in.nextLine();
			
		}
		int direction = "wdsa".indexOf(input);
		/*
		 * convert wasd to direction
		 */
		
		goToRoom(direction);
		
	}

	private boolean isValid(String input) {
		String directionWASD = "wdsa";
		return directionWASD.indexOf(input) != -1 && input.length() == 1;
	}

	/*public static void setUpCaves()
	{
		edit your caves
	}*/ 
	public void goToRoom(int direction)
	{
		//make sure there us a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null && 
				doors[direction].isOpen()	)
		{
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			
		}
		else
		{
			System.err.println("You can't do that!");
		}
	}
	public static int oppositeDirection(int dir) {
		int[] oppDir = {2,3,0,1};
		return oppDir[dir];
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public static void setUpCaves() {
		//Size of Caves
		CaveExplorer.caves = new CaveRoom[6][6];
		CaveRoom[][] c = CaveExplorer.caves; //shortcut for accessing CaveExplorer
		//Populate with default caves
		for(int row = 0; row < c.length; row++)
		{
			for(int col = 0; col < c[row].length; col++)
			{
				c[row][col] = new CaveRoom("This cave has coordinates "
						+ row + ", " + col + ".");
			}
		}
		
		
	}

}
