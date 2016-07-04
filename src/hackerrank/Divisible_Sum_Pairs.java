package hackerrank;

import java.util.Scanner;

public class Divisible_Sum_Pairs {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        int num = 0;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (i < j && (a[i] + a[j])%k == 0){
                    num++;
                }
            }
        }
        System.out.print(num);
    }
}
