import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> wrapper = new ArrayList<>();
        helper(candidates, target, 0, wrapper, ans);
        return ans;
    }

    private static void helper(int[] arr, int target, int idx, List<Integer> wrapper, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(wrapper));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] > target) {
                continue;
            }
            wrapper.add(arr[i]);
            helper(arr, target - arr[i], i, wrapper, ans);
            wrapper.remove(wrapper.size() - 1);
        }
    }
}
