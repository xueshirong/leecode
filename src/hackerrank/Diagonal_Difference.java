package hackerrank;

import java.util.Scanner;

public class Diagonal_Difference {
	
	/*
	 * 
3
11 2 4
4 5 6
10 8 -12
	 */
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int sum1 = 0;
        int sum2 = 0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
                if (a_i == a_j){
                    sum1 = sum1 + a[a_i][a_j];
                }
                if (a_i + a_j == n-1){
                    sum2 = sum2 + a[a_i][a_j];
                }
            }
        }
        System.out.print(Math.abs(sum2 - sum1));
    }
}
