package arrays2D;

public class Array2DSampler {
 private String[][] pic;
	public Array2DSampler() {
	
		pic = new String[10][20];
		print(pic);
	}
	private void print(String[][] pic2) {
		//standard for loops for 2d array
		for( int row = 0; row < pic.length; row++)
		{
			//these for loops gets test points
			for(int col =0; col < pic[row].length; col++) 
			{
				System.out.print(pic[row][col]);
			}
			System.out.println("");	//line break
			
		}
		for(String[] row : pic) //array
		{
			for(String col : row) //string
			{
				System.out.print(col);
			}
			System.out.println("");	//line break
		}
		
	}

}
