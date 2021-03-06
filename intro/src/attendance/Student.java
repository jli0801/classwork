package attendance;

public class Student implements Attendee
{
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
		studentHere = false; 
	}
	
	public boolean isPresent()
	{
		return studentHere; //getter
	}
	
	public void setPresent(boolean present)
	{
		this.studentHere = present; //setter
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
		if(first.toLowerCase().equals(firstN.toLowerCase()) && last.toLowerCase().equals(lastN.toLowerCase())) //case sensitive
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
		if(last.toLowerCase().equals(lastN.toLowerCase())) //case sensitive
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
		String endString;
		endString = "";
		if (lastN.length() > 20)
		{
			endString = endString + lastN.substring(0, lastN.length()-3) + "...";
		}
		else
		{
		endString += lastN;
		}

		int numberOfSpaceL = 20;
		
		
		for(int i = 0; i < numberOfSpaceL - lastN.length() + 1 ; i++)
		{
			endString += " ";
		}
		
		if (firstN.length() > 20)
		{
			endString = endString + firstN.substring(0, firstN.length()-3) + "...";
		}
		else
		{
		endString += firstN;
		}

		int numberOfSpaceF = 40;
		
		for(int x = 0; x < numberOfSpaceF - firstN.length() + 1; x++)
		{
			endString += " ";
		}
		
		if(studentHere)
		{
			endString += "PRESENT\n";
		}
		else
		{
			endString += "ABSENT\n";
		}
		return endString;
	}
	
 
}
