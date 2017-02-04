package org.leecode.Test;

public class Longest_Palindromic_Substring {
	/*
	Given a string s, find the longest palindromic substring in s. 
	You may assume that the maximum length of s is 1000.
	
	Example:
	Input: "cbbd"
	Output: "bb"
	 */
	//思路： dp[i][j]表示从i到j是否回文。
	//dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
	public String longestPalindrome(String s) {
        //corner case
        if (s == null || s.length() < 2)
            return s;
        int len = s.length();
        boolean[][] dp = new boolean[1000][1000];
        String res = "";
        for (int i = len - 1; i > -1; i--){//i is from back to start
            for (int j = i; j < len; j++){//j is from i to end
                if ((s.charAt(i) == s.charAt(j)) && ((j - i < 3) || dp[i + 1][j -1]))
                    dp[i][j] = true;
                //dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
