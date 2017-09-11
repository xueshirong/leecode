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
		System.out.println(reduceString(br.readLine()));
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
}
