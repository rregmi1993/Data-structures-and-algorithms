package searching;

public class BinarySearch {

	public int Search(int target, int[] numsArr) {
		int left = 0; 
		int right = numsArr.length - 1;
		
		while(left <= right) {
			
			int middle = (left + right) / 2;
			
			if(numsArr[middle] == target) {
				return middle;
			}
			else if(numsArr[middle] < target) {
				left = middle + 1;
			}
			else {
				right = middle - 1;
			}
			
		}
		return -1;
	}
	
	
	public static void main(String arrs[]) {
		int[] numArray = {1,3,6,9,7,10,4,11,10};
		int searchNumebr = 6;
		BinarySearch bs = new BinarySearch();
		System.out.println("Number is present in index : " + bs.Search(searchNumebr, numArray));
	}
}

// binary search only work for sorted array 
// searching - O(log(n)) and space - O(1)

