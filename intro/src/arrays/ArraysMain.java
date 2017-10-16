package arrays;

import java.util.Arrays;

public class ArraysMain {
	private int[] testArray;
	private String[] suits;
	private String[] values;
		public ArraysMain()
		{
		testArray = new int[50];
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		values =  new String[13];
		for(int i = 0; i< values.length; i++ )
		{
			values[i] = ""+(i+1);
		} 
		values[0] = "Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
	/*	populate(testArray);
		countOccurences(testArray, 2, 12); //if we roll the dice two times*/
	//	populate1ToN(testArray);
	//	swap(testArray, 0, 1);
	//	shuffle(testArray);
		System.out.println(Arrays.toString(testArray));
		}

		
		
	private String[] printDeck() {
	String[] deck = new String[52];
	int index = 0;
			for(String suit: suits)
			{
				for(String value: values )
				{
					deck[index] = (value + " of "+ suit);
					index++;
				}
			}
			return deck;
		}



	private void shuffle(int[] arr) {
			for( int i=0; i<arr.length ; i++)
			{
				swap(arr, i, (int)(Math.random()*arr.length));
			}
			
		}



	private void swap(int[] arr, int i, int j) {
			int x = arr[i];
			arr[i] = arr[j];
			arr[j] = x;
		}



	private void populate1ToN(int[] arr) {
			// TODO Auto-generated method stub
		int num =0;
		for( int i = 0; i <arr.length; i++)
		{
			num++;
			arr[i] = num;
		}
		//arr[i] = (i+1);
		}



	private void countOccurences(int[] arr, int start, int end) {
		//why create array with this length?
		int[] counter = new int [end - start +1]; //11 possible outcomes
		for(int value: arr)
		{
			//why value - start?
			counter[value - start]++;
			//assign value 
		}
		for(int i =0; i <counter.length; i++)
		{
			//counter length = 10 so 2 to 12.
			System.out.println("The value " + (i+start) + " was rolled "
					+counter[i] + " times." );
		}
		}



	public void populate (int[] arr)
	{
	//correct way:	
		for( int i = 0; i <arr.length; i++)
		{
			arr[i] = diceRoll(2);
		}
		//incorrect way (does nothing);
	/*	for (int value:arr)
		{
			value = diceRoll(2);
		}*/
	}
	public void arrayNotes() {
		
		
		
			//two ways to construct an array:
			int[] firstWay = {0,1,2,3,4,5};
			//this way will only work with the declaration 
			//will not work:
			//firstWay = {6,5,4,3,2};
			
			//primitive will always have values equal to 0 if 
			//nothing is inside. 
			//OBJECT ARRAYS are not populated, they're null
			String[] secondWay = new String[5];
			//you can go on in creating values at each index. 
			secondWay[0] = "a";
			secondWay[1] = "b"; 
			
			//TWO WAYS TO ITERATE THROUGH AN ARRAY
			for( int i =0 ; i< secondWay.length; i++)
			{
				System.out.println("The # " + i+ " element is " + 
			secondWay[i]);
			}
			//for each int in secondWay
			for (String value: secondWay)
			{
				System.out.println("Element is " + value);
			}
	}
	

	public static void main(String[] args) {
		ArraysMain sample = new ArraysMain();
		//Arrays are collections of primitives and Objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		
		//Size cannot be edited/changed
		
		//Elements of an Array are references to Objects In 
		//other words, changing an element of an array changes the 
		//reference NOT the object. 
	}
	public int diceRoll(int n)
	{
		int sum = 0;
		for( int i = 0; i < n; i++)
		{
			sum += (int)(Math.random()*6) +1;
		}
		return sum;
	}

}
