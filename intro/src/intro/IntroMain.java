package intro; //package declaration: matches folder where the file is located

//class header
public class IntroMain {
	
	public static final String[] DESCRIPTIONS = {
			" is a student at BTHS" , " is a teacher at BTHS"};
	
	public static final String[] NAMES = {
			"Jessica" , "Stephanie", "Mandy", "Nockles"};
	
	//first method executed. static because independent of instances 
	public static void main(String[] args) {
		//this is the declaration of an instance of CodingConvention
		//it is being instantiated
		//note the use of the word new; used when calling constructors
		
		int numberOfPeople = 10;
	
		for(int i = 0; i < numberOfPeople; i++){
			
			CodingConvention conventionInstance = new CodingConvention(i%4, i%2);
			conventionInstance.doStuff();
			
		}
		//a note on local variables: NOT FIELDS (HAS-A Relationship)
		//after the method, they are destroyed
		
		
		//instance method call (the method belongs to the instance not class) 
		//depends on the individual
	
	}
}
