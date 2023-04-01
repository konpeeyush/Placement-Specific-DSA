public class SumOfBeautyOfAllStrings {
    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(sumOfBeauty(s));
    }

    public static int sumOfBeauty(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] bucket = new int[26];
            for (int j = i; j < s.length(); j++) {
                bucket[s.charAt(j) - 'a']++;
                ans += getBeauty(bucket);
            }
        }
        return ans;
    }

    private static int getBeauty(int[] bucket) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                max = Math.max(max, bucket[i]);
                min = Math.min(min, bucket[i]);
            }
        }
        return max - min;
    }
}
