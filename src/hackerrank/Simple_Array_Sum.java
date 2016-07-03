package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Simple_Array_Sum {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();        
        int sum = 0;
        for (int i = 0; i < size; i++){
            sum = sum + scan.nextInt();
        }		
        System.out.println(sum);

    }
}
