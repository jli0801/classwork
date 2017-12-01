package recursion;

public class Recursion {

	 private static int primeNum;
	 private static int total;
	 
	 public static void main(String[] args){
		 int value = 5;
		 primeNum = 0;
		 System.out.println(value+"! is equal to "+factorial(value));
		 System.out.println(value+ " has "+countPrimeFactors(value, 2)+" prime factors.");
		 }

		 public static int countPrimeFactors(int value, int testPrime) {
		
		
			 if(value%testPrime == 0) //goes in
			 {
				 primeNum++;
				 countPrimeFactors(value/testPrime, testPrime); 
			 }
			
			return primeNum;
		 }

		 public static int factorial(int value) {
		 
		 if(value == 0)
		 {
			 total = 1;
		 }
		 else
		 {
			total = value*factorial(value-1);
		 }
		 
		 return total;
		 }
	
	
}
