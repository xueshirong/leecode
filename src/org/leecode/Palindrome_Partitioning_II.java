package org.leecode;

public class Palindrome_Partitioning_II {
	public int minCut(String s) {
        int n = s.length();
        if (s == null || n == 0)
            return 0;
        //state
        int[] f = new int[n + 1];
        boolean[][] isp = new boolean[n][n];
        //init
        for (int i = 0; i <= n; i++)
            f[i] = i;
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                if ((i - j < 2 || isp[j+1][i-1]) && s.charAt(i) == s.charAt(j))
                    isp[j][i] =  true;//here is [j][i], from j to i
            }
        }
        //function
        for (int i = 1; i < n + 1; i++){
            for (int j = 0; j < i; j++){
                if (isp[j][i-1])
                    f[i] =  Math.min(f[i], f[j] + 1);
            }
        }
        return f[n] - 1;
    }
}
