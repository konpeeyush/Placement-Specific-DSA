import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> wrapper = new ArrayList<>();
        helper(candidates, 0, target, ans, wrapper);
        return ans;
    }

    private static void helper(int[] arr, int idx, int target, List<List<Integer>> ans, List<Integer> wrapper) {

        if (target == 0) {
            ans.add(new ArrayList<>(wrapper));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            //    To handle if there are any duplicates, also to ensure that first index element is picked
            if (i > idx && arr[i] == arr[i - 1]) continue;
            //    if element is greater than target
            if (arr[i] > target) break;

            wrapper.add(arr[i]);
            helper(arr, i + 1, target - arr[i], ans, wrapper);
            wrapper.remove(wrapper.size() - 1);
        }
    }
}
