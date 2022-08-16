package sorting;

public class SelectionSort {

	public static void main(String arrs[]) {
		int[] nums = {9, 6, 8, 10, 15, 24, 16, 11};
		selectionSort(nums);
		for(int i = 0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	private static int[] selectionSort(int[] nums) {
		
		int length = nums.length;
		for(int i = 0; i<length; i++) {
			int minIndex = i;
			for(int j = i+1; j<length; j++) {
				if(nums[j]<nums[minIndex]) {
					minIndex = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
		}
		return nums;
		
	}
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
