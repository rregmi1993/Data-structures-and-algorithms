package sorting;

public class QuickSort {

	public static void quickSort (int[] nums, int start, int end) {
		
		if (start<end) {
			int pivot = helper(nums, start, end);
			quickSort(nums, start, pivot -1);
			quickSort(nums, pivot + 1, end);
		}
	}
	
	public static int helper(int nums[], int s, int e){
		int pivot = e;
		int i = s - 1;
		for(int j = s; j<=e; j++) {
			if(nums[j]<=nums[pivot]) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		int[] nums = {10, 3, 12, 5, 8, 4, 3, 11, 2, 19, 7, 8, 100};
		quickSort(nums, 0, nums.length-1);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	}

