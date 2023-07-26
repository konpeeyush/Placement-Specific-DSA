public class Knapsack01 {
    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;
        int n = 3;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;

                else if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        System.out.println(dp[n][W]);
    }
}
