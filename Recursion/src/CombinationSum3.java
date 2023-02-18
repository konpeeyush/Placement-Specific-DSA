import java.util.*;

public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(combinationSum3(k, n));
    }
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> wrapper = new ArrayList<>();
        solve(1, k, n, ans, wrapper);
        return ans;
    }
    private static void solve(int idx, int k, int n, List<List<Integer>> ans, List<Integer> wrapper) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(wrapper));
            return;
        }
        if (k == 0 || n == 0) return;
        for (int i = idx; i <= 9; i++) {
            wrapper.add(i);
            solve(i + 1, k - 1, n - i, ans, wrapper);
            wrapper.remove(wrapper.size() - 1);
        }
    }
}
