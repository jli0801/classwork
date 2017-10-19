package arrays;

public class Person {

	public static final String[] FIRST_START = {"Chr", "Am", "L", "J", "Th",
			"Br", "B", "V", "W"};
	public static final String[] FIRST_MIDDLE = {"ala", "ima", "e", "o"
			, "anna", "ess", "ola"};
	public static final String[] FIRST_END = {"na", "ck", "rain", "n", "ica", 
			"lius", "e", "les"};
	
	public static final String[] LAST_START = {"Bl", "Gr", "L", "Sh", "Th",
			"Br", "C", "V", "Z"};
	public static final String[] LAST_MIDDLE = {"an", "in", "ast", "en"
			, "ast", "own", "il"};
	public static final String[] LAST_END = {"g", "son", "les", "n", "i", 
			"en", "man", "on"};
	
	private String firstName;
	private String lastName;
	private Borough home; 
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		// TODO Auto-generated constructor stub
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void setInFirstPlace (Person f)
	{
		//backwards through an array
		for(int i = friends.length - 1; i <0 ; i--)
		{
			//move the friend from in front to back
			friends[i] = friends[i-1]; //CHECK: Does not go AIOOBE
		}
		friends[0] = f;
	}
	
	public void stateYourFriends() {
		String statement = ("My friends are ");
	/*	System.out.println("My friends are ");
		for (int i = 0; i < friends.length; i++)
		{
			if(i < friends.length -1) //last friend
			{
			System.out.println(friends[i].firstName + ", ");
			}
			else
			{
				System.out.println(" and " + friends[i].firstName);
			}
		}*/
		for(int i =0; i< friends.length -1; i++)
		{
			statement += friends[i].firstName + " " + friends[i].lastName + ", ";
		}
		statement += "and" + friends[friends.length -1 ];
		System.out.println(statement);
	}
	
	public void mingle(Person[] peers)
	{
		for(Person p: peers)
		{
			//cannot friend yourself
			if(p != this)
			{
				setInFirstPlace(p);
			}
		}
	}
	
	public String toString()
	{
		return ("My name is " + firstName + " "+ lastName + 
				" and I am from " +home+ ".");
	}

	
}
