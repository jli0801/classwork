package recursion;

public class TowerHanoi {

	private static int disks;
	private static String start;
	private static String helper;
	private static String end;
	private static String result;
	
	public TowerHanoi() {
		disks = 3;
		start = "start pole";
		helper = "helper pole";
		end = "end pole";
		result = "";
	}

	public static void main(String[] args) {
		
		result = solve(3, "start", "helper", "end");
		System.out.println(result);
	}

	private static String solve(int n, String start, String helper, String end) {
		if(n==1)
		{
			return start + " moves to " + end + "\n";
			
		}
		else
		{
			String part1, part2, part3;
			part1 = solve(n-1, start, helper, end) + "\n";
			part2 = start + " moves to " + end + "\n";
			part3 = solve(n-1, helper, end, start) + "\n";
			return part1 + part2 + part3;
		}
		
	}

}
