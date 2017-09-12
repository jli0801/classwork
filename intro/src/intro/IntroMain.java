package intro; //package declaration: matches folder where the file is located

//class header
public class IntroMain {

	//first method executed. static because independent of instances 
	public static void main(String[] args) {
		//this is the declaration of an instance of CodingConvention
		//it is being instantiated
		//note the use of the word new; used when calling constructors
		CodingConvention conventionInstance = new CodingConvention();
		//a note on local variables: NOT FIELDS (HAS-A Relationship)
		//after the method, they are destroyed
		
		
		//instance method call (the method belongs to the instance not class) 
		//depends on the individual
		conventionInstance.doStuff();
			
	}
}
