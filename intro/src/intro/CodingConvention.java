package intro;

public class CodingConvention {
	
	//FIELDS ARE AT THE TOP!!
	private String name; //DECLARE FIELDS ONLY, INSTANTIATE IN CONSTRUCTOR!
	private String description; 
	/* DONT DO THIS
	 * private String name = "what";
	*/
	/*
	 * constructor is like method; return type = an instance of class a constructor must ALWAYS be named after 
	the class 
	*/
	public CodingConvention(int names, int descriptionIndex) {
		//Instantiate variables now: (only in constructor) 
		
		//there are two variables called "name" the local variable and the field 
		//distinguish between the two by using the reserved word "this" 
		name = IntroMain.NAMES[names];
		
		//this is a static call to a constant
		description = IntroMain.DESCRIPTIONS[descriptionIndex];
	}
	
	//normal method "void" = doesn't return anything
	public void doStuff() {
		String output = name + description;
		System.out.println(output);
	}
}
