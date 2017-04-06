package hackerrank;

import java.util.Scanner;

public class TWO_D_Array_DS {
	private static Scanner in;
	public static void main(String[] args) {
        int n = 6;        
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        
        int sum = Integer.MIN_VALUE;
        for (int row = 0; row < arr.length - 2; row++){
            for (int col = 0; col < arr.length - 2; col++){
                int temp = 0;
                int index = -1;
                for (int trow = row; trow < row + 3; trow++){
                    for (int tcol = col; tcol < col + 3; tcol++){   
                        index = index + 1;
                    	if (index == 3 || index == 5)
                    		continue;
                        temp = temp + arr[trow][tcol];                        
                    }
                }
                if (temp > sum)
                    sum = temp;
            }
        }
        System.out.print(sum);
    }
}
