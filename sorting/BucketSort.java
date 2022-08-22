package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	
	public static void bucketSort(int[] nums) {
		int bucketNumbers = (int) Math.ceil(Math.sqrt(nums.length));
	    int maxValue = Integer.MIN_VALUE;
	    int minValue = Integer.MAX_VALUE;
	    
		for(int value: nums) {
	      if (value < minValue) {
	        minValue = value;
	      } else if (value > maxValue) {
	        maxValue = value;
	      }
	    }

	    ArrayList<Integer>[] buckets = new ArrayList[bucketNumbers];
	    
	    
	    for(int i = 0; i < buckets.length; i++) {
	      buckets[i] = new ArrayList<Integer>();   
	    }
	    
	    
	    for(int value: nums) {
	      int bucketNumber = (int) Math.ceil ((value *  bucketNumbers) / maxValue);
	      // exception: for value = 0, we have to insert to the first bucket
	      if (bucketNumber == 0) bucketNumber = 1;
	      buckets[bucketNumber-1].add(value);
	    }
	        
	    //Sort Each Bucket
	    for(ArrayList<Integer> bucket: buckets) {
	      Collections.sort(bucket);
	    }
	    
	    
	    //Merge all buckets
	    int index = 0;
	    for(ArrayList<Integer> bucket: buckets) {
	      for(int value: bucket) {
	        nums[index] = value;
	        index++;
	      }
	    }
	}
	
	
	
	
	
	public static void main(String[] arrs) {
		int[] nums ={80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50, 100, 110};
		bucketSort(nums);
	    System.out.println("----------------------");
	    for (int i = 0; i < nums.length; i++) {
	      System.out.println(nums[i]);
	    }
	}

}

// if the number are not uniformly distributed then this bucket sort algorithm will not work properly 

