package Yelp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string of characters change all occurrences of
 * two or more consecutive "e"s with a sigle "e"
 * Example:
 * Input: 'asdheeeeskaeeeleee'
 * Output: 'asdheskaele'
 *
 */
public class Reduce_String {
	public static void main(String[] args) throws IOException{
		//asdheeeeskaeeeleee - asdheskaele
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String input = br.readLine();
		String input = "asdheeeeskaeeeleee";
		System.out.println(reduceString(input));
		System.out.println(reduceString2(input));
	}

	public static String reduceString(String inputString) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputString.length(); i++){
			if (i > 0 && inputString.charAt(i) == inputString.charAt(i - 1))
				continue;
			sb.append(inputString.charAt(i));
		}
		return sb.toString();
	}
	
	public static String reduceString2(String input){
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			if (slow > 0 && array[slow - 1] == array[fast]) {
				while (fast < array.length && array[fast] == array[slow - 1]) {
					fast++;
				}
			} else {
				array[slow] = array[fast];
				slow++;
				fast++;
			}
		}
		return new String(array, 0, slow);
	}
}
