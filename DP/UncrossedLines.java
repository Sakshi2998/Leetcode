package DP;

public class UncrossedLines {
	public int maxUncrossedLines(int[] A, int[] B) {

		int[][] dp = new int[A.length + 1][B.length + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (A[i - 1] == B[j - 1])
					dp[i][j] = Math.max(1 + dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		return dp[A.length][B.length];
	}
}
