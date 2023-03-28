// author: Evie Welch
// date: 02/23/23

import java.util.Scanner;

public class Exercise22_1 {

	public static String getMaxConsecutiveString(String s) {
//		int[][] sizes = new int[s.length()][2]; // sizes[] doesn't need to be that big but whatever.
		int startIndex = 0;
		int endIndex = 0;
		int largestStart = 0;
		int largestEnd = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0) {
				// if the last character is <= current
				if ((Character.toLowerCase(s.charAt(i - 1)) <= Character.toLowerCase(s.charAt(i)))) {
					// increase the end index
					endIndex = i;
					// check if start and end index are larger than the largest substring
					if (endIndex - startIndex > largestEnd - largestStart) {
						largestStart = startIndex;
						largestEnd = endIndex;
					}
				} else {
					// if the last char is larger, update the start index
					startIndex = i;
				}
			}
		}
		
		return s.substring(largestStart, largestEnd +1); // substring isn't inclusive of the last index so add 1
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String userInput = input.next();
		// input: abcabcdgabxy
		System.out.print("The largest consecutive substring is: " + getMaxConsecutiveString(userInput));
		
	}

}
