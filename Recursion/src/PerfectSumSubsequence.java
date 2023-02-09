import java.util.ArrayList;

public class PerfectSumSubsequence {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        System.out.println(perfectSum(arr, arr.length, sum));

    }

    public static ArrayList<ArrayList<Integer>> perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> wrapper = new ArrayList<>();
//        helper(ans, wrapper, 0, 0, sum, arr, n);

        helper2(ans, wrapper, 0, 0, sum, arr, n);
        System.out.println("Total number of subsequence are: " + ans.size());
        return ans;
    }

    private static boolean helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> wrapper, int index, int currSum, int sum, int[] arr, int n) {
        if (index == n) {
            if (sum == currSum) {
//                condition satisfied
                ans.add(wrapper);
                return true;
            }
//            condition not satisfied
            return false;
        }
        wrapper.add(arr[index]);
        if (helper(ans, wrapper, index + 1, currSum + arr[index], sum, arr, n)) return true;

        wrapper.remove(wrapper.size() - 1);
        if (helper(ans, wrapper, index + 1, currSum, sum, arr, n)) return true;
        return false;
    }

    private static void helper2(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> wrapper, int index, int currSum, int sum, int[] arr, int n) {
        if (index == n) {
            if (sum == currSum) ans.add(wrapper);
            return;
        }

        int element = arr[index];
        wrapper.add(element);
        helper2(ans, wrapper, index + 1, currSum + element, sum, arr, n);

        wrapper.remove(wrapper.size() - 1);
        helper2(ans, wrapper, index + 1, currSum, sum, arr, n);
    }
}

//The purpose of making the helper function boolean type so that it can return only one subsequence
