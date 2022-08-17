package sorting;

public class InsertionSort {

	private static int[] insertionSort(int[] nums) {
		
		for(int i = 1; i < nums.length; i++) {
			
			int temp = nums[i];
			int j = i;
			while(j>0 && nums[j-1] > temp) {
				nums[j] = nums[j-1];
				j--;
				 
			}
			
			nums[j] = temp;
		}
		
		return nums;
	}
	
	public static void main(String args[]) { 
		
		int[] nums = {11, 3, 2, 9, 7, 12, 21, 5, 1};
		
		insertionSort(nums);
		
		for(int i = 0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
