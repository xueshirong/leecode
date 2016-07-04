package hackerrank;

import java.util.Scanner;

public class Save_the_Prisoner {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int caseS = in.nextInt();
        for (int i = 0; i < caseS; i++){
        	int N = in.nextInt();
            int M = in.nextInt();
            int S = in.nextInt();
            if (M+S-1 <= N){
                System.out.println(M+S-1);
            }else if((M+S-1)%N == 0){
                System.out.println(N);
            }else{
                System.out.println((M+S-1)%N);
            }
        }
    }
}
