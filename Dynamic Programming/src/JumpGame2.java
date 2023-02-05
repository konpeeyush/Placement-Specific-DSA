import java.util.Arrays;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int jumps = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(n - 1, i + nums[i]); j++) {

                jumps = Math.min(jumps, dp[j]);
            }
            if (jumps != Integer.MAX_VALUE) {
                dp[i] = jumps + 1;
            }
        }
        return dp[0];
    }

    private static int jumps(int[] nums) {
        int farthest = 0;
        int current = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i==current)
            {
                current=farthest ;
                jumps++ ;
            }
        }
        return jumps;
    }
}

