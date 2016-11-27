package org.leecode;

public class Interleaving_String {
	//Given three strings: s1, s2, s3, determine whether s3 is formed by 
	//the interleaving of s1 and s2.
	//refer:http://www.cnblogs.com/imjustice/p/solve_Interleaving_String_in_leetcode.html
	/**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        //corner case
        if (m + n != s3.length())
            return false;
        //state
        boolean[][] path = new boolean[m+1][n+1];
        
        //init
        path[0][0] = true;
        for (int i = 1; i < m + 1; i++){//init 1st col
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && path[i - 1][0] ==  true)
                path[i][0] = true;
        }
        for (int j = 1; j < n + 1; j++){//init 1st row
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && path[0][j - 1] == true)
                path[0][j] = true;
        }
        
        //function
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if ((s3.charAt(i + j - 1) == s1.charAt(i - 1) && path[i - 1][j]) ||
                   (s3.charAt(i + j - 1) == s2.charAt(j - 1) && path[i][j - 1]))
                    path[i][j] = true;
            }
        }
            
            
        return path[m][n];
    }
}
