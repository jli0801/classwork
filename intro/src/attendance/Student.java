package attendance;

public class Student {
	/**In addition to the following methods, please create a class called 
	 * 'Student' that implements the Attendee interface and include a 
	 * constructor that takes two parameters: firstName and lastName.
	 * Use these values to instantiate corresponding fields.
	 * @return
	 */
	private boolean studentHere;
	private String firstN;
	private String lastN;
	
	public Student(String firstName,String lastName){
		this.firstN = firstName;
		this.lastN = lastName;
	}
	
	public boolean isPresent()
	{
		return studentHere;
	}
	
	public void setPresent(boolean present)
	{
		boolean presentS = this.isPresent();
		if(present != presentS) // true != false
		{
			presentS = present; 
		}
	}
	
	public String getFirstName()
	{
		return firstN;
	}

	public String getLastName()
	{
		return lastN;
	}
	
	public boolean mathces(String first, String last)
	{
		if(first.equals(firstN) && last.equals(lastN)) //case sensitive
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean matches(String last) 
	{
		if(last.equals(lastN)) //case sensitive
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public String getReportString()
	{
		String endString = lastN;
		int numberOfSpace = 20;
		for(int i = 0; i < numberOfSpace - lastN.length() - 2; i++)
		{
			endString += " ";
		}
		endString += firstN;
		for(int x = 0; x < numberOfSpace - firstN.length() - 2; x++)
		{
			endString += " ";
		}
		
		if(studentHere)
		{
			endString += "PRESENT";
		}
		else
		{
			endString += "ABSENT";
		}
		return endString;
	}
}
