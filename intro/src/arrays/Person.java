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
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		// TODO Auto-generated constructor stub
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
		nickname = createNickname(firstName);
	}
	
	public String getFirstName() {
		return firstName; //source to generate getter setter
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//PASS BY VALUE the parameters of a method contain only values
	// not references, when they're changed, the reference to
	//original object doesn't change
	public static String createNickname(String name)
	{
		String nickname = "";
		//int indexSecondVowel = 0;
		int vowelCount = 0;
		//String[] vowels = {"a", "e", "i", "o", "u"};
		for(int i =0; i<name.length(); i++) {
			
			if(isVowel(name.substring(i, i+1)) )
			{
				vowelCount++; 
				if(vowelCount != 2)
				{
					nickname += name.substring(i, i+1);
				}
				else
				{
					return nickname;
				}
			}
			else
			{
				nickname += name.substring(i, i+1);
			}
		}
		return name;
	}
	
	private static boolean isVowel(String x)
	{
		return (x.toLowerCase().equals("a") || x.toLowerCase().equals("e") ||
				x.toLowerCase().equals("i") || x.toLowerCase().equals("o")
				|| x.toLowerCase().equals("u"));
		
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
				". Call me " + nickname + 
				". and I am from " +home+ ".");
	}

	
}
