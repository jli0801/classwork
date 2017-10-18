package arrays;

import java.util.Arrays;

public class ArraysMain {
	private int[] testArray;
	private String[] suits;
	private String[] values;
	
		public ArraysMain()
		{
	
	/*	populate(testArray);
		countOccurences(testArray, 2, 12); //if we roll the dice two times*/
	//	populate1ToN(testArray);
	//	swap(testArray, 0, 1);
	//	shuffle(testArray);
		//reverseOrder(testArray);
	//	System.out.println(Arrays.toString(testArray));
	//		tuesdayMethods();
			wednesdayMethods();
		}

		
		private void wednesdayMethods() {
		
			int[] diceRolls = new int[9999999];
			populate(diceRolls);
			int[] data = longestConsecutiveSeqAndIndex(diceRolls);
			int longest = data[0];
			System.out.println("The longest sequence is " + longest + " rolls"
					+ " It happened on roll# " + data[1] + " the seqeunce was: "
					+ Arrays.toString(subArray(diceRolls, data[1],data[0])) 
					+ ".");
		}

		/*
		 * BIG IDEA: usually a method return one piece of data (int,boolean) 
		 * if we ever want more than one piece of data, one way of doing that is by suing an array. 
		 * method that returns a length and position is shown below (BOTH INTS)
		 */
		private int[] longestConsecutiveSeqAndIndex(int[] arr) {
			//use an int[] to store data
			int[] data = new int[2]; //element at 0 will be length, 1 = position 
			data[0] =1;
			
		
			int currentCount = 1;
			
			for( int i = 0 ; i < arr.length; i++) //start
			{
				while (i + currentCount < arr.length &&
						isConsecutive(arr,i,i+currentCount) )
					{
						//see if it's the longest; return the length
						currentCount++;
					}
				if(currentCount > data[0])
				{
					data[0] = currentCount;
					//also store index where this sequence started
					data[1] = i;
				}
				i = i + currentCount - 1;
				currentCount = 1;
			}
			return data;
		}


		private int longestConsecutiveSequence(int[] arr)
		{
			int maxLength = 1;
			int currentCount = 1;
			
			for( int i = 0 ; i < arr.length; i++) //start
			{
				while (i + currentCount < arr.length &&
						isConsecutive(arr,i,i+currentCount) )
					{
						//see if it's the longest; return the length
						currentCount++;
					}
				if(currentCount > maxLength)
				{
					maxLength = currentCount;
				}
				i = i +currentCount -1;
				currentCount = 1;
			}
			return maxLength;
		}
		
		private void tuesdayMethods() {
			int[] orderTest = {1,2,3,4,5,1,6,7,8,9,10};
			//frontToBack(orderTest);
		//	cycleThrough(orderTest, 5);
			System.out.println((longestConsecutiveSequence(orderTest) + " is the longest."));
			
		}
		
	

		
			
			
		
		private boolean isConsecutive(int[]arr, int start, int end)
		{
	
			for( int i = start; i<end; i++)
			{
				if(arr[i] != arr[i+1])
				{
					return false;
				}
			}
			return true;
		}
		private void cycleThrough(int[] orderTest, int i) {
			for( int x=0; x< i; x++)
			{
				frontToBack(orderTest);
			}
			
		}


		private void frontToBack(int[] orderTest) {
	
			int x = orderTest[0];
			for(int i = 0; i<orderTest.length-1; i++)
			{
				orderTest[i] = orderTest[i+1];
			}
			orderTest[orderTest.length-1] = x;
		}


		private void warmUpMethods()
		{
			int[] orderTest = {1,2,3,4,5,6,7,8,9,10};
			reverseOrder(orderTest);
			System.out.println(Arrays.toString(orderTest));
			System.out.println(Arrays.toString(subArray(orderTest, 3, 4)));
		}
	private void cardMethods()
	{
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



	private void reverseOrder(int[] arr)
	{
		for(int i = 0; i < arr.length/2; i++ )
		{
			swap(arr,i,arr.length-1-i);
		}

	}
	
	private int[] subArray(int[] arr,int  psn, int length)
	{
		int[] sub = new int[length];
		for(int i =0; i <length; i++)
		{
			sub[i] = arr[i+psn];
		}
		return sub;
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
