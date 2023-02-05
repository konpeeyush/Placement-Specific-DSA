public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {5, 8, 7, 1, 9};
        System.out.println("Length of LIS is " + lis(arr));
    }

    private static int lis(int[] arr) {
        int[] lis = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] <= lis[j]) {
                    lis[i] = lis[j] + 1;
                }
            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
