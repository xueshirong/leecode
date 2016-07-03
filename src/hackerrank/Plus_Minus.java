package hackerrank;

import java.util.Scanner;

public class Plus_Minus {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if (arr[arr_i] > 0)
                positive++;
            else if (arr[arr_i] < 0)
                negative++;
            else
                zero++;
        }
        System.out.println((double)positive/(double)n);
        System.out.println((double)negative/(double)n);
        System.out.println((double)zero/(double)n);
    }
}