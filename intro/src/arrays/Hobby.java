package arrays;

public class Hobby extends Thing {

	public Hobby(String description) {
		super(description);
		
	}

	public static Hobby randomHobby() {
		Hobby[] h = {new Hobby("Playing Video Games"), 
				new Hobby ("dancing"),
				new Hobby ("cooking"),
				new Hobby ("watching anime") };
		
		return h[(int) (Math.random()*h.length)];
	}

}
