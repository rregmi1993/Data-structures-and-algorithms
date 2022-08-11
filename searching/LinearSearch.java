package searching;

public class LinearSearch {
	
	public int search(int number, int[] arrs) {
		
		for(int i = 0; i< arrs.length; i++) {
			if(arrs[i] == number) return i;
		}
		
		return -1;
	}
	
	
	public static void main(String arr[]) {
		int[] numArray = {1,3,6,9,7,10,4,11,10};
		int searchNumebr = 4;
		LinearSearch linearSearch = new LinearSearch();
		System.out.println("Number is present in index : " + linearSearch.search(searchNumebr, numArray));
	}

}

// time - O(n) & space - O(1)