package arrays;

import java.util.Arrays;

public class PassByValueExamples {

	public static void main(String[] args) {
	String s = "Hello";
	Person p = new Person("Random", "Dude", Borough.NY_BOROUGHS[0]);
	int x = 5;
	int[] arr = {1,2,3};
	//changeEVERYTHING(s,x,arr);
	//test1(p,x,arr);
	test2(p);
	test3(arr);
	
	System.out.println("p is now " +p +", x is " + x+
			", arr is " + Arrays.toString(arr));
	
	}

	//CAN CHANGE reference via SETTER
	private static void test2(Person p) {
	//	String name = p.getFirstName();
		p.setFirstName("Original");
		
	}

	private static void test1(Person p, int x, int[] arr) {
		String name = p.getFirstName();
		name = "Original"; 
		//doesn't change
	}

	//change arrays via local variable
	private static void test3(int[] arr)
	{
		arr[0] = 999;
		arr[1] = 998;
	}
	private static void changeEVERYTHING(String s, int x, int[] arr) {
		s = "Goodbye";
		x = -5;
		arr = new int[2];
		arr[0] = -1;
		arr[1] = -2;
		//doesn't change
	}

}
