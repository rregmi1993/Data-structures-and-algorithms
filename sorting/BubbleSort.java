package sorting;


public class BubbleSort {
	
	public static int[] bubbleSort(int [] nums){
		int length = nums.length;
		for(int i = 0; i<length- 1; i++) {
			boolean flag = false;
			for(int j = 0; j <length - i - 1; j++) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					flag = true;
				}
				if(!flag) {
					break;
				}
			}
		}
		return nums;

	}
	
	public static void main(String args[]) { 
		    int[] nums = {2, 1, 8, 3, 5, 9, 10};
		    bubbleSort(nums);
		    for (int i = 0; i < nums.length; i++) {
		      System.out.println(nums[i]);
		    }
	}
}

// time complexity of bubble sort algo is O(n^2)
// space complexity - O(1)