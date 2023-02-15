import java.util.*;

public class Subset2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subset2(arr));
    }

    private static ArrayList<List<Integer>> subset2(int[] arr) {
        Arrays.sort(arr);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        List<Integer> wrapper = new ArrayList<>();
        helper(arr, 0, ans, wrapper);
        return ans;
    }

    private static void helper(int[] arr, int idx, ArrayList<List<Integer>> ans, List<Integer> wrapper) {
        ans.add(new ArrayList<>(wrapper));
        for (int i = idx; i < arr.length; i++) {
//            To remove duplicates
            if (i != idx && arr[i - 1] == arr[i]) continue;
//            Include
            wrapper.add(arr[i]);
            helper(arr, idx + 1, ans, wrapper);
//            Exclude
            wrapper.remove(wrapper.size() - 1);
        }
    }
}
