package javaTheHardWay;

public class Animal {
	private String description;
	private Trait trait1;
	private Trait trait2;
	private int age;
	private boolean mated;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Trait getTrait1() {
		return trait1;
	}

	public void setTrait1(Trait trait1) {
		this.trait1 = trait1;
	}

	public Trait getTrait2() {
		return trait2;
	}

	public void setTrait2(Trait trait2) {
		this.trait2 = trait2;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String toTring()
	{
		return "a " + age + " year old, "+ trait1 + ", " + trait2 + " " + description;
	}
	public Animal(String description, Trait trait1, Trait trait2)
	{
		this.trait1 = trait1;
		this.trait2 = trait2;
		while(trait2.equals(trait1))
		{
			trait2 = new Trait();
		}
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
