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
	
	public Person(String first, String last, Borough home) {
		// TODO Auto-generated constructor stub
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	
	public String toString()
	{
		return ("My name is " + firstName + " "+ lastName + 
				" and I am from " +home+ ".");
	}

	
}
