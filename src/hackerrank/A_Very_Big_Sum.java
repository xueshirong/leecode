package hackerrank;

import java.util.Scanner;

/**
 * intput:
 * 5
   1000000001 1000000002 1000000003 1000000004 1000000005
 * @author Xue
 *
 */
public class A_Very_Big_Sum {
	public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int sum = 0;
        double intMax = Math.pow(2.0,31.0) - 1.0;
        double intMin = -1 * Math.pow(2.0, 31.0);
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if (intMax - arr[arr_i] < sum){
                sum = (int)intMax;
                break;
            }else if (intMin - arr[arr_i] > sum){
                sum = (int)intMin;
                break;
            }else{
                sum = sum + arr[arr_i];
            }                
        }
        System.out.print(sum);
    }
	public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        long sum = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();            
            sum = sum + arr[arr_i];                            
        }
        System.out.print(sum);
    }
}
