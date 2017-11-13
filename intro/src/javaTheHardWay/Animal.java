package javaTheHardWay;

public class Animal {
	private String description;
	private Trait trait1; //read only 
	private Trait trait2; //read only
	private int age; //read only
	private boolean mated;
	//read only means that you can't change it. it's permanent
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Trait getTrait1() {
		return trait1;
	}

	

	public Trait getTrait2() {
		return trait2;
	}

	

	public int getAge() {
		return age;
	}


	public boolean hasMated() {
		return mated;
	}


	public void setMated(boolean mated) {
		this.mated = mated;
	}
	public void reset()
	{
		mated = false;
	}

	public Animal() {
		chooseTraits();
		description = getName();
		age = 0;
	
	}

	private void chooseTraits() {
		trait1 = new Trait();
		trait2 = new Trait();
		while(trait2.equals(trait1))
		{
			trait2 = new Trait();
		}
		
	}

	public String toString()
	{
		return "a " + age + " year old, "+ trait1 + ", " + trait2 + " " + description;
	}
	
	public Animal(String description, Trait trait1, Trait trait2)
	{
		this.trait1 = trait1;
		this.trait2 = trait2;
		while(trait1.equals(trait2))
		{
			trait2 = new Trait();
		}
		this.description = description;
	}
	
	private String getName() {
		return "animal";
	}

	public static void main(String[] args) {
		for(int i =0; i <10; i++)
		{
			Animal someAnimal = new Animal();
			System.out.println(someAnimal);
		}

	}
	public void increaseAge()
	{
		age++;
	}
	public void act()
	{
		System.out.println(this + " is sleeping");
		mated = true;
	}

}
