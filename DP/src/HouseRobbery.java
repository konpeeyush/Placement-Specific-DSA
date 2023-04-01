public class HouseRobbery {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return solveMem(nums, dp, n - 1);
    }

    private static int solveMem(int[] nums, int[] dp, int n) {
        if (n < 0) return 0;
        if (dp[n] != 0) return dp[n];
        int ans = Math.max
                (
//                Include the current house
                        solveMem(nums, dp, n - 2) + nums[n],
//                Exclude the current house
                        solveMem(nums, dp, n - 1)
                );
        dp[n] = ans;
        return ans;
    }
}
