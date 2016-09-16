package hackerrank;

import java.util.Scanner;

public class Kangaroo {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        if (v1 <= v2){//here is a tricky point. must cautious on the V1 = v2
            System.out.print("NO");
        }else if((x2 - x1) % (v1 - v2) != 0){
            System.out.print("NO");
        }else{
            System.out.print("YES");
        }
    }
}
