package arrays;

public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[120];
		populate(people);
	//	people[0] = new Thing("toaster oven");
	//	Person[] group = selectGroup(people, 3);
	/*	for(Object p: group)
		{
			System.out.println(p);
		}*/
		
	//	analyzeCommonalities(people, group);
		for(Person p: people)
		{
			p.mingle(people);
			System.out.println(p);
			p.stateYourFriends();
		}
		}
	
	private void analyzeCommonalities(Person[] people, Person[] group) {
		double averageCommonality = 0;
		double trials = 500;
		double totalNum = 0; 
		for(int i = 0; i < trials; i++)
		{
			group = selectGroup(people, people.length);
			int sameSeat = countCommonalities(people, group);
			totalNum += sameSeat;
		}
		averageCommonality = totalNum/trials;
		System.out.println("After " + trials + " trails, shuffling " + people.length 
				+ " people, on average, " + averageCommonality + " people end up "
						+ "in the same position");
	}

	//returns number of items that are the same array in same location(index)
	private int countCommonalities(Object[] arr1, Object[] arr2)
	{
		//PRECONDITION: same length 
		int haveInCom = 0;
		for( int i = 0; i < arr1.length; i++)
		{
			if(arr1[i] == arr2[i]) //same element in same index
			{
				haveInCom++;
			}
		}
		return haveInCom;
	}

	private void populate(Object[] people) {
		for(int i = 0; i< people.length; i++)
		{
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE
					,Person.FIRST_END);
			String lastName =  randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE
					,Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA:
			//In an Object array, you can have multiple data type inside
			//as long as it's a sub class
			// Unlike a primitive array (int, boolean) 
			if(Math.random() <.6)
			{
				int money = (int)(Math.random()*20 +1)*10000;
				people[i] = new Athlete(firstName, lastName, home, money);
			}
			else
			{
				people[i] = new Person(firstName, lastName, home);
			}
		//	people[i] = new Person(firstName, lastName, home);
		}
		
	}

	public Person[] selectGroup (Person[] population, int length)
	{
		Person[] group = new Person[length];
		for(int i =0; i < length; i++)
		{
			Person toAdd = randomPerson(population); //type is a person, random person
			while (alreadyContains(group, toAdd)) //use while to get different person each time
				{
					toAdd = randomPerson(population);
				}
			group[i] = toAdd;
		}
		return group;
	}
	
	private Person randomPerson(Person[] population)
	{
			int randomNumber = (int)(Math.random()*population.length);
			return population[randomNumber];
	}
	//array is created during runtime unlike strings which is a class. Array's are a class too. 
	//Array is class
	private boolean alreadyContains(Person[] population, Person p)
	{
		for(int i =0; i< population.length; i++)
		{
			if(population[i] == p)
			{
				return true;
			}
		}
		return false;
	}
	
	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {

		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int) (Math.random() *a.length)];
	}

	public static void main(String[] args) {
	
		ObjectMain obj = new ObjectMain();

	}

}
