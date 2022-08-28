package recursion;

public class FabonacciSeries {
	
	
	public static void main(String arrs[]) {
		System.out.println(fab(10));
	}

	private static int fab(int n) {
		
		if(n>2) {
			return fab(n-1) + fab(n-2);
		}else {
			return 1;
		}
	}

}
