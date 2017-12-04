package recursion;

public class TowerHanoi {

	private static int disks;
	private static String start;
	private static String helper;
	private static String end;
	private static String result;
	
	
	public static void main(String[] args) {
		disks = 3;
		start = "start pole";
		helper = "helper pole";
		end = "end pole";
		result = "";
		
		result = solve(disks, start, helper, end);
		System.out.println(result);
	}

	private static String solve(int n, String start, String helper, String end) { // 1 2 3
		if(n==0)
		{
			return start + " moves to " + end;
			
		}
		else
		{
			String part1, part2, part3;
			part1 =  solve(n-1, start, end, helper) + "\n"; //move all to helper (helper is now end)
			part2 =  start + " moves to " + end + "\n";
			part3 =  solve(n-1, helper, start, end) + "\n"; //move all from helper to end (end is now end)
			return part1 + part2 + part3;
		}
		
	}

}
