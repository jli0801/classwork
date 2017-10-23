package caveExplorer;

public class CaveRoom {
	
	private String description; //what does it hold
	private String direction; //what doors can we used
	private String contents; //symbol what is in the room "X"
	private String defaultContents; //when you're not in the room

	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
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

	//every door that is not null. append a string to where it us.
	//no doors are not  null then no way out
	public void setDirections() {
		//hint to check if a door is null, use: doors[0] == null OR USE 
		//doors[0] != null
		for(int i = 0; i <doors.length; i++)
		{
			if(doors[i] != null)
			{
				System.out.println("There is a " + Door.getDescription() + " to " + toDirection(i)); 
			}
		}
		
		System.out.println( "There is no way out. You're trapped."); 
		
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

}
