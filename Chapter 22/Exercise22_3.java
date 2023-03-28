// Author: Evie Welch
// date 02/23/23

import java.util.Scanner;


public class Exercise22_3 {


	public static int findSubString(String s1, String s2) {
		int start = 0;
		int c = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(Character.toLowerCase(s1.charAt(i)) == Character.toLowerCase(s2.charAt(c))) {
				c++;
				if(c == s2.length()) {
					return start;
				}
			} else {
				start = i + 1;
				c = 0;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String string = input.nextLine();
		System.out.print("Enter a sub-string: ");
		String subString = input.nextLine();
		System.out.println("mathed at index: " + findSubString(string, subString));
	}

}
