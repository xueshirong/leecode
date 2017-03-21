package org.leecode;

public class Edit_Distance {
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < m + 1; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}
		return dp[n][m];
	}

	public int minDistance2(String word1, String word2) {
		// state
		int m = word1.length();
		int n = word2.length();
		int[][] path = new int[m + 1][n + 1];
		// init
		for (int i = 0; i < n + 1; i++) {
			path[0][i] = i;
		}
		for (int j = 0; j < m + 1; j++) {
			path[j][0] = j;
		}
		// function
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					path[i][j] = path[i - 1][j - 1];
				else
					path[i][j] = 1 + Math.min(path[i - 1][j - 1], Math.min(path[i][j - 1], path[i - 1][j]));
			}
		}
		return path[m][n];
	}

	// f[i][j]表示A的前i个字符最少要几次编辑可以变成B的前j个字符
	public int minDistance1(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		if (m == 0)
			return n;
		if (n == 0)
			return m;
		// state
		int[][] f = new int[m + 1][n + 1];
		// initial
		for (int i = 0; i < m + 1; i++) {
			f[i][0] = i;// i times delete
		}
		for (int j = 0; j < n + 1; j++) {
			f[0][j] = j;// j times insert
		}
		// function
		for (int i = 1; i < m + 1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 1; j < n + 1; j++) {
				char c2 = word2.charAt(j);
				if (c1 == c2) {
					f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i][j - 1] + 1, f[i - 1][j] + 1));
				} else {
					f[i][j] = Math.min(f[i - 1][j - 1] + 1, Math.min(f[i][j - 1] + 1, f[i - 1][j] + 1));
				}
			}
		}
		return f[m][n];
	}
}
