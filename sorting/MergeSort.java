package sorting;

public class MergeSort {
	
	public static void MergeSorts(int nums[], int left, int right) {
		
		if(right>left) {
			int mid = (left + right)/2;
			MergeSorts(nums, left, mid);
			MergeSorts(nums, mid+1, right);
			merge(nums, left, mid, right);
		}
	}
	
	public static void merge(int num[], int left, int mid, int right) {
		int [] leftTempArr = new int[mid - left +2];
		int [] rightTempArr = new int[right - mid + 1];
		
		for(int i=0; i<=mid-left; i++)
			leftTempArr[i]= num[left+i];
		
		for(int i=0; i<right-mid; i++)
			rightTempArr[i]= num[mid+1+i];
			

		leftTempArr[mid - left + 1]= Integer.MAX_VALUE;
		rightTempArr[right - mid] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		
		for (int k = left; k <= right; k++) {
			if (leftTempArr[i] < rightTempArr[j]) {
				num[k] = leftTempArr[i];
				i++;
			} else {
				num[k] = rightTempArr[j];
				j++;
			}
		}
	}
	

	public static void main(String arrs[]) {
		int[] array = {10, 3, 12, 5, 8, 4, 3, 11, 2, 19, 7, 8};
		MergeSorts(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
