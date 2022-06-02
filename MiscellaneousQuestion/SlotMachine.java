package MiscellaneousQuestion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SlotMachine {
	
	private static List<String> inputList = Arrays.asList("712", "246", "365", "312");
	//private static List<String> inputList = Arrays.asList("137", "115", "364", "115", "724");
	// ["731", "511", "643", "511", "742"]
	// k * log(k) * n
	// k * n
	
	public static void main(String arrs[]) {
	
		int sizeOfList = inputList.size();
		int result = 0;
		for(int k = 0; k<3; k++) {
			int previousNumber = 0;
			for(int i = 0; i < sizeOfList; i++) {
				char[] chars = inputList.get(i).toCharArray();
				Arrays.sort(chars);	
				System.out.println(chars);
				int maxNumber = chars[k] - '0';
				if(maxNumber>previousNumber) {
					result = result + maxNumber - previousNumber;
					previousNumber = maxNumber;
				}
				
			}
			}
		
		System.out.println("Final anaswer is :" + result);
		
	}

}
