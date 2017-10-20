package arrays2D;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Array2DSampler test = new Array2DSampler();
		
		String[][] picture = new String[10][20];
		printPicture(picture);
		
		int[] arr = {4,3,2,1,0};
		changeNeighbors(arr, 4);
		System.out.println(Arrays.toString(arr));
	}

	private static void printPicture(String[][] picture) {
		// TODO Auto-generated method stub
		
	}

	//Heavily test concept ArrayIndexOutOfBoundsException
	private static void changeNeighbors(int[] arr, int i) {
		arr[i]++;
		if(i == 0) //start of the code
		{
			arr[i+1]++;
		}
		if(i == arr.length -1) //last one 
		{
			arr[i-1]++;
		}
		if(i != 0 && i != arr.length -1) //in between
		{
			arr[i+1]++;
			arr[i-1]++;
		}
	}

}
